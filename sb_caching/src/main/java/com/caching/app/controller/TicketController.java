package com.caching.app.controller;

import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caching.app.entity.Ticket;
import com.caching.app.repository.TicketRepository;

@RestController
@RequestMapping
public class TicketController {

	@Autowired
	private TicketRepository repo;
	
	@Cacheable(value = "ticketsCache",key = "#id")
	@GetMapping("/ticket/{id}")
	public Optional<Ticket> getById(@PathVariable Long id)
	{
		return repo.findById(id);
	}
	
	
	@CacheEvict(value = "ticketsCache",key = "#id")
	@DeleteMapping("/ticket/{id}")
	public void deleteById(@PathVariable Long id) {
		repo.deleteById(id);
	}
	
	
	@CachePut(value = "ticketsCache",key = "#id")
	@PutMapping("/ticket/{id}")
	public Ticket ticket(@PathVariable Long id)
	{
		Ticket ticket = repo.findById(id).orElse(new Ticket());
		
		ticket.setEmail("random@gmail.com");
		return repo.save(ticket);
	}
}
