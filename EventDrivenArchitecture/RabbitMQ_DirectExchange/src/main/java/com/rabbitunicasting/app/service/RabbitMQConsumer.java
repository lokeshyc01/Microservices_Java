package com.rabbitunicasting.app.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitunicasting.app.dto.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "marketingQueue")
	public void marketingMessage(Employee employee) {
		System.out.println("----------------------------------------------------");
		System.out.println("Received Message from RabbitMQ in Marketing Queue => : " + employee);
		System.out.println("----------------------------------------------------");

	}

	@RabbitListener(queues = "adminQueue")
	public void adminMessage(Employee employee) {
		System.out.println("----------------------------------------------------");
		System.out.println("Received Message from RabbitMQ in AdminQueue => : " + employee);
		System.out.println("----------------------------------------------------");

	}

	@RabbitListener(queues = "financeQueue")
	public void financeMessage(Employee employee) {
		System.out.println("----------------------------------------------------");
		System.out.println("Received Message from RabbitMQ in FinanceQueue => : " + employee);
		System.out.println("----------------------------------------------------");

	}

}
