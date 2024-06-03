package com.bookticket.app.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@EnableHystrix
@RestController
@RequestMapping("/book")
public class BookMyTicketController {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger Log = Logger.getLogger(BookMyTicketController.class.getName());

	@HystrixCommand(fallbackMethod = "bookMyTicketFallBackMethod")
	@GetMapping("/ticket")
	public String bookMyTicket() {
		Log.info("Primary API <=> ");
		try {
			String paymentResponse = restTemplate.getForObject("http://localhost:8181/pay", String.class);
			String emailResponse = restTemplate.getForObject("http://localhost:8282/email", String.class);
			return paymentResponse + "\n" + emailResponse;

		} catch (Exception e) {
			throw new RuntimeException("Service down");
		}

	}

	public String bookMyTicketFallBackMethod() {
		Log.info("fallback method");
		return "<h1>Email/Payment service may be down!!</h1>";
	}
}
