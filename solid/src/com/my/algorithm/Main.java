package com.my.algorithm;
public class Main {

	public static void main(String[] args) {
		int tmp = 0;
		int[] arr = {0, 1 ,2 ,3 ,4};
		int[] answer = arr;
//		int[][] queries = {{0,1,1}, {3,2,4}};
		int[][] queries = {{0,3},{1,2},{1,4}};
		System.out.println(queries[0][0] + "와" + queries[0][1]);
		// 0 & 3
		System.out.println(queries[1][0] + "와" + queries[1][1]);
		// 1 & 2
		System.out.println(queries[2][0] + "와" + queries[2][1]);
		// 1 & 4
		System.out.println("queries[0].length 개수 : " + queries[0].length);
		
		for(int i=0;i<queries[0].length;i++) {
			tmp = answer[queries[0][i]];
			answer[queries[0][i]] = answer[queries[1][i]];
			answer[queries[1][i]] = tmp;
		}
		for(int a : answer) {
			System.out.println(a);
		}
	}

}
