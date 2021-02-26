package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.config.BankProperties;
import com.demo.config.UserProperties;

@RestController()
public class TestController {

	@Autowired
	private UserProperties up;
	
	@Autowired
	private BankProperties bank;
	
	@GetMapping("/user")
	public String getUser(){
		return up.toString();
	}
	
	@GetMapping("/bank")
	public String getBank(){
		return bank.toString();
	}
}
