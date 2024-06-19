package com.avro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avro.dto.Employee;
import com.avro.producer.KafkaAvroProducer;

@RestController
public class PublisherController {

	@Autowired
	private KafkaAvroProducer producer;
	
	
	
	@PostMapping("/events")
	public String sendMessge(@RequestBody Employee employee)
	{
		producer.send(employee);
		return "message published";
	}
}
