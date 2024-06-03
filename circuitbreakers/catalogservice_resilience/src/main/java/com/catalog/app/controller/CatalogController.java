package com.catalog.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.app.dto.Order;
import com.catalog.app.repository.OrderRepository;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/orders")
public class CatalogController {
	
	@Autowired
	private OrderRepository repo;
	
	@GetMapping
	public List<Order> getOrders(){
		return repo.findAll();
	}
		
	@GetMapping("/{category}")
	public List<Order> getOrders(@PathVariable String category)
	{
		return repo.findByCategoryName(category);
	}

}
