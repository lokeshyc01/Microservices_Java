package com.aspect.app.service;

import org.springframework.stereotype.Service;

@Service
public class TestBussinessService {

	
	public String test1() {
		return "test1";
	}
	
	public String test2() {
		throw new RuntimeException("dummy");
	}
}
