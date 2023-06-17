package com.mango.dto;

public class Review {
	private int shopNo;
	private int reviewNo;
	private String writer;
	private String reviewContent;
	private String reviewDate;
	
	public Review() {
		
	}
	
	public Review(int shopNo, int reviewNo, String writer, String reviewContent, String reviewDate) {
		//super();
		this.shopNo = shopNo;
		this.reviewNo = reviewNo;
		this.writer = writer;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}
	
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
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
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
}
