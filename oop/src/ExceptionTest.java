import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionTest {
	public static boolean m(int i) {
		try {
			System.out.println("99를 " + i + "로 나눈 나머지값 : " + 99%i ); //ArithmeticException 발생 가능
//			System.out.println("m() 끝");
			return true;
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
//			System.out.println("m() 끝");
			return false;
		}finally {
			System.out.println("m() 끝");
		}
	}
	
	public static void m(String str) throws NullPointerException {
		int length = str.length();
		System.out.println("문자열의 길이는 " + length);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하세요 : ");
		String line = sc.nextLine();
		try {
			i = Integer.parseInt(line); //NumberFormatException 발생 가능
			m(i);
		}catch(NumberFormatException e) {
			System.out.println("숫자로 입력하세요");
		}
		
		m("자바"); //문자열길이 2
		m(""); //문자열길이 0
		try {
			m(null); 
		}catch(NullPointerException e){
			System.out.println();
		}
		
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
//			e.printStackTrace(); //개발자 입장에서 보기 편한 메시지
			String msg = e.getMessage(); //예외상세메시지 얻기
			System.out.println(msg);
		}
		
		System.out.println("끝");
	}

}
