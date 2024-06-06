package com.dbservice.app.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

	org.slf4j.Logger log = LoggerFactory.getLogger(DbController.class);
	
	
	@GetMapping("/{name}")
	public String getName(@PathVariable String name) {
		log.info("dbController => "+name);
		return name;
	}
	
}
