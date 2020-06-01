package com.example.basic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.basic.converter.UserConverter;
import com.example.basic.entity.UserEntity;
import com.example.basic.model.UserModel;
import com.example.basic.repository.UserRepository;

import javassist.NotFoundException;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel findByUsername(String userName) throws NotFoundException {
		Optional<UserEntity> user = Optional.of(userRepository.findByUsername(userName));
		if (user.isPresent()) {
			return UserConverter.convertToModel(user.get());
		}
		throw new NotFoundException("Username is not existed");
	}

	public UserModel addUser(UserModel model) {
		UserEntity user = userRepository.findByUsername(model.getUsername());
		if (user != null) {
			throw new DuplicateKeyException("User already existed");
		}
		UserEntity convertToEntiy = UserConverter.convertToEntiy(model);
		convertToEntiy.setPassword(passwordEncoder.encode(model.getPassword()));
		UserEntity added = userRepository.save(convertToEntiy);
		return UserConverter.convertToModel(added);
	}
}
