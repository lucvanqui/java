package com.example.basic.converter;

import com.example.basic.entity.UserEntity;
import com.example.basic.model.UserModel;

public class UserConverter {

	public static UserModel convertToModel(UserEntity entity) {
		UserModel model = new UserModel();
		model.setUsername(entity.getUsername());
		model.setPassword(entity.getPassword());
		return model;
	}
	
	public static UserEntity convertToEntiy (UserModel model) {
		UserEntity entity = new UserEntity();
		entity.setUsername(model.getUsername());
		entity.setRole(model.getRole());
		return entity;
	}
}
