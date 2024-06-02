package com.stockprice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockprice.app.dto.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	public Stock findByStock(String stockName);
}
