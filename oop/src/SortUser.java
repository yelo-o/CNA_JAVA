
public class SortUser {

	private static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<arr.length-i;j++) {
				if(arr[j-1] > arr[j]) {
					swap(arr,(j-1),j);
				}
			}
		}
	}
	
	private static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int indexMin = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[indexMin] > arr[j]) {
					indexMin = j;
				}
			}
			swap(arr,indexMin,i);
		}
	}
	
	private static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}
	
	private static void swap(int []arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 버블 정렬 
		// 1. 배열 정렬
		// 2. 출력
		int[] arr = {3,5,4,2,1};
		printArray(arr);
		System.out.println();
//		bubbleSort(arr);
		selectionSort(arr);
		printArray(arr);
		

		

	}

}
