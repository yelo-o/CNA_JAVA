import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
//		System.out.println("WELCOME");
//		System.out.println("WELCOME");
//		System.out.println("WELCOME");
//		System.out.println("WELCOME");
//		System.out.println("WELCOME");
		for(int i=0;i<5;i++) {
			System.out.println(i + " : WELCOME");
		}
		System.out.println("-------------------");
		int iw = 0;
		while(iw<5) {
			System.out.println(iw + " : WELCOME");
			iw++;
		}
		
		for(int i=1;i<6;i++) {
			System.out.print(i);
		}
		
		System.out.println();
		
		for(int i=11;i<16;i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for(int i=1;i<42;i+=10) {
		}
		System.out.println();
		System.out.println("-------------------");
		
		//while문으로 1, 11, 21, 31, 41 출력하기
		iw = 1;
		while(iw<42) {
			if(iw>1) {
				System.out.print(",");
			}
			System.out.print(iw);
			iw +=10;
		}
		
		System.out.println();
		System.out.println("-------------------");
		
		for(int i=0;i<5;i++) {
			if(i>0) {
				System.out.print(",");
			}
			System.out.print((i*10)+1);
		}
		System.out.println();

		//A,B,C,D,...,Z
		// 문자를 유니코드로 변환하면 int 타입의 숫자로 변환
		for(int i=65;i<91;i++) {
			if(i>65) {
				System.out.print(",");
			}
			System.out.print((char)i);
		}
		System.out.println();
		System.out.println("while로 A~Z출력");
		
		//while로 A~Z 출력
		int cw = 65;
		while(cw<91) {
			if(cw>65) {
				System.out.print(",");
			}
			System.out.print((char)cw);
			
			cw++;
		}
		
		
		System.out.println();
		
		// 피보나치 수열 : 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
		int bb = 1; // 전전수
		int b = 0; // 전수
		int current = 1; // 현재수
		for(int i=0;i<20;i++) {
			if(i>0) {
				System.out.print(",");
			}
			System.out.print(current);
			bb = b;
			b = current;
			current = bb+b;
		}
		
		System.out.println();
		System.out.println("while문으로 피보나치 수열 작성");
		iw = 0;
		bb = 1;
		b = 0;
		current = 1;
		while(iw<20) {
			if(iw>0) {
				System.out.print(",");
			}
			System.out.print(current);
			bb = b;
			b = current;
			current = bb+b;
			iw++;
		}
		
		
		/*
		System.out.println();
		bb = 1;
		b = 0;
		current = 1;
		current = bb+b;
		System.out.print(current);
		bb = b;
		b = current;
		current = bb+b;
		System.out.print(current);
		bb = b;
		b = current;
		current = bb+b;
		System.out.print(current);
		bb = b;
		b = current;
		current = bb+b;
		System.out.print(current);
		bb = b;
		b = current;
		current = bb+b;
		System.out.print(current);
		bb = b;
		b = current;
		current = bb+b;
		System.out.print(current);
		*/
		System.out.println();
		//1,2,3,4,5,6,7,...100. 단 7의 배수는 출력하지 않는다.
		for(int i=1;i<101;i++) {
			if(i>1 && i%7!=0) {
				System.out.print(",");
			}
//			if(i%7!=0) {
//				System.out.print(i);
//			}s
			if(i%7==0) {
				continue; // 즉시 상단의 증감치(i++)로 이동
				//break; // for 문 종료
			}
			System.out.print(i);
		}
		
		System.out.println();
		
		//1~100까지 출력하시오. 단, 짝수는 출력하지 않는다.
		for(int i=1;i<101;i++) {
			if(i>1 && i%2!=0) {
				System.out.print(",");
			}
			if(i%2==0) {
				continue;
			}
			System.out.print(i);
		}
		
		System.out.println();
		
		for(int i=1;i<100;i+=2) { //반복 횟수 줄어듬
			if(i>1) {
				System.out.print(",");
			}
			System.out.print(i);
		}
		
		System.out.println();
		
		//1~100까지의 합을 출력하시오.
		int sum = 0;
		for(int i=1;i<101;i++) {
			sum += i;
		}
		System.out.print("1~100 합 : " + sum);
		
		System.out.println();
		
		//1~100까지의 숫자들의 홀수합, 짝수합을 출력하시오
		int sumOdd = 0; // 홀수합
		int sumEven = 0; //짝수합
		for(int i=1;i<101;i++) {
			if(i%2!=0) {
				sumOdd += i;
			}else {
				sumEven += i;
			}
		}
		System.out.println("홀수합 : " + sumOdd);
		System.out.println("짝수합 : " + sumEven);
		
		// 구구단 :2단~5단까지 *1~*9까지 출력하시오
		// 8의 배수는 출력하지 않는다
		// 25 이상인 경우 더 이상 출력하지 않는다
		for(int dan=2;dan<6;dan++) {
			for(int i=1;i<10;i++) {
				if(dan*i >= 25) {
					dan = 100;
					break;
				}
				if(dan*i%8==0) {
					continue;
				}
				if(i>1) {
					System.out.print(",");
				}
				System.out.print(dan*i);
			}
			System.out.println();
		}
		// 1~10까지 출력하시오
		for(int i=1;i<=10;i++) {
			System.out.println(i);
		}
		System.out.println("---------------");
		
		iw=0;
		while(iw<10) { //1~10까지 출력하시오 - 1
			iw++;
			System.out.println(iw);
		}
		System.out.println("---------------");
		
		iw = 0;
		while(++iw<=10) {//1~10까지 출력하시오 - 2
			System.out.println(iw);
		}
		
		System.out.println("---------------");
		
		for(int i=0;i<10;) { //1~10까지 출력하시오 - 3
			i++;
			System.out.println(i);
		}
		
		System.out.println("---------------");
		
		// 키보드 자원과 연결
		Scanner sc = new Scanner(System.in);
		
//		while(true) { // <- 무조건 반복 수행
//			System.out.print("값을 입력하세요. 종료하려면 q를 입력하세요: ");
//			// 키보드로부터 입력
//			String line = sc.nextLine();
//			System.out.println("입력한 값은 " + line + "입니다");
//			if("q".equals(line)) { // 주의! String 비교는 .equals() 써야 함
//				break;
//			}
//		}
		
		String line;
		do {
			System.out.print("값을 입력하세요. 종료하려면 q를 입력하세요: ");
			// 키보드로부터 입력
			line = sc.nextLine();
			System.out.println("입력한 값은 " + line + "입니다");
		}while(!"q".equals(line));
		
		
		int num;
		for(num=10;num<10;num++) {
			System.out.println(num);
		}
		
		while(num<10) {
			System.out.println(num);
			num++;
		}
		
		do {
			System.out.println(num);
			num++;
			
		}while(num<10);
		
		int []scoreArr; // 배열 선언
		scoreArr = new int[3]; // 배열 생성
		scoreArr[0] = 10;
		scoreArr[1] = 8;
		scoreArr[2] = 5;
		int totalScore = 0;
		for (int i=0;i<2;i++){
			totalScore += scoreArr[i];
		}
		System.out.println(totalScore);
		System.out.println();
		
	}

}
