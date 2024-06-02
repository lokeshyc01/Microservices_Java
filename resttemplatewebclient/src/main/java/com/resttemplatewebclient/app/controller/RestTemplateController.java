package com.resttemplatewebclient.app.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.resttemplatewebclient.app.dto.Post;

@RestController
@RequestMapping("/resttemplate")
public class RestTemplateController {

	@Autowired
	private RestTemplate resttemplate;
	
	
	/**
	 * Method to return specified post 
	 * @param id Integer 
	 * @return Post
	 */

	@GetMapping("/{id}")
	public ResponseEntity<Post> getById(@PathVariable Integer id) {
        
            UriComponents uri = UriComponentsBuilder
                .fromHttpUrl("https://jsonplaceholder.typicode.com/posts")
                .pathSegment("{id}")
                .buildAndExpand(id)
                .encode();

            System.out.println("Constructed URI: " + uri.toUriString());
//            ResponseEntity<Post> response = resttemplate.exchange(uri.toUriString(),
//                HttpMethod.GET, HttpEntity.EMPTY, Post.class);
//            
            Post post = resttemplate.getForObject(uri.toUri(), Post.class);
            System.out.print(post);
            return ResponseEntity.ok(post);
            
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Post>> getPosts(){
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		ResponseEntity<List<Post>> response = resttemplate
				.exchange(url, HttpMethod.GET,HttpEntity.EMPTY,new ParameterizedTypeReference<List<Post>>() {});
		
		
		return response;
	}
	
	@PostMapping
	public ResponseEntity<Post> post(){
		String url = "https://jsonplaceholder.typicode.com/posts";
		Post post = new Post();
		post.setId(12);
		post.setBody("rnado");
		post.setTitle("testing");
		post.setUserId(123);
//		ResponseEntity<Post> postEntity= resttemplate.postForEntity(url,post,Post.class);
		Post newPost = resttemplate.postForObject(url, post, Post.class);
		System.out.println(newPost);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		UriComponents uri = UriComponentsBuilder
		.fromHttpUrl(url)
		.pathSegment("{id}")
		.buildAndExpand(id)
		.encode();
		
		resttemplate.delete(uri.toUri());
		System.out.println("deletion completion");
	}

}
