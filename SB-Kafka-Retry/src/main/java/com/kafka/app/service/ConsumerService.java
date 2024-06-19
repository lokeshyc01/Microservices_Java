package com.kafka.app.service;

import java.util.List;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.kafka.app.dto.Customer;

@Service
public class ConsumerService {
	Logger log = LoggerFactory.getLogger(getClass());

	@RetryableTopic(attempts = "4") // 4-1 //create 3 topic internally [lokesh-techie-retry-0] [lokesh-techie-retry-1] [lokesh-techie-retry-2]
	@KafkaListener(topics = "lokesh-techie", groupId = "jt")
	public void consumer2(Customer customer, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.OFFSET) String offset) {

		
			log.info("received {} from {} offset {}", customer.toString(), topic, offset);

			List<String> restricedIpList = Stream.of("123.0.0.1", "32.08.03.2", "123.12.32.2").toList();

			if (restricedIpList.contains(customer.getIpAddress())) {
				throw new RuntimeException("Restriced Ip Address");
			
		
		}
	}

	@DltHandler
	public void listenDLT(Customer customer, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.OFFSET) String offset) {
		log.info("dlt invoked");
		log.info("DLT received {} from {} offset {}", customer.toString(), topic, offset);

	}

}
