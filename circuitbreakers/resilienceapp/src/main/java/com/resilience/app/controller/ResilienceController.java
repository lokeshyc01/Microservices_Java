package com.resilience.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resilience.app.dto.Order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
public class ResilienceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@CircuitBreaker(name = "resilienceapp",fallbackMethod = "getAvailableProducts")
	@GetMapping("/orders/{category}")
	public List<Order> getOrders(@PathVariable String category){
		return restTemplate.getForObject("http://localhost:8181/orders/"+category, List.class);
	}
	
	public List<Order> getAvailableProducts(Exception e){
		return Stream.of( 
				new Order(120L, "Laptop", "Electronics", 1241),
				new Order(125L, "Bat", "Toy", 233),
				new Order(20L, "Syringe", "Medical", 564),
				new Order(12L, "Mobile", "Electronics", 3221),
				new Order(120L, "Microwave", "Home Utensils", 12421)
		).collect(Collectors.toList());
	}

}
