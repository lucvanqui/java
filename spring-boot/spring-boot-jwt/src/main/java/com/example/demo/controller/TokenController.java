package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.filter.JwtTokenProvider;
import com.example.demo.model.AuthenticationRequestData;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/token")
public class TokenController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	UserService useService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "create",method = RequestMethod.POST)
	public ResponseEntity createToken(@RequestBody @NotNull AuthenticationRequestData authen) {
		String userName = authen.getUserName();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, authen.getPassword()));
		User findUserByUserName = useService.findUserByUserName(userName);
		String string = findUserByUserName.getRole();
		List<String> asList = new ArrayList<>();
		asList.add(string);
		String token = jwtTokenProvider.createToken(userName, asList);
		Map<String, String> response = new HashMap<>();
		response.put("userName", userName);
		response.put("token", token);
		return ResponseEntity.ok(response);
	}
}
