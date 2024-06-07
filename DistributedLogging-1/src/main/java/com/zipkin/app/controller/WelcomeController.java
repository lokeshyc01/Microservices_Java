package com.zipkin.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	Logger log = LoggerFactory.getLogger(WelcomeController.class);
	
	@GetMapping("/greet")
	public String greet() {
		log.info("******************GreetMethod()**********************");
		log.info("******************GreetMethod()***********************");
		return "Hello";
	}

}
