package com.my.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.FindException;
import com.my.product.dto.Product;
import com.my.sql.MyConnection;

public class ProductRepository {
	public Product SelectByProdNo(String prodNo) throws FindException {
		//1.DB와의 연결
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new FindException("DB와의 연결 실패:" + e.getMessage());
		}
		//2.SQL구문 송신
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String selectProdNoSQL = "select * from product where prod_no=?";
			pstmt = conn.prepareStatement(selectProdNoSQL);
			pstmt.setString(1, prodNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//list.add(rs.getString("prod_no"));
				Product p = new Product(rs.getString("prod_no"), 
						rs.getString("prod_name"), 
						rs.getInt("prod_price"));
				return p;
			}
			System.out.println("상품이 없습니다.");
			return null;
		} catch(SQLException e) {
			//e.printStackTrace();
			throw new FindException("SQL 구문 오류");
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}
	}
	public int count() throws FindException{
		//1.DB와의 연결
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new FindException("DB와의 연결 실패:" + e.getMessage());
		}
		//2.SQL구문 송신
		String selectCountSQL = "SELECT COUNT(*) FROM product";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(selectCountSQL);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1); 
				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}
	}
	/**
	 * 상품목록을 검색한다
	 * @param startRow 시작행
	 * @param endRow 끝행
	 * @return 상품목록
	 * @throws FindException 상품조회 시 DB와의 연결 실패 또는 SQL구문오류 시 예외발생한다
	 */
	public List<Product> selectAll(int startRow, int endRow) throws FindException{
		List<Product> list = new ArrayList<>();
		
		//1.DB와의 연결
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new FindException("DB와의 연결 실패:" + e.getMessage());
		}
		
		//2.SQL구문 송신
		PreparedStatement pstmt=null;
		//3.SQL결과 수신
		ResultSet rs=null;
		try {
			String selectSQL = "SELECT *\r\n"
					+ "FROM (SELECT rownum rn, a.*\r\n"
					+ " FROM (SELECT * FROM product ORDER BY prod_no ASC) a\r\n"
					+ ")\r\n"
					+ "WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//list.add(rs.getString("prod_no"));
				Product p = new Product(rs.getString("prod_no"), 
										rs.getString("prod_name"), 
										rs.getInt("prod_price"));
				list.add(p);
			}
			return list;
		}catch(Exception e) {
			throw new FindException("상품검색 실패:" + e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, conn);
		}
	}
}
