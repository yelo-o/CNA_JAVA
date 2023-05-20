
public class Computer {

	// 가변길이를 갖는 sum 메소드 선언
	int sum(int ... valueables) {
		int sum = 0;
		
		for(int i=0;i<valueables.length;i++) {
			sum += valueables[i];
		}
		
		return sum;
	}
}
