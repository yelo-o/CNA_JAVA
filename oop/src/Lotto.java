/**
 * 로또 숫자 얻기 : 1~45 사이의 중복되지 않는 6개 숫자
 * @author 김민규
 * @version 1.0
 */
public class Lotto {
	int []lotto = new int[6];
	
	/**
	 * 로또숫자 계산한다
	 */
	public void make() {
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45 + 1); // 1<= <46
			// 중복 확인
			for(int j=0;j<i;j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
	}
	/**
	 * index에 해당하는 로또숫자를 반환한다
	 * index가 0미만 이거나 index가 6이상인 경우는 -1을 반환한다
	 * @param index 로또 숫자위치
	 * @return 로또숫자값
	 */
	public int get(int index) {
		if(index<0 || index >=lotto.length) {
			System.out.println("로또숫자위치 [" + index+ "]가 잘못되었습니다.");
			return -1;
		}
		return lotto[index];
	}
	/**
	 * 모든 로또숫자들을 반환한다
	 * @return 모든 로또숫자값들
	 */
	
	public int[] get() {
		return lotto;
	}
	
	/**
	 * 로또숫자들을 출력한다
	 */
	public void print() {
		for(int i=0;i<lotto.length;i++) {
			System.out.print(lotto[i] + "\t");
		}
		System.out.println();
	}
	
	
	// 출력
	
}
