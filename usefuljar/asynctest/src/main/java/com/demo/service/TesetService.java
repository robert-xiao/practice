package com.demo.service;

import java.util.concurrent.Future;

public interface TesetService {

	void async1();
	
	Future<String> async2();
}
