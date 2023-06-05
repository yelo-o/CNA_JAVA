package com.my.exception;

public class ThorwTest2 {
	public static void main(String[] args) throws Exception{
		findClass();
	}
	
	public static void findClass() throws ClassNotFoundException {
		Class.forName("java.lang.String2");
	}
}
