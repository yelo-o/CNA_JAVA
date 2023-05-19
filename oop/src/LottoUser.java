public class LottoUser {

	public static void main(String[] args) {
		//----------------------------
		//사용자1
		// 아래에 선언된  lotto 와 lotto1는 참조형 지역변수
		Lotto lotto = new Lotto(); // new를 만나면 Heap 메모리 공간에 할당
		lotto.make();
		int value = lotto.get(1);
		System.out.println("로또 두번째숫자:" + value);
		
		System.out.println("로또숫자들");
		int []valueAll = lotto.get();
		for(int i=0; i<valueAll.length; i++) {
			System.out.print(valueAll[i]+"\t");
		}
		System.out.println();
		//----------------------------
		//사용자2
		Lotto lotto1 = new Lotto();
		lotto1.make();
		lotto1.print();
		
		// String 타입 비교
		// 메모리 비교
		System.out.println("메모리 비교");
		String s1 = new String("Hello");
		String s2 = "Hello";
		String s3 = new String("Hello");
		String s4 = "Hello"; // s4 = s2;
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);
		System.out.println(s2==s4);
		
		// 문자열 자체 비교
		System.out.println("문자열 비교");
		System.out.println(s1.equals(s2));
		
	}

}
