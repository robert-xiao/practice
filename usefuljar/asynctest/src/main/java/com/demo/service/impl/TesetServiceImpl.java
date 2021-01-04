package com.demo.service.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.demo.service.TesetService;

@Service
public class TesetServiceImpl implements TesetService {

	@Override
	@Async
	public void async1() {
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "call async1");
	}

	@Override
	@Async("new_task")
	public Future<String> async2() {
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +  "call async2");
		return new AsyncResult<String>("aync2");
	}

}
