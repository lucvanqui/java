package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "company")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<EmployeeEnity> employee = new ArrayList<EmployeeEnity>();

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

	public List<EmployeeEnity> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeEnity> employee) {
		this.employee = employee;
	}

}
