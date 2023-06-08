package com.my.product.dto; //Data Transfer Object

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
	private String prodNo; //상품번호
	private String prodName; //상품이름
	transient private int prodPrice; //상품가격 //transient : 직렬화제외
	
	public Product() { // 디폴트 생성자 생성 <-자바빈의 조건을 충족하기 위해
		
	}
	public Product(String prodNo, String prodName, int prodPrice) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		if(prodNo.charAt(0) == 's' || prodNo.length()>10) {
			System.out.println("상품번호가 잘못되었습니다");
			return;
		}
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public void print() {
    	System.out.println("상품번호 : "+ this.prodNo + ", 상품이름 : "+ this.prodName +", 상품가격 : " +  this.prodPrice);
    }
	@Override
	public int hashCode() {
		return Objects.hash(prodNo);
	}
	@Override
	/**
	 * @param obj 상품객체
	 * @return 현재객체의 상품번호와 obj객체의 상품번호가 같으면 true 반환
	 * 		   그외는 false 반환
	 *         ex) equals(new String()); 결과는 false
	 *         ex) equals(null); 결과는 false
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Product == false) { //ClassCastException 방지
			return false;
		}
		Product p = (Product) obj; // 다운캐스팅
		if(this.prodNo == null || p == null) {
			return false;
		}
		return this.prodNo.equals(p.prodNo);
	}
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}
	
}