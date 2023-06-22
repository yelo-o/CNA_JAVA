package com.dao.mangoplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.dto.mangoplate.User;

public class userController {
	private User user;
	public userController() {
		
	}
	public userController(User user) {
		
	}
	
	//일반고객 회원가입
	public static void user_register() {
		String userID;
		String passwd;
		String name;
		String address;
		String phone;
		String email;
		String birth;
		int user_type;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ID를 입력하세요.");
		userID = sc.nextLine();
		while("".equals(userID)) {
			System.out.println("ID는 필수입니다. ID를 입력하세요.");
			userID = sc.nextLine();
		}
		
		System.out.println("비밀번호를 입력하세요");
		passwd = sc.nextLine();
		System.out.println("성명을 입력하세요.");
		name = sc.nextLine();
		System.out.println("주소를 입력하세요.");
		address = sc.nextLine();
		System.out.println("전화번호를 입력하세요.");
		phone = sc.nextLine();
		System.out.println("이메일을 입력하세요");
		email = sc.nextLine();
		System.out.println("생년월일을 입력하세요.YY/MM/DD");
		birth = sc.nextLine();
		user_type = 2;
		
		User user = new User(userID, passwd, name, address, phone, email, birth, user_type);
		userController controller = new userController();
		controller.insert(user);
		
	}
	
	public void insert(User user) {
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		
		String registerSQL =
				"INSERT INTO mango_user (userid, passwd, name, address, phone, email, birth, user_type) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(registerSQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPhoneNum());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getBirth());
			pstmt.setInt(8, user.getUser_type());
			pstmt.executeUpdate();
			System.out.println("회원가입 성공!");
		
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("이미 존재하는 ID입니다.");
			System.out.println("회원가입 되지않고 처음으로 돌아갑니다.");
//			e.printStackTrace();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("구문입력 오류");
			System.out.println("회원가입 되지않고 처음으로 돌아갑니다.");
		} finally {
			MyConnection.close(null, pstmt, conn);
		}
	}
	
	//일반고객 로그인
	public static void login() {
		String userID;
		String passwd;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ID를 입력하세요");
		userID = sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		passwd = sc.nextLine();
		
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String loginSQL =
				"SELECT userid, passwd\r\n"
				+ "FROM mango_user\r\n"
				+ "WHERE userid = ? AND passwd = ?";
		try {
			pstmt = conn.prepareStatement(loginSQL);
			pstmt.setString(1, userID);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				throw new SQLException();
			} else {
				System.out.println("로그인이 되었습니다");												
			}

		} catch (SQLException e) {
			System.out.println("ID 혹은 비밀번호가 틀렸습니다");
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}	
		
	}
	
	//일반고객 회원정보 수정
	public static void user_modify(String userID) {
		
		String passwd;
		String name;
		String address;
		String phone;
		String email;
		String birth;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("새 비밀번호를 입력하세요");
		passwd = sc.nextLine();
		System.out.println("새 성명을 입력하세요.");
		name = sc.nextLine();
		System.out.println("새 주소를 입력하세요.");
		address = sc.nextLine();
		System.out.println("새 전화번호를 입력하세요.");
		phone = sc.nextLine();
		System.out.println("새 이메일을 입력하세요");
		email = sc.nextLine();
		System.out.println("새 생년월일을 입력하세요.YY/MM/DD");
		birth = sc.nextLine();
		
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		
		String SQL =
				"UPDATE mango_user\r\n"
				+ "SET passwd = ?, name = ?, address = ?, phone = ?, email = ?, birth = ?\r\n"
				+ "WHERE userid = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, passwd);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, birth);
			pstmt.setString(7, userID);
			pstmt.executeUpdate();
			System.out.println("수정되었습니다");												
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(null, pstmt, conn);
		}
		

	}
	
}


