package com.rabbitunicasting.app.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitunicasting.app.dto.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate template;

	@Value("${springboot.rabbitmq.exchange}")
	private String exchange;

	@Value("${springboot.rabbitmq.routingKey}")
	private String routingKey;
	
	
	public void send(Employee emp)
	{
		template.convertAndSend(exchange,routingKey,emp);
		System.out.println("------------------------------------------------");
		System.out.println("send mst to rabbit mq => "+emp);
		System.out.println("------------------------------------------------");

	}

}
