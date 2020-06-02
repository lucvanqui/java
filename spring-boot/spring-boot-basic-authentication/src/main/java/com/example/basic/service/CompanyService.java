package com.example.basic.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.converter.CompanyConverter;
import com.example.basic.entity.CompanyEntity;
import com.example.basic.entity.EmployeeEntity;
import com.example.basic.model.CompanyModel;
import com.example.basic.model.EmployeeModel;
import com.example.basic.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public List<CompanyEntity> findAllCompany() {
		return companyRepository.findAll();
	}

	@Transactional
	public CompanyModel addCompany(CompanyModel company) {
		CompanyEntity entity = new CompanyEntity();
		entity.setName(company.getName());
		entity.setAddress(company.getAddress());
		List<EmployeeEntity> emps = new ArrayList<>();
		for (EmployeeModel empModel : company.getEmployee()) {
			EmployeeEntity emp = new EmployeeEntity();
			emp.setFirstName(empModel.getFirstName());
			emp.setLastName(empModel.getLastName());
			emp.setBirthday(empModel.getBirthday());
			emps.add(emp);
		}
		entity.setEmployee(emps);

		CompanyEntity save = companyRepository.save(entity);
		return CompanyConverter.convertToModels(save);
	}
}
