package com.basicauth.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@GetMapping("/test")
	public String sayHi() {
		return "Jay Ganesh...";
	}
}
