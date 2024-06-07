package com.stockcalc.app.controller;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockcalc.app.client.StockClient;
import com.stockcalc.app.dto.Stock;


@RestController
@RequestMapping("/calculate")
public class StockCalculatorController {

	@Autowired
	private StockClient client;
	
	@PostMapping("/{stockname}")
	public Long calculateStockPrice(@RequestBody Long quantity,@PathVariable String stockname)
	{
		Stock stock = client.getStock(stockname);
		if(stock == null)
		{
			stock = new Stock();
			stock.setPrice(200L);
		}
		System.out.println(quantity + " ");
		
		return stock.getPrice() * quantity;
	}
	
	@GetMapping("/{stockname}")
	public String getStock(@PathVariable String stockname) {
		return stockname;
	}
}
