package com.demo;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	static final String QUEUE_NAME = "queue01";
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		test();
	}

	private static void test() throws JMSException{
		
		// 工厂
		String url = "tcp://10.68.60.13:61616";
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
	
		// 连接
		Connection connection = factory.createConnection();
		connection.start();
		
		// 会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 队列
		Queue queue = session.createQueue(QUEUE_NAME);
		
		// 建立队列的生产者
		MessageProducer producer = session.createProducer(queue);
		for(int i = 0; i < 3; ++i){
			TextMessage msg = session.createTextMessage("msg---" + i);
			producer.send(msg);
		}
		
		producer.close();
		session.close();
		connection.close();
		
		System.out.println("----消息发送完成----");
	}
}
