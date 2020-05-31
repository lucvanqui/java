package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.model.UserModel;

@Entity
@Table(name = "user")
public class User extends Audit{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Column(name="user_name")
	private String username;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@NotBlank
	@Column(name="role")
	private String role;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public User(long id, String username, String password, Boolean isActive) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
	}
	
	public User() {
		
	}
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public UserModel convertToModel() {
		UserModel model = new UserModel();
		model.setUserName(this.getUsername());
		model.setPassword("********");
		model.setRole(this.role);
		model.setActive(isActive());
		return model;
	}

}
