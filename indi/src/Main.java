import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>(); //리스트 생성
		int x = 10;
		lst.add(x);
		while(x!=1) {
			if(x%2==0) {
				x = x/2;
				lst.add(x);
			}else{
				x = 3*x + 1;
				lst.add(x);
			}
		}
		int[] answer = new int[lst.size()];
		for(int i=0; i<answer.length;i++) {
			answer[i] = lst.get(i);
		}
//		for(int l : lst) {
//			answer[l] = l;
//			
//		}
		for(int l : answer) {
			System.out.println(l);
		}
	}
}