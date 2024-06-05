package com.rabbitunicasting.app.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitunicasting.app.dto.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate template;
	
	
	public void send(Employee emp,String routingKey)
	{
		template.convertAndSend("fanout-exchange",routingKey,emp);
		System.out.println("------------------------------------------------");
		System.out.println("send msg to rabbit mq => "+emp);
		System.out.println("------------------------------------------------");

	}

}
