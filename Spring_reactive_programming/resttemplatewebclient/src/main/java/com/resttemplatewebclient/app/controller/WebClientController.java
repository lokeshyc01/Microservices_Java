package com.resttemplatewebclient.app.controller;

import java.time.Duration;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.resttemplatewebclient.app.dto.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/webclient")
public class WebClientController {
	
	@Autowired
	private WebClient webclient;
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Post>> getById(@PathVariable Integer id) {
		
		Mono<Post> post = webclient.get()
							.uri("/posts/{id}", id)
							.retrieve()
							.bodyToMono(Post.class);
					
		post.subscribe(newPost ->{
			System.out.print(newPost);
		});
		
		System.out.print("respone => ended \n");
		
		return new ResponseEntity<Mono<Post>>(post,HttpStatus.OK);
	}
	
	@GetMapping(value = "/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<Post>> getAllPost(){
		Flux<Post> posts = webclient.get()
							.uri("/posts")
							.retrieve()
							.bodyToFlux(Post.class);
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<Tuple2<Long, Post>> zip = Flux.zip(interval, posts);
		Flux<Post> fluxMap = zip.map(Tuple2::getT2);
//		posts.subscribe(newPost -> System.out.println(newPost));
//		System.out.println("resposen ended");
//		return posts.delayElements(Duration.ofMillis(1000));
		return new ResponseEntity<Flux<Post>>(fluxMap,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public Mono<Post> createPost(){
		Post post = new Post();
		post.setUserId(1);
		post.setBody("testing body");
		post.setId(101);
		post.setTitle("testing title");
		
	Mono<Post> newPost = webclient.post()
							.uri("/posts")
							.body(BodyInserters.fromValue(post))
							.retrieve()
							.bodyToMono(Post.class);
							
	
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
	
	@PutMapping("/put/{id}")
	public Mono<Post> updatePost(@PathVariable int id){
		Post post = new Post();
		post.setUserId(id);
		post.setBody("testing body");
		post.setId(101);
		post.setTitle("testing title");
		
		 Mono<Post> newPost = webclient.put()
				.uri("/posts/{id}",id)
				.retrieve()
				.bodyToMono(Post.class);
		
//		newPost.subscribe(newP->System.out.println(newP));
		return newPost;
	}

}
