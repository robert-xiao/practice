package com.demo;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
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
		// test1();
		test2();
	}

	// 同步接收
	private static void test1() throws JMSException{
		
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
		
		// 建立队列的消费者
		MessageConsumer consumer = session.createConsumer(queue);
		while(true){
			TextMessage msg = (TextMessage)consumer.receive(4000L);
			if(msg != null){
				System.out.println("receive 收到：" + msg.getText());
			}else{
				break;
			}
		}
		consumer.close();
		session.close();
		connection.close();
		
		System.out.println("----消息接收完成----");
	}
	
	// 监听接收
	private static void test2() throws JMSException, IOException{
		
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
		
		// 建立队列的消费者
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener(){

			@Override
			public void onMessage(Message message) {
				TextMessage msg = (TextMessage)message;
				try {
					System.out.println("MessageListener 收到：" + msg.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
			
		});

		System.in.read();
		consumer.close();
		session.close();
		connection.close();
		
		System.out.println("----消息接收完成----");
	}
}
