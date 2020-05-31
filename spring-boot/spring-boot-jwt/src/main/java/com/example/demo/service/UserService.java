package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.model.UserModel;

@Service
public class UserService {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserDao userDao;
	
	public User findUserByUserName(String userName) {
		return userDao.findByUsername(userName);
	}
	
	@Transactional
	public UserModel createUser(UserModel model) throws Exception {
		User existed = findUserByUserName(model.getUserName());
		if(existed != null) {
			throw new Exception("User existed");
		}
		User toBeAdded = convertUserToEntity(model);
		User userAdded = userDao.save(toBeAdded);
		return userAdded.convertToModel();
		
	}

	private User convertUserToEntity(UserModel model) {
		User user = new User();
		user.setUsername(model.getUserName());
		user.setPassword(passwordEncoder.encode(model.getPassword()));
		user.setActive(true);
		user.setRole("ROLE_USER");
		return user;
	}
}
