package com.kafka.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafka.app.dto.Customer;

@Service
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void publishMessage(Customer customer)
	{
		CompletableFuture<SendResult<String, Object>> future=template.send("lokesh-techie",customer);
		
		future.whenComplete((data,exec) -> {
			System.out.println("sent "+data.getProducerRecord().value().toString());
		});
	}
}
