package com.my.exception;

public class InsufficientException extends Exception{
	InsufficientException(){ // 기본 생성자
		
	}
	InsufficientException(String message){ // 예외 메시지 입력받는 생성자
		super(message);
	}
}
