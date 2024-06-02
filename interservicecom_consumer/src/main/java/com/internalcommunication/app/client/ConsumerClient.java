package com.internalcommunication.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUCER-SERVICE")
public interface ConsumerClient {
	
	@GetMapping("/producer/{name}")
	public String invokeproducer(@PathVariable String name);
}
