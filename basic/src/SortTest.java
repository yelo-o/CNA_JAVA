
public class SortTest {

	public static void main(String[] args) {
		// TODO 정렬 알고리즘 구현 - 버블정렬, 선택정렬
		// 1. 버블정렬 
		System.out.println("---버블정렬---");
		int temp = 0;
		int[] arr = new int[] {3,2,1,5,4};
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<arr.length-i;j++) {
				if(arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	
		System.out.println();
		System.out.println();
		
		// 2. 선택정렬
		System.out.println("---선택정렬---");
		
		temp = 0;
		int indexMin;
		arr = new int[] {3,2,1,5,4};
		for(int i=0;i<arr.length;i++) {
			indexMin = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[indexMin] > arr[j]) {
					indexMin = j;
				}
			}
			// 스왑
			temp = arr[indexMin];
			arr[indexMin] = arr[i];
			arr[i] = temp;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}

		}

}
