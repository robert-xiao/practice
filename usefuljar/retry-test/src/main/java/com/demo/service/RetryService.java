package com.demo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	int times = 2;
	
	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
	public int testRetry1(int n){
		if(times > 0){
			times--;
			throw new IllegalArgumentException("n > 0");
		}
		System.out.println("success");
		return n;
	}
	
	@Recover
	public int recover(Exception e) {
	    System.out.println("enter recover");
	    return times;
	}
}
