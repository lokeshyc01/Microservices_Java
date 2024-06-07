package com.demo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class HelloController {

	
	@GetMapping("/greet/{name}")
	public String sayHello(@PathVariable String name)
	{
		return "hello "+name;
	}
}
