package com.mango.dto;

public class Review {
	private int reviewNo;
	private int rating;
	private String writer;
	private String reviewContent;
	private String reviewDateTime;
	
	public Review() {
		
	}
	
	public Review(String reviewContent, int rating, String reviewDateTime) {
		this.reviewContent = reviewContent;
		this.rating = rating;
		this.reviewDateTime = reviewDateTime;
	}
	
	public Review(String reviewContent, int rating, String reviewDateTime, int reviewNo) {
		this.reviewContent = reviewContent;
		this.rating = rating;
		this.reviewDateTime = reviewDateTime; 
		this.reviewNo = reviewNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getReviewDateTime() {
		return reviewDateTime;
	}

	public void setReviewDateTime(String reviewDateTime) {
		this.reviewDateTime = reviewDateTime;
	}

	

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public void print() {
		System.out.println("리뷰 순번 : " + this.reviewNo);
		System.out.println("리뷰 내용 : " + this.reviewContent);
		System.out.println("별점 : " + this.rating);
		System.out.println("작성일자 - " + this.reviewDateTime);
		System.out.println();
	}
}
