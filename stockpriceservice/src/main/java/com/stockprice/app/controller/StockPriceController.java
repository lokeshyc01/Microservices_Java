package com.stockprice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockprice.app.dto.Stock;
import com.stockprice.app.repository.StockRepository;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	
	@Autowired
	private StockRepository repo;
	
	@GetMapping("/{stock}")
	public Stock getStockPrice(@PathVariable String stock)
	{
		return repo.findByStock(stock);
	}

}
