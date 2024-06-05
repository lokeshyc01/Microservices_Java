package com.caching.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import com.caching.app.entity.Ticket;
import com.caching.app.repository.TicketRepository;
@EnableCaching
@SpringBootApplication
public class SbCachingApplication implements CommandLineRunner{
	
	@Autowired
	private TicketRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SbCachingApplication.class, args);
	}
	
	
	@Bean
	public CacheManager manager() {
		return new ConcurrentMapCacheManager("ticketsCache");
	}


	@Override
	public void run(String... args) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setId(1L);
		ticket.setCustomerName("Lokesh");
		ticket.setEmail("lokesh@gmail.com");
		repo.save(ticket);
		
		
		Ticket newticket = new Ticket();
		ticket.setId(2L);
		ticket.setEmail("anil@gmail.com");
		ticket.setCustomerName("Anil Patil");
		
		repo.save(newticket);
		
	}

}
