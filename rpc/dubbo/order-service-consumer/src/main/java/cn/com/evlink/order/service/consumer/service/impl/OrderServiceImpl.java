package cn.com.evlink.order.service.consumer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.evlink.gmall.bean.UserAddress;
import cn.com.evlink.gmall.service.IOrderService;
import cn.com.evlink.gmall.service.IUserService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IUserService userService;
	
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}
	
	

}
