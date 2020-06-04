package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CompanyModel;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping(value = "company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<CompanyModel> addCompany(@RequestBody CompanyModel model) {
		CompanyModel company = companyService.addCompany(model);
		return ResponseEntity.ok(company);
	}

}
