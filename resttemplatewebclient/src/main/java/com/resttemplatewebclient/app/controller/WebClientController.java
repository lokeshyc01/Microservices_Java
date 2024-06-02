package com.resttemplatewebclient.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.resttemplatewebclient.app.dto.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class WebClientController {
	
	@Autowired
	private WebClient webclient;
	
	@GetMapping("/{id}")
	public Mono<Post> getById(@PathVariable Integer id) {
		
		Mono<Post> post = webclient.get()
							.uri("/posts/{id}", id)
							.retrieve()
							.bodyToMono(Post.class);
					
		post.subscribe(newPost ->{
			System.out.print(newPost);
		});
		
		System.out.print("respone => ended \n");
		return post;
	}
	
	@GetMapping("/all")
	public List<Post> getAllPost(){
		List<Post> posts = webclient.get()
							.uri("/posts")
							.retrieve()
							.bodyToFlux(Post.class)
							.collectList()
							.block();
//		
//		posts.subscribe(newPost -> System.out.println(newPost));
//		System.out.println("resposen ended");
		return posts;
	}
	
	@PostMapping("/create")
	public Post createPost(){
		Post post = new Post();
		post.setUserId(1);
		post.setBody("testing body");
		post.setId(101);
		post.setTitle("testing title");
		
	Post newPost = webclient.post()
							.uri("/posts")
							.body(Mono.just(post),Post.class)
							.retrieve()
							.bodyToMono(Post.class)
							.block();
	
		return newPost;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id)
	{
		webclient.delete()
		.uri("/posts/{id}",id)
		.retrieve()
		.bodyToMono(Void.class);
		
		System.out.println("eleement deleted");
	}
	
	@PutMapping("/put")
	public Post updatePost(){
		Post post = new Post();
		post.setUserId(1);
		post.setBody("testing body");
		post.setId(101);
		post.setTitle("testing title");
		
		Post newPost = webclient.put()
				.uri("/posts")
				.retrieve()
				.bodyToMono(Post.class)
				.block();
		
//		newPost.subscribe(newP->System.out.println(newP));
		return newPost;
	}

}
