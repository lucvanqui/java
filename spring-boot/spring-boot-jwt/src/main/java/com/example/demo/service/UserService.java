package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User findUserByUserName(String userName) {
		return userDao.findByUsername(userName);
	}
}
