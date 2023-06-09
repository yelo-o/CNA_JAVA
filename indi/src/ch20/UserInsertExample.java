package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC Driver 등록 (메소드 영역 로드)
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"sampleid",
					"samplepw"
					);
			
			//매개변수화된 SQL문 작성
			String sql = "" + "INSERT INTO users(userid,username,userpassword,userage,useremail)" + "VALUES(?, ?, ?, ?, ?)";
			
			//PreparedStatement 얻기 및 저장
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "winter");
			psmt.setString(2, "한겨울");
			psmt.setString(3, "12345");
			psmt.setInt(4, 25);
			psmt.setString(5, "winter@mycompany.com");
			
			//SQL 문 실행
			int rows = psmt.executeUpdate();
			System.out.println("저장된 행 수 : " + rows);
			
			//PreparedStatement 닫기
			psmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

	}

}
