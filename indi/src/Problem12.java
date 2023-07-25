public class Problem12 {
	public static void main(String[] args) {
		int[] n = new int[] {73, 95, 82};
		
		int sum = 0;
		
		for (int i = 0; i < 3; i++){
			sum += n[i];
		}
		
		switch(sum/30){
			case 10:
			case 9: System.out.print("A");
			case 8: System.out.print("B");
			case 7:
			case 6: System.out.print("C");
			default: System.out.print("D");
		}
	}
}
