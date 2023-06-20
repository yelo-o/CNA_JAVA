import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.my.sql.MyConnection;

public class JDBCTest {
	public static void testProductList() {
		//1. JDBC 드라이버 로드 Class.forName()
		//2. DB연결 Connection
		//3. SQL구문을 오라클서버로 송신 : Statement, PreparedStatement - 바인드변수(?) 사용
		//executeQuery(), executeUpdate()
		//4. 송신결과 수신 : ResultSet,  int
		//5. 결과 활용 : rs.next()
		//6. DB 연결해제 : close()
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM product WHERE prod_no LIKE 'C000%' ";
			rs = stmt.executeQuery(selectSQL);
			//					while(true) {
			//						boolean flag = rs.next();
			//						if(!flag) {
			//							break;
			//						}
			//					} while(rs.next()) 와 같음
			while(rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString("prod_name");
				int price = rs.getInt("prod_price");
				System.out.println(no + "-" + name + "-" + price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, stmt, conn);
		}

	}
	public static void testProductPageList() {
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}

		//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 페이지를 입력하세요");

		int currentPage = Integer.parseInt(sc.nextLine()); //검색할 페이지 					1  2  3
		int cntPerPage = 3; //페이지당 보여줄 목록수
		int startRow = currentPage + (currentPage-1)*2; //페이지의 시작행 					1  4  7
		int endRow = startRow + 2; //페이지의 끝행 											3  6  8
		try {
			//			stmt = conn.createStatement();
			//			String selectPageSQL = "SELECT *\r\n"
			//					+ "FROM (SELECT rownum rn, a.*\r\n"
			//					+ "        FROM(SELECT *\r\n"
			//					+ "            From product\r\n"
			//					+ "            ORDER BY prod_name) a\r\n"
			//					+ "            )\r\n"
			//					+ "WHERE rn BETWEEN " + startRow +" AND " + endRow;
			//			rs = stmt.executeQuery(selectPageSQL);

			String selectPageSQL = "SELECT *\r\n"
					+ "FROM (SELECT rownum rn, a.*\r\n"
					+ "        FROM(SELECT *\r\n"
					+ "            From product\r\n"
					+ "            ORDER BY prod_name) a\r\n"
					+ "            )\r\n"
					+ "WHERE rn BETWEEN ? AND ? ";

			//바인드변수 : ? - 값을 대신함
			pstmt = conn.prepareStatement(selectPageSQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rowNum = rs.getInt("rn");
				String prodNo = rs.getString("prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				System.out.println(rowNum + ":" + prodNo + "-" + prodName + "-" + prodPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}

	}
	public static void testProductUpdate() {
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("상품번호 : ");
		String prodNo = sc.nextLine();

		System.out.println("변경할 가격 : ");
		int prodPrice = Integer.parseInt(sc.nextLine());

		//		String updateSQL = "UPDATE product SET prod_price = " +  prodPrice + " WHERE prod_no='"+prodNo+"'";
		String updateSQL = "UPDATE product SET prod_price = ? WHERE prod_no=?";
		PreparedStatement pstmt = null;
		//		Statement stmt = null;
		try {
			/*
			stmt = conn.createStatement();
			int rowcnt = stmt.executeUpdate(updateSQL); //송신 : DML(INSERT/UPDATE/DELETE) - 처리건수반환
														//  DDL(CREATE/ALTER/DROP) - 0 반환
														 */
			
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setInt(1, prodPrice);
			pstmt.setString(2, prodNo);
			int rowcnt = pstmt.executeUpdate();
			if(rowcnt==0) {
				System.out.println("수정할 상품이 없습니다");
			}else {
				System.out.println(rowcnt + "건의 상품이 수정되었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(null, pstmt, conn);
		}


	}
	public static void main(String[] args) {
		//		testProductList();
		//		testProductPageList();
		testProductUpdate();
	}
}
