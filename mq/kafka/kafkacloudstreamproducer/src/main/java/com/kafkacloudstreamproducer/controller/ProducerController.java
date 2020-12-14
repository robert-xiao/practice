package com.kafkacloudstreamproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kafkacloudstreamproducer.service.SendService;

@RestController
public class ProducerController {

	@Autowired
	private SendService sendService;
	
	@GetMapping("/send/{msg}")
	public void send(@PathVariable("msg") String msg){
		sendService.send(msg);
	}
	
	@GetMapping("/send1/{msg}")
	public void send1(@PathVariable("msg") String msg){
		sendService.send1(msg);
	}
}
