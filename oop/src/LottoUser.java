
public class LottoUser {

	public static void main(String[] args) {
		//----------------------------
		//사용자1
		Lotto lotto = new Lotto();
		lotto.make();
		int value = lotto.get(1);
		System.out.println("로또 두번째숫자:" + value);
		
		System.out.println("로또숫자들");
		int valueAll[] = lotto.get();
		for(int i=0; i<valueAll.length; i++) {
			System.out.print(valueAll[i]+"\t");
		}
		System.out.println();
		//----------------------------
		//사용자2
		Lotto lotto1 = new Lotto();
		lotto1.make();
		lotto1.print();
		
	}

}
