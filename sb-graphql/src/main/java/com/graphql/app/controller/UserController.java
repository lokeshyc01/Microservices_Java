package com.graphql.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.app.pojo.User;
import com.graphql.app.services.UserService;

@Controller
public class UserController {
@Autowired
private UserService service;

@MutationMapping
public User createUser(@Argument String name,@Argument String phone , @Argument String email,@Argument String password) {
	User user = new User();
	user.setEmail(email);
	user.setPassword(password);
	user.setPhone(phone);
	user.setName(name);
	return service.createUser(user);
}

@QueryMapping(name = "getUsers")
public List<User> getAllUsers(){
	return service.getAllUser();
}

@QueryMapping 
public User getUser(@Argument int userId) {
	return service.getUser(userId);
}

@MutationMapping
public boolean deleteUser(@Argument int userId) {
	return service.deleteUser(userId);
}
}
