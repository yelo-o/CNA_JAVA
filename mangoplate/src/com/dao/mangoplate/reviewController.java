package com.dao.mangoplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.dto.mangoplate.Review;

public class reviewController {
	private Review review;
	Scanner sc = new Scanner(System.in);
	
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement psmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "sampleid";
	String pw = "samplepw";
	
	private static int count;

	public reviewController() {
	}
	public reviewController(Review review) {
	}
	
	public void review_page() {
		Review review = new Review();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
