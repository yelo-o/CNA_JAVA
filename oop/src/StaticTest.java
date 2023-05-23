class A{
	int i; // non-static 변수, instance 변수 ,객체 생성 후에만 사용이 가능한 변수
	static int si; //static 변수, class 변수, 객체 생성과 무관한 변수
	
	void m() { // non-static 메서드
		i++; // this.i++; 와 같은 의미
		si++;
	}
	
	static void sm() { // 객체 생성과 무관하게 사용이 가능한 메서드
//		i++; // this.i++; 와 같음
		si++;
		
	}
}

public class StaticTest {

	public static void main(String[] args) {
		A.si++; // 클래스.스태틱변수++;
		System.out.println(A.si);
		
		A a1, a2;
		a1 = new A();
		a2 = new A();
		a1.i++;
		a2.i++;
		
		a1.si++; // A.si++ 로 변경하는 것이 좋음 (새로운 객체에서 si는 못 찾고 메소드 영역의 클래스에 가야 확인이 가능)
		a2.si++;

		System.out.println(a1.i); // 1
		System.out.println(a2.i); // 1
		
		System.out.println(a1.si); // 3
		System.out.println(a2.si); // 3
		
		a1.m();
		System.out.println(a1.i); // 2
		System.out.println(a2.i); // 1
		
		// a1, a2 아무 객체로 해도 상관없이 static 변수는 4
		System.out.println(A.si); // 4
		System.out.println(a1.si); // 4
		System.out.println(a2.si); // 4
		
		A.sm();
		System.out.println(A.si); // 5
		
		
		
		
	}

}
