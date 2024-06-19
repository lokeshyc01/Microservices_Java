package com.graphql.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.app.pojo.User;
import com.graphql.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
//	create user
	public User createUser(User user)
	{
		return userRepo.save(user);
	}
	
	
//	getting all user
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
//	getting single user
	public User getUser(int userId) {
		return userRepo.findById(userId).orElse(new User());
	}
	
//	updating user
//	public User
	
	
//	deleting user
	
	public boolean deleteUser(int userId) {
		 userRepo.deleteById(userId);
		 return true;
	}
}
