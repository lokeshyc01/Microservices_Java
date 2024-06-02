package com.configclient.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${msg:config server is not working!!!}")
	private String msg;
	@GetMapping
	@RequestMapping("/dev")
	public String sayHi() {
		return msg;
	}
}
