class F{
	final int i = 10; // final 변수값은 값 변경 불가
	static final int SI = 10; // 상수
}
public class FinalTest {

	public static void main(String[] args) {
		F f = new F();
		System.out.println(f.i);
//		f.i++; // 변경 불가 
		
		final int lv;
		lv = 10;
//		lv++; // 변경 불가
		
		System.out.println(F.SI);
//		F.SI++; // 값 변경 불가
		
	}

}
