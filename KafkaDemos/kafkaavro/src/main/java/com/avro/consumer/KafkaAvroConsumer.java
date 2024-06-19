package com.avro.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.avro.dto.Employee;


@Service
public class KafkaAvroConsumer {
	
	private final static Logger log = LoggerFactory.getLogger(KafkaAvroConsumer.class);
	
	@KafkaListener(topics = "${topic.name}")
	public void consumer(ConsumerRecord<String, Employee> consumerRecord)
	{
		String key = consumerRecord.key();
		Employee emp = consumerRecord.value();
		log.info("avro message received fo rkey : "+ key + "value "+emp.toString());
	}
	
}
