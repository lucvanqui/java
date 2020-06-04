package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.CompanyEntity;
import com.example.demo.entity.EmployeeEnity;
import com.example.demo.model.CompanyModel;
import com.example.demo.model.EmployeeModel;

public class CompanyConverter {

	public static CompanyEntity convertToEntity(CompanyModel model) {
		CompanyEntity entity = new CompanyEntity();
		entity.setCompanyName(model.getCompanyName());
		entity.setAddress(model.getAddress());
		entity.setPhoneNumber(model.getPhoneNumber());
		List<EmployeeEnity> employee = new ArrayList<EmployeeEnity>();
		for (EmployeeModel m : model.getEmployee()) {
			EmployeeEnity e = new EmployeeEnity();
			e.setFirstName(m.getFirstName());
			e.setLastName(m.getLastName());
			e.setAddress(m.getAddress());
			e.setPhoneNumber(m.getPhoneNumber());
			e.setCompany(entity);
			employee.add(e);
		}
		entity.setEmployee(employee);
		return entity;
	}

	public static CompanyModel convertToModel(CompanyEntity entity) {
		CompanyModel model = new CompanyModel();
		model.setCompanyName(entity.getCompanyName());
		model.setAddress(entity.getAddress());
		model.setPhoneNumber(entity.getPhoneNumber());
		List<EmployeeModel> employee = new ArrayList<EmployeeModel>();
		for (EmployeeEnity m : entity.getEmployee()) {
			EmployeeModel e = new EmployeeModel();
			e.setFirstName(m.getFirstName());
			e.setLastName(m.getLastName());
			e.setAddress(m.getAddress());
			e.setPhoneNumber(m.getPhoneNumber());
			employee.add(e);
		}
		model.setEmployee(employee);
		return model;
	}

}
