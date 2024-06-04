package com.rabbitunicasting.app.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitunicasting.app.dto.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${springbot.rabbitmq.queue}")
	public void receiveMessage(Employee employee)
	{
		System.out.println("----------------------------------------------------");
		System.out.println("Received Message from RabbitMQ: "+employee);
		System.out.println("----------------------------------------------------");

	}
	
	
}
