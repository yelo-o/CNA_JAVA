public class CallByTest {

	public static void m(int i) {
		i = 9;
	}	
	public static void m(int[]arr) {
		arr[0] = 9;
	}
	public static void main(String[] args) {
		int i=0;
		m(i);
		System.out.println(i);//0
		
		int[]arr = {0,1,2,3,4};
		m(arr);
		System.out.println(arr[0]);//9

	}

}
