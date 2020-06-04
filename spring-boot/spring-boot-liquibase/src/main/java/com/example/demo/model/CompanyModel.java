package com.example.demo.model;

import java.util.List;

public class CompanyModel {

	private Long id;

	private String companyName;
	private String address;
	private String phoneNumber;
	private List<EmployeeModel> employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<EmployeeModel> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeModel> employee) {
		this.employee = employee;
	}

}
