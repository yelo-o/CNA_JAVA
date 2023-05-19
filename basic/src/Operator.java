public class Operator {
	public static void main(String[] args) {
		int a,b,c;
		
		//산술연산자 +,-,*,/,%
		a=3;
		b=5;
		c=a+b;
		System.out.println(c); //8
		System.out.println(a-b);//-2
		System.out.println(a/b);//0
		System.out.println(b/a);//1
		System.out.println(a%b);//3
		System.out.println(b%a);//2
		
		System.out.println(a+b*c);//*연산먼저처리 43
		System.out.println(a+b-c);//연산우선순위가 같은 경우에는 왼쪽에서 오른쪽으로 연산처리
		//System.out.println(a/0);//ArithmeticException예외발생. 프로그램이 자동종료됨

		short sa, sb, sc;
		sa=3;
		sb=5;
		sc=(short)(sa + sb);//sa,sb값이 int로 자동형변환
		         //short타입인 sc에 대입되려면 sa+sb결과를 short타입으로 강제형변환 필요
		System.out.println(sc);//8
		
		
		//비교연산자 >, <, >=, <=, ==, !=
		a=3;
		b=5;
		System.out.println(a>b);//false
		System.out.println(a<b);//true
		System.out.println(a==b);//false
		System.out.println(a!=b);//true
		
		//대입연산자 =, +=, -=, *=, /=, %=
		a=3;
		a+=1; //a값에 1증가하여 a에 대입 a=a+1;와 같음
		System.out.println(a); //4
		
		a-=2;//a값에 2감소하여 a에 대입  a=a-2;와 같음
		a*=3;
		a/=4;
		a%=5;//
		
		//단항연산자 ++, --
		a=3;
		a++;
		System.out.println(a); //4
		
		byte by;//-128~127
		by=127;
		by=(byte)(by+1);
		System.out.println(by);//-128
		
		by=127;
		by+=1;
		System.out.println(by);
		
		by=127;
		by++;
		System.out.println(by);
		
		//삼항연산자 ? :
		a=3;
		String result = a%2==0?"짝수":"홀수";
		System.out.println(result);//홀수
		
		//논리연산자 &, |, &&, ||, !
		a=3;
		b=5;
		System.out.println(a < b & a%2==1);//true
		System.out.println(a > b & a%2==1);//false
		System.out.println(a < b & a%2==0);//false
		System.out.println(a > b & a%2==0);//false
		
		System.out.println(a < b && a%2==1);//true
		System.out.println(a > b && a%2==1);//false
		System.out.println(a < b && a%2==0);//false
		System.out.println(a > b && a%2==0);//false
		
		System.out.println(a < b | a%2==1);//
		System.out.println(a > b | a%2==1);//
		System.out.println(a < b | a%2==0);//
		System.out.println(a > b | a%2==0);//false
		
		System.out.println(a < b || a%2==1);//
		System.out.println(a > b || a%2==1);//
		System.out.println(a < b || a%2==0);//
		System.out.println(a > b || a%2==0);//false
		
		System.out.println(!(a < b));//false
			
		
		//연산우선순위높이기 : ( )
		//비트연산자
		a=1;
		b=0;
		System.out.println(a & b); //int & int 비트연산
		System.out.println(a | b); //int | int 비트연산
		System.out.println(a<b & a%2==1);// boolean & boolean 논리연산
		System.out.println(a<b | a%2==1);
	}
}