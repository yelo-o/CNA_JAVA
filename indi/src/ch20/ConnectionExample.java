package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public ConnectionExample() {
	}

	public static void main(String[] args) {

		Connection conn = null;
		try {
			//JDBC Driver를 메모리에 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB와 연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", 
					"sampleid" , "samplepw" );
			System.out.println("연결 성공");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
					System.out.println("연결 끊김");
				} catch (SQLException e) {
				}
			}
		}
	}

}
