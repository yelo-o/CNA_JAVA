package ch20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
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
			
			//매개변수화된 SQL 문 작성
			String sql = "" + "INSERT INTO boards(bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " 
			+ "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement psmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
			psmt.setString(1, "눈 오는 날4");
			psmt.setString(2, "함박눈이 내려요.4");
			psmt.setString(3, "winter");
//			psmt.setString(4, null);
//			Blob blob = null;
//			psmt.setBlob(5, blob);
			psmt.setString(4, "snow.jpg");
			psmt.setBlob(5, new FileInputStream("src/ch20/snow.jpg"));
			
			//SQL 문 실행
			int rows = psmt.executeUpdate();
			System.out.println("저장된 행 수 : " + rows);
			
			//bno 값 얻기
			if(rows == 1) {
				ResultSet rs = psmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno : " + bno);
					
					String btitle = rs.getString(2);
					System.out.println("저장된 btitle : " + btitle);
				}
				rs.close();
			}
			
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
