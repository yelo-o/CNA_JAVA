package com.my.asia;

public class Korea { // public 없애면 다른 패키지에서 Korea 클래스 사용 불가
	public String capital = "서울";
	String language;
	private int population;

	public Korea() {
		capital = "서울";
		language = "한국어";
		population = 3;
	}
	
	public void print() {
		System.out.println("인구 : " + population);
	}
	/**
	 * 인구 증가한다
	 */
	public void up() {
		population++;
	}
	/**
	 * 인구 감소한다
	 */
	public void down() {
		if(population == 1) {
			System.out.println("인구는 0이상이어야합니다");
			return;
		}
		population--;
	}
}
