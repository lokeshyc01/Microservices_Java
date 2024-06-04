package com.rabbitunicasting.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitunicasting.app.dto.Employee;
import com.rabbitunicasting.app.service.RabbitMQSender;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private RabbitMQSender sender;
	
	@GetMapping
	public String createEmployee(@RequestParam("id") Long id,@RequestParam("name")String name,@RequestParam("age") int age)
	{
		Employee employee = new Employee(id, name, age);
		
		sender.send(employee);
		
		return "Message sent to RabbitMQ Successfully";
		
	}
}
