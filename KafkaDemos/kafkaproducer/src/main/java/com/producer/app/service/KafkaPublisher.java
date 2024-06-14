package com.producer.app.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.producer.app.dto.Customer;

@Service
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void publishMessage(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("random-topic-3",message);
		
//		future.whenComplete((result,exception)->{
//			if(exception == null) {
//				System.out.println("sent message[ "+message+"]"
//						+"with offset ["+result.getRecordMetadata().offset()+"]"
//						);
//			}
//			else {
//				System.out.println(exception.getMessage());
//			}
//		});
		
		future.thenAccept(data -> System.out.println(data.getRecordMetadata().offset()));
	}
	
	public void publishMessage(Customer customer)
	{
		CompletableFuture<SendResult<String, Object>> future=template.send("random-topic-3",customer);
		
		future.thenAccept((data)->{
			System.out.println(data.getRecordMetadata().offset());
		});
	}
}
