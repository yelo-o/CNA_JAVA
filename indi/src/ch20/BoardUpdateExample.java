package ch20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", 
					"sampleid",
					"samplepw"
					);
			System.out.println("연결 성공");
			
			//매개변수화된 SQL 문 작성
			String sql = new StringBuilder()
					.append("UPDATE boards SET ")
					.append("btitle=?, ")
					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ")
					.append("where bno=?")
					.toString();
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "비가 내려요");
			psmt.setString(2, "겨울비는 추워요");
			psmt.setString(3, "chrismas.jpg");
			psmt.setBlob(4, new FileInputStream("src/ch20/chrismas.jpg"));
			psmt.setInt(5, 3);
			
			//SQL 문 실행
			int rows = psmt.executeUpdate();
			System.out.println("수정된 행 수 : " + rows);
			
			
			//PreparedStatement 닫기
			psmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
