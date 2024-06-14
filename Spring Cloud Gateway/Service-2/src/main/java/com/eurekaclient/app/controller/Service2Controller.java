package com.eurekaclient.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Controller {

	@GetMapping("/test")
	public String sayHi() {
		return "Hello from service2";
	}
}
