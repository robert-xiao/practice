package cn.com.evlink.gmall.service;

import java.util.List;

import cn.com.evlink.gmall.bean.UserAddress;

public interface IUserService {
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	List<UserAddress> getUserAddressList(String userId);
}
