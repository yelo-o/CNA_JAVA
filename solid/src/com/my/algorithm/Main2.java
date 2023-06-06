package com.my.algorithm;
public class Main2 {
	/*
정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며,
[s, e, k] 꼴입니다. 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
	 */
	public static void main(String[] args) {
		int tmp = 0;
		int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};
		//		int[] answer = {};
		int[] answer = new int[queries[0].length];
		System.out.println("answer 배열의 길이" + queries[0].length);
		int[] arr = {0, 1 ,2 ,4 ,3};
		for(int n = 0 ; n < answer.length ; n++) {
			int s = queries[n][0];
			int e = queries[n][1];
			int k = queries[n][2];
			for(int i=s ; i<=e ; i++) {
				if(arr[i] > k) {
					answer[n] += arr[i];
					break;
				}else {
					answer[n] = -1;
				}
			}
			for(int a : answer) {
				System.out.println(a);
			}
		}
	}
}
