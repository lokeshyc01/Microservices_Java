package com.internalcommunication.app.interservicecom_producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@GetMapping("/{name}")
	public String getMsg(@PathVariable String name) {
		
		return "Hello "+ name + " from prouducer";
	}

}
