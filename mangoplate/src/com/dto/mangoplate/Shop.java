package com.dto.mangoplate;

public class Shop {

	private int shop_no=1000;
	private String shop_name;
	private boolean shop_state;
	private String shop_content;
	private String shop_type;
	private String shop_passwd;
	public Shop() {
		
	}
	//생성자
	public Shop(String shop_name,String shop_content,String shop_type, String shop_passwd) {
		this.shop_content = shop_content;
		this.shop_name = shop_name;
		this.shop_type = shop_type;
		this.shop_passwd = shop_passwd;
	}
	public Shop(String shop_name,String shop_content,String shop_type) {
		this.shop_content = shop_content;
		this.shop_name = shop_name;
		this.shop_type = shop_type;
	}
	
	
	public String getShop_passwd() {
		return shop_passwd;
	}

	public void setShop_passwd(String shop_passwd) {
		this.shop_passwd = shop_passwd;
	}

	
	
	//전체 음식점 목록 리스트에 추가하기 위한 생성자
	public Shop(String shop_name, String shop_content) {
		this.shop_name = shop_name;
		this.shop_content = shop_content;
	}
	
	
	public int getShop_no() {
		return shop_no;
	}
	public void setShop_no(int shop_no) {
		shop_no++;
		this.shop_no = shop_no;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public boolean getShop_state() {
		return shop_state;
	}
	public void setShop_state(boolean shop_state) {
		this.shop_state = shop_state;
	}
	public String getShop_content() {
		return shop_content;
	}
	public void setShop_content(String shop_content) {
		this.shop_content = shop_content;
	}
	public String getShop_type() {
		return shop_type;
	}
	public void setShop_type(String shop_type) {
		this.shop_type = shop_type;
	}
	
}
