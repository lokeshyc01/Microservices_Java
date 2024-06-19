package com.kafka.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.kafka.app.dto.Customer;

@Service
public class ConsumerService {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@KafkaListener(topics = "lokesh-techie",groupId="jt",topicPartitions = {@TopicPartition(topic = "lokesh-techie",partitions = {"3"})})
	public void consumer2(String message) {
		log.info("consumer2 received msg => "+message);
		
	}
	@KafkaListener(topics = "random-topic-4",groupId = "lt")
	public void consumer1(Customer customer) {
		log.info("consumer1 received msg =>"+customer.toString());
	}
//	@KafkaListener(topics = "random-topic-3",groupId = "lt")
//	public void consumer2(String message) {
//		
//		log.info("consumer2 received msg =>"+message);
//	}
//	@KafkaListener(topics = "random-topic-3",groupId = "lt")
//	public void consumer3(String message) {
//		log.info("consumer3 received msg =>"+message);
//	}
//	@KafkaListener(topics = "random-topic-3",groupId = "lt")
//	public void consumer4(String message) {
//		log.info("consumer4 received msg =>"+message);
//	}
}
