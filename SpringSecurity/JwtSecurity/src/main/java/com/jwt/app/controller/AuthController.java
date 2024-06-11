package com.jwt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.app.dto.SigninRequest;
import com.jwt.app.dto.SignupRequest;
import com.jwt.app.entity.UserEntity;
import com.jwt.app.repository.UserRepository;
import com.jwt.app.service.JwtService;

@RestController
public class AuthController {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AuthenticationProvider manager;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtService jwtservice;
	Logger log = LoggerFactory.getLogger(getClass());

	@PostMapping("/signup")
	public UserEntity signup(@RequestBody SignupRequest request) {
		UserEntity user = new UserEntity();
		user.setName(request.getUsername());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		return userRepo.save(user);
	}
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody SigninRequest request)
	{
		log.info("sigin flow");
		Authentication authenticaiton = manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		String token = jwtservice.generateToken(authenticaiton);
		log.info(token);
		return ResponseEntity.ok(token);
		
	}
}
