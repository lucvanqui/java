package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.UserModel;
import com.example.basic.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
		return ResponseEntity.ok(userService.addUser(user));
	}

}
