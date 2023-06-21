package com.main.mangoplate;

import java.util.Scanner;

import com.dao.mangoplate.reviewController;
import com.dao.mangoplate.shopController;



public class MangoPlate {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shopController ceo = new shopController();
		reviewController reviewCon = new reviewController();
		Scanner sc = new Scanner(System.in);
		String func_ch,ceo_ch,cus_ch,adin_ch;

		do {
			System.out.println("안녕하세요! 망고 플레이트 입니다! - ver.Console");
			System.out.println("점주기능 : 1, 소비자 기능 : 2, 관리자 기능 : 3, 종료 : 9");
			func_ch=sc.nextLine();

			if(func_ch.equals("1")) {
				//점주기능 호출
				System.out.println("음식점 승인 요청 : 1, 음식점 수정 : 2, 음식점 조회 : 3, 음식점 철회 : 4 종료 : 9");
				ceo_ch = sc.nextLine();
				
				if(ceo_ch.equals("1")) {
					//승인요청 메소드 호출
					ceo.ceo_page();
				}
				else if(ceo_ch.equals("2")) {
					//음식점 수정 메소드 호출
				}
				else if(ceo_ch.equals("3")) {
					//음식점 조회 메소드 호출
				}
				else if(ceo_ch.equals("4")) {
					//음식점 철회 메소드 호출
				}
			}
			else if(func_ch.equals("2")) {
				//소비자 기능 호출
				System.out.println("가입 : 1, 로그인 : 2, 음식점 조회 : 3, 음식점 검색 : 4, 음식점 별점주기 : 5, 음식점 후기 쓰기 :6, 종료 : 9");
				cus_ch = sc.nextLine();
				
				if(cus_ch.equals("1")) {
					//가입 메소드 호출
				}
				else if(cus_ch.equals("2")) {
					//로그인 메소드 호출
				}
				else if(cus_ch.equals("3")) {
					//음식점 조회 메소드 호출
				}
				else if(cus_ch.equals("4")) {
					//음식점 검색 메소드 호출
				}
				else if(cus_ch.equals("5")) {
					//음식점 별점 메소드 호출
				}
				else if(cus_ch.equals("6")) {
					//음식점 후기 메소드 호출
					reviewCon.reviewPage();
				}
			}

		}while(!func_ch.equals("9"));

	}

}
