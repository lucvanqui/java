package com.example.demo.model;

public class UserModel {
	private String userName;
	private String password;
	private String role;
	private Boolean isActive;

	public UserModel() {
	}

	public UserModel(String userName, String password, String role, Boolean isActive) {
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
