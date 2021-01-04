package com.demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.TesetService;

@RestController
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	private TesetService  testService;
	
	@GetMapping("/async1")
	public String test1(){
		testService.async1();
		return "test1";
	}
	
	@GetMapping("/async2")
	public String test2() throws InterruptedException, ExecutionException{
		Future<String> fut = testService.async2();
//		String result = fut.get();
//		System.out.println("controller " + result);
		return "test2";
	}
}
