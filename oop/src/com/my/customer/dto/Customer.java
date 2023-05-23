package com.my.customer.dto;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private boolean flag; // 결혼여부
	public void setId(String id) { // setter 메서드
		this.id = id;
	}
	public String getId() { // getter 메서드
		return id;
	}
	public void setPwd(String pwd) { // setter 메서드
		this.pwd = pwd;
	}
	public String getPwd() { // getter 메서드
		return pwd;
	}
	public void setName(String name) { // setter 메서드
		this.name = name;
	}
	public String getName() { // getter 메서드
		return name;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isFlag() {
		return flag;
	}

}
