package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value ="user")
public class UserControler {

	@Autowired
	UserService userService;
	
	@PostMapping(value="/add")
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) throws Exception{
		UserModel createUser = userService.createUser(user);
		return ResponseEntity.ok(createUser);
	}
}
