package com.jwt.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	com.jwt.app.repository.UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("load user by username");
		com.jwt.app.entity.UserEntity user = userRepo.findByName(username).orElse(null);
		if(user == null) {
			throw new UsernameNotFoundException("User does not exist");
		}
		log.info("user details => "+user);
		return new com.jwt.app.entity.CustomeUserDetails(user);
	}

}
