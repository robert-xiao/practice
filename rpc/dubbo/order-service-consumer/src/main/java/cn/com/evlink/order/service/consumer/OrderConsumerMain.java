package cn.com.evlink.order.service.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.evlink.gmall.service.IOrderService;

public class OrderConsumerMain {

	private static ClassPathXmlApplicationContext applicationContext;

	public static void main(String[] args) throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		
		IOrderService orderService = applicationContext.getBean(IOrderService.class);
		
		orderService.initOrder("1");
		System.out.println("调用完成....");
		System.in.read();
	}
}
