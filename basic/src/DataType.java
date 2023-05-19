public class DataType {
	public static void main(String[] args) {
		//byte, short, int, long, float, double, char, boolean 
		byte b;
		b = 127;
		//b = 128;

		//리터럴
		System.out.println(1); //컴파일러가 1를 int로 이해
		System.out.println(123.4);//컴파일러가 123.4를 double로 이해

		long lon = 12345678901235L;
		float f = 123.4F;

		char c = '가';				
		c = '㉿';
		boolean flag = true;
		flag = false;
		//flag = 1;

		//형변환 
		lon = b; //byte->long자동형변환
		System.out.println(lon); //127

		lon = (long)f; //float->long자동형변환 안됨. 강제형변환 (자료형)대입할값
		System.out.println(lon);//123

		lon = c; //char타입은 int이상의 자료형으로 자동형변환 가능
		System.out.println(lon); //c: 가, lon: 12927
		short sh;
		//sh = c;

		//boolean자료형과는 형변환 불가
		//flag = b;
		//flag = (boolean)b;
	}
}

