package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.User;
import com.api.service.impl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl serviceImpl;
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createUser = serviceImpl.createUser(user);
		return ResponseEntity.ok(createUser);}
}
