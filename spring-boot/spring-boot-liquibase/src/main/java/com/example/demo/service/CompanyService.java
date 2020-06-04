package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.CompanyConverter;
import com.example.demo.entity.CompanyEntity;
import com.example.demo.model.CompanyModel;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Transactional
	public CompanyModel addCompany(CompanyModel model) {
		//TODO check company existed or not
		CompanyEntity save = companyRepository.save(CompanyConverter.convertToEntity(model));
		return CompanyConverter.convertToModel(save);
	}
}
