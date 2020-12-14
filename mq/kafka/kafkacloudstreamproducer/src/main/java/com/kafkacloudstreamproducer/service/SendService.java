package com.kafkacloudstreamproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;


@EnableBinding({Source.class, CustomSource1.class})
public class SendService {

	@Autowired
	private Source source;
	
	@Autowired
	private CustomSource1 source1;
	
//	@Autowired
//	@Qualifier(CustomSource1.str)
//	private MessageChannel channel;
	
	public void send(String str){
		source.output().send(MessageBuilder.withPayload(str).build());
	}
	
	public void send1(String str){
		String partitionValue = "0";
		if(str.startsWith("1")){
			partitionValue = "1";
		}
		Message<String> message = MessageBuilder.withPayload(str).setHeader("partitionKey", partitionValue).build();
		Object obj = message.getHeaders().get("partitionKey");
		System.out.println(obj);
		source1.output().send(message);
	}
}
