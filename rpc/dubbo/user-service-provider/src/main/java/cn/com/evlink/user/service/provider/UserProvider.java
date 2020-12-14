package cn.com.evlink.user.service.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserProvider {
	
	private static ClassPathXmlApplicationContext context;

	public static void main(String[] args) throws IOException {
		context = new ClassPathXmlApplicationContext("provider.xml");
		context.start();
		
		System.in.read();
	}
}
