package com.my.order.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.order.dto.OrderInfo;
import com.my.order.dto.OrderLine;
import com.my.product.dto.Product;
import com.my.sql.MyConnection;

public class OrderRepository {
	private SqlSessionFactory sessionFactory;
	public OrderRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<OrderInfo> selectById(String id) throws FindException{
		SqlSession session = null;
		List<OrderInfo> test = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
//			List<Map<String, Object>> list = 
//					session.selectList("com.my.order.mapper.OrderMapper.selectById", id);
//			for(Map<String, Object> map:list) {
//				for(String key:map.keySet()) {
//					Object value = map.get(key);
//					System.out.println(key + "=" + value);
//				}
//				System.out.println("--------------------");
//			}
			List<OrderInfo> list = session.selectList("com.my.order.mapper.OrderMapper.selectById", id);
			for(OrderInfo info:list) {
				System.out.println("주문번호 : " + info.getOrderNo());
				System.out.println("주문일자 : " + info.getOrderDt());
				System.out.println("주문상세들" + info.getLines());
				for(OrderLine line : info.getLines()) {
					Product p = line.getOrderP();
					System.out.println(p.getProdNo() + ":" + p.getProdName() + ":" + p.getProdPrice());
					System.out.println(":" + line.getOrderQuantity());
				}
				
			}
			return list;
		} catch(Exception e) {
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
//		Connection conn = null;
//		try {
//			conn = MyConnection.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		/*
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectByIdSQL = "SELECT info.order_no, info.order_dt,\r\n"
				+ "           line.order_quantity,\r\n"
				+ "           p.prod_no, p.prod_name, p.prod_price\r\n"
				+ "FROM order_info  info\r\n"
				+ "JOIN order_line line ON (info.order_no=line.order_no)\r\n"
				+ "JOIN product p ON (line.order_prod_no = p.prod_no)\r\n"
				+ "WHERE order_id = ?";
		
		OrderInfo info = null;
		List<OrderLine> lines = null;
		int old_order_no = 0; //이전행의 주문번호 : 주문번호는 최소 1부터 시작
		try {
			pstmt = conn.prepareStatement(selectByIdSQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int order_no = rs.getInt("order_no");//현재행의 주문번호
				java.sql.Date order_dt = rs.getDate("order_dt");
				String prodNo = rs.getString("prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				int orderQuantity = rs.getInt("order_quantity");
				
				if(old_order_no != order_no) { //첫행이거나 주문번호가 다른 경우
					info = new OrderInfo();
					info.setOrderNo(order_no);
					info.setOrderDt(order_dt);
					lines = new ArrayList<>();
					info.setLines(lines);
					list.add(info);
					old_order_no = order_no; 
				}
				OrderLine line = new OrderLine();
				line.setOrderNo(order_no);
				Product p = new Product();
				p.setProdNo(prodNo);  p.setProdName(prodName);  p.setProdPrice(prodPrice);
				line.setOrderP(p);
				line.setOrderQuantity(orderQuantity);
				lines.add(line);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}
		*/
	}
	public void insert(OrderInfo info) throws AddException{
//		Connection conn = null;		
//		try {
//			conn = MyConnection.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			throw new AddException(e.getMessage());
//		}
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			insertInfo(session, info);
			List<OrderLine> lines = info.getLines();
			for(OrderLine line: lines) {
				insertLine(session, line);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	private void insertInfo(SqlSession session,OrderInfo info) throws AddException{
		try {
			session = sessionFactory.openSession();
			session.insert("com.my.order.mapper.OrderMapper.insertInfo", info.getOrderId());
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		
		//행추가 order_seq.NEXTVAL
//		PreparedStatement pstmt = null;
//		String insertInfoSQL = "INSERT INTO order_info(order_no, order_id, order_dt) VALUES (order_seq.NEXTVAL, ?, SYSDATE)";
//
//		try {
//			pstmt = conn.prepareStatement(insertInfoSQL);
//			pstmt.setString(1, info.getOrderId());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new AddException(e.getMessage());
//		}
	}
	private void insertLine(SqlSession session, OrderLine line) throws AddException{
		try {
			//session = sessionFactory.openSession();
			session.insert("com.my.order.mapper.OrderMapper.insertLine", line);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		
		//행추가 order_seq.CURRVAL :X		
//		PreparedStatement pstmt = null;
//		String insertLineSQL = "INSERT INTO order_line(order_no, order_prod_no, order_quantity) VALUES (order_seq.CURRVAL, ?, ?)";
//		try {
//			pstmt = conn.prepareStatement(insertLineSQL);
////			pstmt.setString(1, line.getOrderProdNo());
//			pstmt.setString(1, line.getOrderP().getProdNo());
//			pstmt.setInt(2, line.getOrderQuantity());
//			pstmt.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new AddException(e.getMessage());
//		}
	}
}
