package com.internalcommunication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internalcommunication.app.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	private ConsumerService service;
	
	@GetMapping("/getmsg/{name}")
	public String sayHi(@PathVariable String name)
	{
		return service.getMsg(name);
	}
}
