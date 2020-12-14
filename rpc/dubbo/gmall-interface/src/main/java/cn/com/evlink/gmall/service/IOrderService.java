package cn.com.evlink.gmall.service;

import java.util.List;

import cn.com.evlink.gmall.bean.UserAddress;

public interface IOrderService {
	/**
	 * 初始化订单
	 * @param userId
	 */
	List<UserAddress> initOrder(String userId);
}
