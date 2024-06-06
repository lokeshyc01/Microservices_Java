package com.stockservice.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	
	Logger log = LoggerFactory.getLogger(StockController.class);
	
	@GetMapping("/{stock}")
	public String getStock(@PathVariable String stock) {
		log.error("StockController "+stock);
		return stock;
	}
}
