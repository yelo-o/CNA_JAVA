package com.my.inheritance;
//class 부모{
//	String 국적 = "대한민국";
//	int 재산 = 10000;
//	void 부모메서드() {
//		System.out.println("저의 국적은 "+ this.국적 + ", 재산은 " + 재산 + "입니다.");
//	}
//}
//class 자식 extends 부모{
//	String 국적 = "인도";
//	int 재산 = 50000;
//	자식() {
//	}
//	자식(String 국적, int 재산){
//		this.국적 = 국적;
//		super.재산 = 재산;
//	}
//	void 자식메서드() {
//		System.out.println("저의 국적은 "+ super.국적 + ", 재산은 " + super.재산 + "입니다.");
//		System.out.println("저의 국적은 "+ this.국적 + ", 재산은 " + this.재산 + "입니다.");
//	}
//}
//
//public class inheritanceTest_02 {
//	
//	public static void main(String[] args) {
//		//부모님의 국적과 재산을 그대로 물려받은 child1
//		자식 child1 = new 자식();
//		child1.부모메서드();
//		child1.자식메서드();
//		System.out.println("=================================");
//		
//		//물려받은 국적과 재산을 생성자를 통해 바꾼 child2
//		자식 child2 = new 자식("미국", 20000);
//		child2.부모메서드();
//		child2.자식메서드();
//		
//	}
//}
