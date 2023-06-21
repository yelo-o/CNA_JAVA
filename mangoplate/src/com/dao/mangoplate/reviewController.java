package com.dao.mangoplate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dto.mangoplate.Review;
import com.dto.mangoplate.Shop;

public class reviewController {
	Scanner sc = new Scanner(System.in);

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Shop shop = new Shop();


	public void reviewPage() {
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		list(shop);
		//		list();
		//shop_name으로 검색된 목록 펼치기
	}
	public void list(Shop shop) {
		System.out.println("[찾으시는 음식점을 입력해주세요]");
		String shopNameSearch = sc.nextLine();
		
		
		System.out.println("[음식점 목록]");
		System.out.println("---------------------------------------------------------");
		System.out.printf("%-6s%-30s\n", "번호", "음식점이름");
		System.out.println("---------------------------------------------------------");
		
		
		try {
			String sql = "SELECT * FROM shop WHERE shop_name LIKE '" + "%" + shopNameSearch + "%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int shopNo = rs.getInt("shop_no");
				String shopName = rs.getString("shop_name");
				System.out.printf("%-6s%-30s\n", shopNo, shopName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}
		
		System.out.println("원하시는 번호를 입력해주세요");
		int shopNo = Integer.parseInt(sc.nextLine());
		list(shopNo);
		
		

	}

	public void list(int shopNo) {
		System.out.println();
		
		System.out.println("[리뷰 목록]");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s%-2s\n", "번호", "작성자", "작성일", "내용", "별점");
		System.out.println("----------------------------------------------------------------------------------");
		try {
			String sql = "SELECT * FROM review";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int reviewNo = rs.getInt("review_no");
				String reviewContent = rs.getString("review_content");
				Date reviewDate = rs.getDate("review_date");
				String reviewWriter = rs.getString("user_id");
				int shopNo = rs.getInt("shop_no");
				int reviewRating = rs.getInt("review_rating");

				System.out.printf("%-6s%-12s%-16s%-40s%-2s\n", reviewNo, reviewWriter, reviewDate, reviewContent, reviewRating);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}


		mainMenu();//리스트 불러온 후 메인메뉴 호출
	}
	//메인 메뉴
	public void mainMenu() {
		System.out.println("메뉴: 1.리뷰 작성 | 2.리뷰 읽기 | 3.리뷰 검색 | 4.종료");
		String menuNo = sc.nextLine();

	}

	//리뷰 등록
	public void insert(Review review) {

	}

	//리뷰 삭제
	public void delete(Review review) {

	}





}
