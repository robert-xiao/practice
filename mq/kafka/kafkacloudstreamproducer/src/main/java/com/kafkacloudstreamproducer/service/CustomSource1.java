package com.kafkacloudstreamproducer.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource1 {
	String str = "custom-source1";
	
	@Output(str)
	MessageChannel output();
}
