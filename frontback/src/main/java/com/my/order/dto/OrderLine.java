package com.my.order.dto;

import com.my.product.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class OrderLine {
	private int OrderNo;
	//private String OrderProdNo;
	private Product orderP;//HAS A 관계
	private int OrderQuantity; 

}
