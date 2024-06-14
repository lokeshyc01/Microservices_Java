package com.aspect.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspect.app.service.TestBussinessService;

@RestController
public class TestController {
	
	@Autowired
	TestBussinessService service;
	
	@GetMapping("/test")
	public String test() {
		
		service.test1();
		return "testing";
	}
}
