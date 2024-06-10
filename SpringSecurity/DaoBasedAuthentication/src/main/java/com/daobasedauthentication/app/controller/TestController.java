package com.daobasedauthentication.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daobasedauthentication.app.entity.UserEntity;
import com.daobasedauthentication.app.repository.UserRepository;

@RestController
public class TestController {
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("/test")
	public String sayHi() {
		return "Jay Ganesh...";
	}
	
	@GetMapping("/student")
	public String getStudent() {
		return "Student route";
	}
	
	@PostMapping("/home")
	public String hello(@RequestBody UserEntity user) {
		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		repo.save(user);
		return "open route for all";
	}
}
