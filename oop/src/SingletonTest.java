class Single{
	static private Single s = new Single();
	private Single(){}
	static Single getInstance() {
//		return null; // null값으로 s1 == s2 이 되어버림
//		return new Single();
		return s;
	}
}
public class SingletonTest {
	// 객체 생성 못하게, 접근제어자
	public static void main(String[] args) {
//		Single s1 = new Single();
//		Single s2 = new Single();
		Single s1 = Single.getInstance(); // 변수가 Single 타입으로 받고 있기 때문에
		Single s2 = Single.getInstance(); // getInstance 메서드는 반환형이 Single 이어야 함
		System.out.println(s1 == s2); // false 출력
	}
}
