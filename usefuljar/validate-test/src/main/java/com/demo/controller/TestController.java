package com.demo.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.User;

@RestController()
@RequestMapping("/test")
public class TestController {

	@PostMapping(value="/user")
	public String addUser(@Valid @RequestBody User user){
		System.out.println(user.getName() + ":" + user.getPassword());
		return "ok";
	}
	
	@PostMapping(value="/user2")
	public String addUser2(@Valid @RequestBody User user, BindingResult bindingResult){
		System.out.println(user.getName() + ":" + user.getPassword());
		if(bindingResult.hasErrors()){		
			return bindingResult.getFieldError().toString();
		}
		return "ok";
	}
}
