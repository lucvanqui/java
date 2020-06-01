package com.example.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="company")
public class CompanyController {

	@RequestMapping(value="/cliched",method = RequestMethod.POST)
	public String checkStatus() {
		return "Hello company resource";
	}
}
