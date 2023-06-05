package com.my.exception;

class 계좌 {
	private long 잔액;
	long 잔액가져오기() {
		return 잔액;
	}
	
	void 예금하기(int money) {
		잔액 = 잔액 + money;
	}
	void 출금하기(int money) throws InsufficientException{
		if(잔액 < money) {
			throw new InsufficientException("잔고 부족 : " + (money - 잔액) + " 모자람");
		}
		잔액 = 잔액 - money;
	}
}
public class ThorwTest3 {
	public static void main(String[] args){
		계좌 account = new 계좌();
		//예금하기
		account.예금하기(10000);
		System.out.println("예금액 : " + account.잔액가져오기());
		//출금하기
		try {
			account.출금하기(30000);
		}catch(InsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
