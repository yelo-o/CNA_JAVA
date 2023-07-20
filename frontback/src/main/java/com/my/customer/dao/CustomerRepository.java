package com.my.customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.customer.dto.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;

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
					"com.my.customer.mapper.CustomerMapper.selectById",
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
		/*
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		String selectSQL = "SELECT *\r\n"
				+ "FROM customer\r\n"
				+ "WHERE id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Customer(
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name")
						);
			}else {
				throw new FindException("고객이 없습니다");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		*/
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
			session.insert("com.my.customer.mapper.CustomerMapper.insert", map);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
		/*
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		String insertSQL = "INSERT INTO customer(id,pwd,name) "
				+ "VALUES(?,?,?)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id= c.getId();
		String name= c.getName();
		String pwd= c.getPwd();
		
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException("SQL 구문 오류!");
		}
		*/
	}
}
