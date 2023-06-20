package com.dto.mangoplate;

public class Review {
	private int shop_no;
	private int review_no;
	private int review_rating;
	private String review_content;
	private String review_date;
	private String review_writer;
	
	public int getReview_rating() {
		return review_rating;
	}
	public void setReview_rating(int review_rating) {
		this.review_rating = review_rating;
	}
	public int getShop_no() {
		return shop_no;
	}
	public void setShop_no(int shop_no) {
		this.shop_no = shop_no;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_date() {
		return review_date;
	}
	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
	public String getReview_writer() {
		return review_writer;
	}
	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}
	
/* void print() {
		System.out.println("리뷰 순번 : " + this.reviewNo);
		System.out.println("리뷰 내용 : " + this.reviewContent);
		System.out.println("별점 : " + this.rating);
		System.out.println("작성일자 - " + this.reviewDateTime);
		System.out.println();
	}
 */
}
