package com.producer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.app.dto.Customer;
import com.producer.app.service.KafkaPublisher;

@RestController
@RequestMapping("/publish")
public class PublishController {
	@Autowired
	KafkaPublisher publisher;

	@GetMapping("/{message}")
	public String getMethodName(@PathVariable String message) {
		for(int i = 0 ; i < 10000; i++) {
			publisher.publishMessage(message+" "+i);			
		}
		return "message published";
	}
	
	@PostMapping
	public String publishMessage(@RequestBody Customer customer)
	{
		publisher.publishMessage(customer);
		return "Message Published";
	}

}
