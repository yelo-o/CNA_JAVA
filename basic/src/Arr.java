import java.util.Arrays;
import java.util.Scanner;

public class Arr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String []subject = {"국어", "영어", "수학"}; // 생성 + 선언 + 값 대입
//		subject = {"K", "E", "M"}; // 배열 재초기화 안됨
//		subject = new String[] {"KOR", "ENG", "MATH"};

		/*
//		String []subject = new String[3];
//		subject[0] = "국어"; subject[1]= "영어"; subject[2] = "수학";
		
		
//		String []subject = new String[3];
		// 배열 초기화
//		int size = scoreArr.length;
		
		int [][]studentArr;
		studentArr = new int[5][3];
		
		int []scoreArr = new int[3];
		for(int count=0;count<5;count++) {
			System.out.println(count+1 + " 번째 학생");
			studentArr[count] = scoreArr;
			for(int i=0;i<3;i++) {
				System.out.println(subject[i]+ " 점수 : ");
				scoreArr[i] = Integer.parseInt(sc.nextLine());
			}
			int totalScore = 0;
			int size = studentArr[count].length;
			for(int i=0;i<size;i++) {
				totalScore += scoreArr[i];
			}
			System.out.println("총점 : " + totalScore);
			System.out.println("평균 : " + (float)totalScore/size);
			// 정수/실수 또는 실수/정수 의 값은 모두 실수이다.
		}
		

		int [][]studentArr;
		studentArr = new int[5][3];
		for(int studentCnt=0; studentCnt<5; studentCnt++) {
			int size = studentArr[studentCnt].length;
			// 입력 받기
			for(int i=0; i<size; i++) {
				System.out.print(subject[i]+"점수:");
				//scoreArr[i] = Integer.parseInt(sc.nextLine());
				studentArr[studentCnt][i] = Integer.parseInt(sc.nextLine());
			}
			// 입력 받은 값 더하기
			int totalScore = 0;//총점
			for(int i=0; i<size; i++) {
				totalScore += studentArr[studentCnt][i];//scoreArr[i]; // totalScore = totalScore+scoreArr[i];
			}
			System.out.println("총점:" + totalScore);
			System.out.println("평균:" + (float)totalScore/size);
		}
		// 과목별 평균
		System.out.println("과목별평균");
		int sizeStudent = studentArr.length; // 학생 수
		int sizeSubject = studentArr[0].length; // 과목 수
		int sum = 0;
		for(int j=0;j<sizeSubject;j++) {
			for(int i=0;i<sizeStudent;i++) {
				sum += studentArr[i][j];
			}
			System.out.println(subject[j] + "의 평균 : " + (float)sum/sizeStudent);
		}
		
		String[] zodiacArr = {"원숭이" , "닭", "개", "돼지", "쥐", "소" ,"호랑이", "토끼", "용", "뱀", "말", "양"};
		System.out.print("출생년도를 입력하세요:");
		int birthYear = Integer.parseInt(sc.nextLine());
		System.out.println(zodiacArr[birthYear%zodiacArr.length] + "띠 입니다");
		 */

		/*
		// 아래는 삭제 해도 무방
		// 국어, 영어, 수학 3가지 과목 있음
		// 학생은 5명
		// 
		
		String []subject = {"국어", "영어", "수학"}; // 생성 + 선언 + 값 대입
		int subjectSize = subject.length; // 3
		int [][]studentArr; //학생수 5, 과목수 3
		studentArr = new int[5][subjectSize]; // 5
		int studentSize = studentArr.length;
		
		// 학생별로 과목별 점수 입력받기
		for(int i=0;i<studentSize;i++) {
			int sum = 0;
			for(int j=0;j<subjectSize;j++) {
				System.out.println(subject[j]+ " 점수를 입력하세요 : ");
				studentArr[i][j] = Integer.parseInt(sc.nextLine());
				sum += studentArr[i][j];
			}
				System.out.println("합 : " + sum );
				System.out.println("평균 : " + sum/subjectSize);
		}
		
		// 과목별 평균 구하기
		System.out.println("<과목별 평균>");
		int sum = 0;
		for(int i=0;i<subjectSize;i++) {
			for(int j=0;j<studentSize;j++) {
				sum += studentArr[j][i];
			}
			System.out.println(subject[i] + " 평균 : " + sum/studentSize);
		}
		
		*/
		
		/*
		// 출현횟수 계산 방법 -1
		int []countArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int []numArr = {1, 10, 3, 2, 1, 2, 2, 5, 6, 3, 1, 4, 4, 9, 9};
		// 1의 출현 횟수 : 3회
		// 2의 출현 횟수 : 3회 
		int cnt;
		for(int i=0;i<countArr.length;i++) {
			cnt = 0;
			for(int j=0;j<numArr.length;j++) {
				if(countArr[i] == numArr[j]) {
					cnt += 1;
				}
			}
		System.out.println(countArr[i] + " 의 출현 횟수는 "+ cnt);
		}

		 */
		// 출현횟수 계산 방법 - 2
		int []result = new int[10];
		int []numArr = {1, 10, 3, 2, 1, 2, 2, 5, 6, 3, 1, 4, 4, 9, 9};
		for(int i=0;i<numArr.length;i++) {
			result[numArr[i]-1]++;
		}
		for(int i=0;i<result.length;i++) {
			System.out.println((i+1) + "의 출현횟수 : " + result[i]);
		}
		
		numArr = new int[] {7, 3, 6, 10, 2, 15, 4};
		int max = numArr[0];
		for(int i=1;i<numArr.length;i++) {
			if(numArr[i] > numArr[i-1] ) {
				max = numArr[i];
			}
		}
		System.out.println("최댓값 : " + max);

		// 중간값 계산도 해볼 것
		
		// 정렬(sort) 알고리즘 공부
		// 종류, 특징 : 선택정렬, 버블정렬 <- 구현할 줄 알아야 함
		
		int [][]numArr2 = new int[3][3];
		int num = 1;
		for(int i=0;i<numArr2.length;i++) {
			for(int j=0;j<numArr2[i].length;j++, num++) {
				numArr2[i][j] = num;
			}
		}
		
		for(int i=0;i<numArr2.length;i++) {
			for(int j=0;j<numArr2[i].length;j++, num++) {
				System.out.print(numArr2[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		int [][]numArr3 = new int[3][3];
		for(int i=0;i<numArr3.length;i++) {
			for(int j=0;j<numArr3[i].length;j++, num++) {
				numArr3[j][i] = numArr2[i][numArr3.length-j-1];
			}
		}
		
			
		for(int i=0;i<numArr3.length;i++) {
			for(int j=0;j<numArr3[i].length;j++, num++) {
				System.out.print(numArr3[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		// 열의 개수가 다른 행렬 
		int [][]numArr4 = new int[3][]; // 행만 미리 지정하고 열을 각자 다르게 지정하기 위해 선언
		for(int i=0;i<numArr4.length;i++) {
			numArr4[i] = new int[i+1];
		}
		int cnt = 1;
		for(int i=0;i<numArr4.length;i++) {
			for(int j=0;j<numArr4[i].length;j++, cnt++)
				numArr4[i][j] = cnt;
		}
		
		for(int i=0;i<numArr4.length;i++) {
			for(int j=0;j<numArr4[i].length;j++, num++) {
				System.out.print(numArr4[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-------------------");
		
		int [][]numArr5 = new int[5][];
		for(int i=0;i<numArr5.length;i++) {
			numArr5[i] = new int[i+1];
		}
		// 기본 값 1 대입
		for(int i=0;i<numArr5.length;i++) {
			for(int j=0;j<numArr5[i].length;j++) {
				numArr5[i][numArr5[i].length - 1] = 1; // 각 행의 마지막 열에 1 대입
				numArr5[j][0] = 1; // 각 해의 첫번째 열에 1 대입
			}
		}
		// 더한 값 대입
		for(int i=1;i<numArr5.length-1;i++) { // 5
			for(int j=i+1;j<=numArr5.length-1;j++) { // 3
				
				numArr5[j][i] = numArr5[j-1][i-1] + numArr5[j-1][i];
			}
		}
		
		// 결과 값 출력
		for(int i=0;i<numArr5.length;i++) {
			for(int j=0;j<numArr5[i].length;j++, num++) {
				System.out.print(numArr5[i][j] + "\t");
			}
			System.out.println();
		}
		
//				numArr5[2][1] = numArr5[1][0] + numArr5[1][1];
//				numArr5[3][1] = numArr5[2][0] + numArr5[2][1];
//				numArr5[4][1] = numArr5[1][0] + numArr5[1][1];
//				numArr5[3][2] = numArr5[2][1] + numArr5[2][2];
//				numArr5[4][2] = numArr5[3][1] + numArr5[3][2];
//				numArr5[4][3] = numArr5[3][1] + numArr5[3][2];
		// 강사님 풀이
		
		System.out.println();
		System.out.println("--------------------------");
		
		// 로또 숫자 얻기
		int []lotto = new int[6];
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
		
		// 출력
		for(int i=0;i<lotto.length;i++) {
			System.out.print(lotto[i] + "\t");
		}
		System.out.println();
		System.out.println("----------------------------------------------------");

		//---------------sort-------------
		numArr = new int[] {3, 2, 6, 5, 1,4};
		Arrays.sort(numArr); // 오름차순만 가능
		for(int i=0;i<numArr.length;i++) {
			System.out.print(numArr[i] + "\t");
		}
		
		//---------------copy-------------
		int []copy = new int[numArr.length];
		for(int i=0;i<copy.length;i++) {
			copy[i] = numArr[i];
		}
		int originIndex = 0; // 원본위치 
		int destIndex = 0; // 대상본위치(붙여넣기 할 위치)
		System.arraycopy(numArr, originIndex, copy, destIndex, copy.length);
		//                원본소스,           0,대상본소스,        0,     대상본길이
	}

}