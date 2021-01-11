package com.example.user;

public class FirstSrv {
	private String name;
	private String id;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name1) {
		name = name1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id1) {
		id = id1;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address1) {
		address = address1;
	}

	public String getDescription(){
		return "name=" + name + ", id=" + id + ", address=" + address;
	}
}
