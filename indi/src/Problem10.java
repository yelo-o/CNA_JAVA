public class Problem10 {

	static int maxSize = 10;
	static int point= -1;
	static int[] isWhat = new int[maxSize];
	
	static void into(int num) {
		if (point >= 10) {
			System.out.println("Full");
		}
		isWhat[++point] = num;
	}
	
	static int take() {
		if (isEmpty() == true) {
			System.out.println("Empty");
		}
		return isWhat[point--];
	}
	
	static boolean isEmpty() {
		if (point == -1) {
			return true;
		}
		return false;
	}
	
	static boolean isFull() {
		if (point == 10) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
	    into(5); into(2);
	    while(!isEmpty()){
	    	System.out.print(take());
	        into(4); into(1); System.out.print(take());
	        into(3); System.out.print(take()); System.out.print(take());
	        into(6); System.out.print(take()); System.out.print(take());
	    }
	}
}
