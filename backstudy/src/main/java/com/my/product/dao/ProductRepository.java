package com.my.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class ProductRepository {
	public List<String> selectAll(int startRow, int endRow) 
			throws FindException{
		List<String> list = new ArrayList<>();
		
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
				list.add(rs.getString("prod_no"));
			}
			return list;
		}catch(Exception e) {
			throw new FindException("상품검색 실패:" + e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, conn);
		}
	}
}
