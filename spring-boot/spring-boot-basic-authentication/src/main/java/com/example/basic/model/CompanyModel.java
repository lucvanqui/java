package com.example.basic.model;

import java.util.List;

public class CompanyModel {

	private Long id;
	private String name;
	private String address;
	private List<EmployeeModel> employee;

	public CompanyModel() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmployeeModel> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeModel> employee) {
		this.employee = employee;
	}

}
