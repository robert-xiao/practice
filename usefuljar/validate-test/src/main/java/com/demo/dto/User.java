package com.demo.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class User {

	@NotBlank(message="用户名不能为空")
	private String name;
	
	@NotBlank(message="用户名不能为空")
	@Length(min=6, message="密码长度至少为6位")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
