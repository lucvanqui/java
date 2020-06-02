package com.example.basic.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.basic.entity.CompanyEntity;
import com.example.basic.entity.EmployeeEntity;
import com.example.basic.model.CompanyModel;
import com.example.basic.model.EmployeeModel;

public class CompanyConverter {

	public static CompanyModel convertToModels(CompanyEntity entity) {
		CompanyModel model = new CompanyModel();
		model.setName(entity.getName());
		model.setAddress(entity.getAddress());
		List<EmployeeModel> empModel = new ArrayList<EmployeeModel>();
		for (EmployeeEntity emp : entity.getEmployee()) {
			EmployeeModel e = new EmployeeModel();
			e.setFirstName(emp.getFirstName());
			e.setLastName(emp.getLastName());
			e.setBirthday(emp.getBirthday());
			empModel.add(e);
		}
		model.setEmployee(empModel);
		
		return model;
	}
}
