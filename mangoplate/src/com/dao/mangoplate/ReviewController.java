package com.dao.mangoplate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.mangoplate.Review;
import com.dto.mangoplate.Shop;
import com.main.mangoplate.MangoPlate;

public class ReviewController {
	Scanner sc = new Scanner(System.in);

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Shop shop = new Shop();

	public void reviewPage() {
		//DB연결 준비
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("메뉴: 1.음식점 전체 조회 | 2.음식점 검색 | 3.내 후기 보기 | 9.종료");
		int selection =Integer.parseInt(sc.nextLine());

		switch(selection) {
		case 1:
			list(shop);
			break;
		case 2:
			search();
			break;
		case 3:
			myReview();
			break;
		case 9:
			exit();
			break;
		}
	}

	public void list(Shop shop) {
		List<Shop> lst = new ArrayList<>();

		System.out.println("1번을 누르셨습니다.");



		System.out.println("[전체 음식점 목록]");
		System.out.println("---------------------------------------------------------");
		System.out.printf("%-6s%-15s%-20s\n", "번호", "음식점이름" , "소개");
		System.out.println("---------------------------------------------------------");

		try {
			String sql = "SELECT * FROM shop";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String shop_name = rs.getString("shop_name");
				String shop_content = rs.getString("shop_content");
				String shop_type = rs.getString("shop_type");
				lst.add(new Shop(shop_name, shop_content, shop_type));
				
			}
			for(int i=0; i<lst.size(); i++) {
				System.out.printf("%-6s%-15s%-20s\n", i+1, lst.get(i).getShop_name(), lst.get(i).getShop_content());
			}
			//번호 선택하기
			System.out.println("조회를 원하시는 번호를 입력해주세요");
			int shopNo = Integer.parseInt(sc.nextLine());
			String shopName = lst.get(shopNo-1).getShop_name();
			//상세 내용 출력하기
			sql = "SELECT * FROM shop WHERE shop_name= '" +shopName+ "'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String shop_name = rs.getString("shop_name");
				String shop_content = rs.getString("shop_content");
				System.out.printf("%-6s%-15s\n", shop_name, shop_content);
//				System.out.printf("%-6s%-15s%-20s\n", shop_name, shop_content);
			}
			//음식점 상세 조회 - 리뷰 보기
			System.out.println("메뉴: 1.리뷰 보기 | 2.리뷰 쓰기 | 9.종료");
			int selection =Integer.parseInt(sc.nextLine());

			switch(selection) {
			case 1:
				list(shop);
				break;
			case 2:
				search();
				break;
			case 3:
				myReview();
				break;
			case 9:
				exit();
				break;
			}
			//음식점 상세 조회 - 리뷰 수정하기
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}


	}

	public void search() {
		System.out.println("2번 누르셨습니다.");

		List<Shop> lst = new ArrayList<>();

		System.out.println("1번을 누르셨습니다.");

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
				String shopContent = rs.getString("shop_content");

				System.out.printf("%-6s%-15s%-20s\n", shopNo, shopName, shopContent);
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
	public void myReview() {
		System.out.println("3번 누르셨습니다.");

	}

	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		System.out.println("** 종료 **");
		System.exit(0);
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
				shopNo = rs.getInt("shop_no");
				int reviewRating = rs.getInt("review_rating");

				System.out.printf("%-6s%-12s%-16s%-40s%-2s\n", reviewNo, reviewWriter, reviewDate, reviewContent, reviewRating);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}

	}

	//리뷰 등록
	public void insert(Review review) {

	}

	//리뷰 삭제
	public void delete(Review review) {

	}
	
	//메인 메뉴
	public void mainMenu() {
		System.out.println("메뉴: 1.리뷰 작성 | 2.리뷰 읽기 | 3.내 리뷰 보기 | 9.종료");
		int selection =Integer.parseInt(sc.nextLine());
		switch(selection) {
		case 1:
			insertReaview();
			break;
		case 2:
			readReaview();
			break;
		case 3:
			myReview();
			break;
		case 9:
			exit();
			break;
		}
	}

	//1. 리뷰 작성
	public void insertReaview() {
		
		try {
			String sql = "INSERT INTO shop_review(shop_no, review_no, writer, review_content,\r\n"
					+ "review_date, review_rating)\r\n"
					+ "VALUES(?, ?, ?, ?, SYSDATE, ?);";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.setInt(1, rs.getInt("shop_no") );
			pstmt.setString(2, rs.getString("review_no"));
			pstmt.setString(3, rs.getString("writer"));
			pstmt.setString(4, rs.getString("review_content"));
			pstmt.setString(5, rs.getString("review_content"));
			System.out.println("리뷰 추가 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}
		
		
	}
	
	//2. 모든 리뷰 읽기
	public void readReaview() {
		try {
			String sql = "SELECT * FROM review";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int reviewNo = rs.getInt("review_no");
				String reviewWriter = rs.getString("writer");
				String reviewContent = rs.getString("review_content");
				Date reviewDate = rs.getDate("review_date");
				int reviewRating = rs.getInt("review_rating");

				System.out.printf("%-6s%-12s%-16s%-40s%-1s\n", reviewNo, reviewWriter, reviewDate, reviewContent, reviewRating);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, conn);
		}
	}
	
		//3. 내 리뷰 보기
		public void readMyReview() {
			
			
			
			
		}
		
		




}
