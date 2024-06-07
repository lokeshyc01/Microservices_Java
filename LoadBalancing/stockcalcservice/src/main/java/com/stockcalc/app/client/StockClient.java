package com.stockcalc.app.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stockcalc.app.dto.Stock;

@FeignClient("STOCK-PRICE-SERVICE")
@RibbonClient("STOCK-PRICE-SERVICE")
public interface StockClient {
	@GetMapping("/stockprice/{stock}")
	public Stock getStock(@PathVariable String stock);
}
