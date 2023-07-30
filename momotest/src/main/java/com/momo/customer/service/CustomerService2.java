package com.momo.customer.service;

import com.momo.customer.dao.CustomerRepository;
import com.momo.customer.dto.Customer;
import com.momo.customer.dto.Histories;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerService2 {
	private static CustomerService2 service = new CustomerService2();
	private CustomerRepository repository;
	
	private CustomerService2() {
		repository = new CustomerRepository(); 
	}
	
	public static CustomerService2 getInstance() {
		return service;
	}
	
	/**
	 * DB 연결 전 dto 직접 연결 테스트
	 * @return Histories 객체
	 */
	public Histories getHistoryList() {
		return new Histories();
	}
	/**
	 * 
	 * @return
	 */
	public Histories getHistoryList(String id) {
		
		return new Histories();
	}
	
	
}
