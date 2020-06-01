package com.example.basic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.basic.model.UserModel;
import com.example.basic.service.UserService;

import javassist.NotFoundException;

@Configuration
public class CustomeUserDetailService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		try {
			UserModel user = userService.findByUsername(userName);
			return user;
		} catch (NotFoundException e) {
			throw new UsernameNotFoundException("User is not existed");
		}

	}

}
