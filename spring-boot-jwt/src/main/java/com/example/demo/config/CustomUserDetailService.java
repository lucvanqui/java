package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = this.userDao.findByUsername(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
				.username(user.getUsername())
				.password(user.getPassword()).roles(user.getRole().toString())
				.build();
	}

}
