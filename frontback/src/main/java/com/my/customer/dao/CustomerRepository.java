package com.my.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.customer.dto.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class CustomerRepository {
	public Customer selectById(String id) throws FindException{
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
	}
	public void insert(Customer c) throws AddException, FindException{
		
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
		
	}
}
