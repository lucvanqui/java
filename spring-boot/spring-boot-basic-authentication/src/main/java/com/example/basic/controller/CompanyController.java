package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.entity.CompanyEntity;
import com.example.basic.model.CompanyModel;
import com.example.basic.service.CompanyService;

@RestController
@RequestMapping(value="company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/cliched",method = RequestMethod.GET)
	public String checkStatus() {
		return "Hello company resource";
	}
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CompanyEntity> findAllCompanies() {
		return companyService.findAllCompany();
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CompanyModel add(@RequestBody CompanyModel company) {
		return companyService.addCompany(company);
	}
	
	
}
