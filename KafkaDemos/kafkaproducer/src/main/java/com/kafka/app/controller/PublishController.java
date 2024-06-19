package com.kafka.app.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.app.dto.Customer;
import com.kafka.app.service.KafkaPublisher;

@RestController
@RequestMapping("/publish")
public class PublishController {
	@Autowired
	KafkaPublisher publisher;
	
	@Autowired
	KafkaTemplate<String, Object> template;

	@GetMapping("/{message}")
	public String getMethodName(@PathVariable String message) {
		for(int i = 0 ; i < 10000; i++) {
			publisher.publishMessage(message+" "+i);			
		}
		return "message published";
	}
	
	
	@GetMapping("/partition/{partition}")
	public String publishMessagetoPartition(@PathVariable int partition) {
		for(int i = 0 ; i < 10000;i++) {
			template.send("lokesh-techie", partition, null, "message "+i);
		}
		return "message published to partition "+partition;
	}
	@PostMapping
	public String publishMessage(@RequestBody Customer customer)
	{
		publisher.publishMessage(customer);
		return "Message Published";
	}

}
