package com.momo.customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.momo.customer.dto.Customer;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerRepository {
	private SqlSessionFactory sessionFactory;
	public CustomerRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Customer selectById(String id) throws FindException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();//Connection과 같은 뜻
			Customer c = session.selectOne( //한 행만 검색할 때
					"com.momo.customer.mapper.CustomerMapper.selectById",
					 id);
			           //session.selectList() <= 여러행 검색할 때
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			System.out.println("c.id=" + c.getId() + ", c.pwd=" + c.getPwd() + ", c.name=" + c.getName());
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());			
		}finally {
			if(session != null) {
				session.close(); //DBCP에게 Connection돌려줌
			}
		}
	}
	public void insert(Customer c) throws AddException, FindException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
//			session.insert("com.my.customer.mapper.CustomerMapper.insert", c);
			Map<String, String> map = new HashMap<>();
			map.put("i", c.getId());
			map.put("p", c.getPwd());
			map.put("n", c.getName());
			session.insert("com.momo.customer.mapper.CustomerMapper.insert", map);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
