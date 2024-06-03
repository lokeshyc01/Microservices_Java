package com.bookticket.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableHystrix
@SpringBootApplication
public class BookmyticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmyticketApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate( )
	{
		return new RestTemplate();
	}

}
