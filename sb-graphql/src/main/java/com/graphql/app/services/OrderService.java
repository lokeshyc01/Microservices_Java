package com.graphql.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.app.pojo.Order;
import com.graphql.app.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public List<Order> getAllOrder(){
		return orderRepo.findAll();
	}
	
	public Order getOrderById(int orderId) {
		return orderRepo.findById(orderId).orElse(new Order());
	}
	
	public boolean deleteOrder(int orderId) {
		orderRepo.deleteById(orderId);
		return true;
	}
}
