package com.actuators.app.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping
	@RequestMapping("/sayHello/{name}")
	public String sayHello(@PathVariable String name)
	{
		LocalDateTime ldt = LocalDateTime.now();
		int hours = ldt.getHour();
		
		if(hours < 12) {
			return "good morning "+name;
		}
		return "good afternoon "+name;
	}
}
