package com.my.exception;

public class ExceptionTest2 {
	public static void printLength(String data) {
		try {
			int result = data.length();
			System.out.println("문자수 : " + result);
		}catch(NullPointerException e) {
			System.out.println("<예외정보 얻는 법 #1>");
			System.out.println(e.getMessage());
			System.out.println("<예외정보 얻는 법 #2>");
			System.out.println(e.toString());
			System.out.println("<예외정보 얻는 법 #3>");
			e.printStackTrace();
		}finally {
			System.out.println("[finally] 실행\n");
		}
	}

	public static void main(String[] args) {
		System.out.println("[프로그램 시작]\n");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}
}
