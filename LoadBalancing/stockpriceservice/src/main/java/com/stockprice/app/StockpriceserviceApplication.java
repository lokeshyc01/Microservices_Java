package com.stockprice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StockpriceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockpriceserviceApplication.class, args);
	}

}
