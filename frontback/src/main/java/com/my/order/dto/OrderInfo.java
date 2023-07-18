package com.my.order.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class OrderInfo {
	private int orderNo;
	private String orderId;
	private Date orderDt;
	private List<OrderLine> lines;

}
