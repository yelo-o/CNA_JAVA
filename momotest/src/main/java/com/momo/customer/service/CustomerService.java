package com.momo.customer.service;

import com.momo.customer.dto.Customer;
import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.customer.dao.CustomerRepository;

public class CustomerService {
	private static CustomerService service = new CustomerService();
	private CustomerRepository repository;
	
	private CustomerService() {
		repository = new CustomerRepository(); 
	}
	
	public static CustomerService getInstance() {
		return service;
	}
	
	public void idDupChk(String id) throws FindException{
		Customer c = null;
		try {
			//id에 해당 고객이 있는 경우(중복된 경우)
			c = repository.selectById(id);
			
		} catch(FindException e) { 
			//id에 해당 고객이 없는 경우(id 사용 가능한 경우), 아무것도 하지 말것
		}
		
		if(c != null) {
			throw new FindException("이미 사용중인 아이디입니다");
		}
	}
	
	public Customer login(String id, String pwd) throws FindException{
		Customer c = repository.selectById(id);
		if(pwd.equals(c.getPwd())) {
			return c;
		}else {
			throw new FindException("로그인 실패");
		}
	}
	
	public void signup(Customer c) throws AddException, FindException{
		try {
			repository.insert(c);
		} catch(AddException e) {
			
		}
		if(c != null) {
			throw new AddException("가입 실패");
		}
	}
}
