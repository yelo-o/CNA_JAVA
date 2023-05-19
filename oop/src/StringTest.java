import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {

		String s1, s2, s3, s4;
		// 메모리 비교
		s1 = "HELLO";
		s2 = new String("HELLO");
		s3 = new String("HELLO");
		s4 = "HELLO";
		System.out.println(s1==s2); // false
		System.out.println(s2==s3); // false
		System.out.println(s1==s4); // true
		
		// 문자열 자체 비교
		System.out.println("-----문자열 비교-----");
		System.out.println(s1.equals(s2));
		
		System.out.println();
		
		// TODO Palindrome 문자열입니다, 아닙니다를 판단
		System.out.println("-----Palindrome 비교-----");
		String palindrome = "소주만병만주소";
		int size = palindrome.length();
		for (int i=0;i<size/2;i++) {
			if(palindrome.charAt(i) == palindrome.charAt(size-i-1)) {
				if(i == size/2-1) {
					System.out.println(palindrome + "은 Palindrome 문자열입니다");
					break;
				}
			}else {
				System.out.println(palindrome + "은 Palindrome 문자열이 아닙니다");
				break;
			}
		}
		
		
		/*
		String score = "54:89:30"; // 국어:영어:수학 점수
		String []scoreArr = score.split(":");
		System.out.println("국어 점수 : " + Integer.parseInt(scoreArr[0]));
		System.out.println("영어 점수 : " + scoreArr[1]);
		System.out.println("수학 점수 : " + scoreArr[2]);
		int k = Integer.parseInt(scoreArr[0]);
		int e = Integer.parseInt(scoreArr[1]);
		int m = Integer.parseInt(scoreArr[2]);
		System.out.println("평균 : " + (float)(k+e+m)/scoreArr.length);
		
		score = "54::30";
		scoreArr = score.split(":");
		System.out.println("국어 점수 : " + Integer.parseInt(scoreArr[0]));
		System.out.println("영어 점수 : " + scoreArr[1]);
		System.out.println("수학 점수 : " + scoreArr[2]);
		
		System.out.println("---------------------------");
		
		// 공백, 줄바꿈 등은 토큰이라고 보지 않는다
		StringTokenizer st = new StringTokenizer(score, ":"); // Token : 분리된 문자열 조각
		
		int sum = 0;
		int cnt = 0;
		while(st.hasMoreTokens()) { // score 문자열에 : 구분자로 분리할 문자열이 있는지 확인 있으면 true 반환
			String s = st.nextToken();
			System.out.println(s);
			sum += Integer.parseInt(s);
			cnt++;
		}
		System.out.println("평균 : " + (float)(sum/cnt));
		*/
		String score; // 국어:영어:수학 점수
		String []scoreArr;
		score = "54::30";
		scoreArr = score.split(":");
		System.out.println("국어:" + Integer.parseInt(scoreArr[0]));
		System.out.println("영어:" + scoreArr[1]);
		System.out.println("수학:" + scoreArr[2]);
		int k = Integer.parseInt(scoreArr[0]);
		int e = scoreArr[1].equals("")?0:Integer.parseInt(scoreArr[1]);
		int m = Integer.parseInt(scoreArr[2]);
		System.out.println("평균:" + ((float)(k+e+m)/scoreArr.length));
		
		System.out.println("--------------");
		StringTokenizer st = new StringTokenizer(score, ":");
		
		int sum = 0; //총점
		int cnt = 0; //과목수
		while(st.hasMoreTokens()) { //score문자열에 :구분자로 분리할 문자열이 있는가
			String s = st.nextToken();
			System.out.println(s);
			sum += Integer.parseInt(s);
			cnt++;
		}
		System.out.println("평균:" + ((float)sum/cnt));
		System.out.println("-----------------------");
		// 주소 url 자르기
		String urlStr = "https://n.news.naver.com/mnews/article/215/0001102585?sid=103";
		parseURL(urlStr);
	}
	static void parseURL(String url) {
		// TODO url에서 사용하는 프로토콜을 출력하시오
		// URL 구성요소 - 프로토콜://호스트명/패스?쿼리
		// hint : indexOf(), substring(), split()
		String queryData = url.substring(url.indexOf("?")+1); // "?" 위치 부터 끝까지 문자열 자르기
		String []queryDatas = queryData.split("="); // '='로 분할
		String []slashDivider = url.split("/"); // '/'로 분할
		
		// 출력
		// 프로토콜값 출력하시오 ex) n.news.naver.com
		System.out.println("프로토콜명 : "+ url.substring(0,url.indexOf(":")));
		// 호스트값 출력하시오 ex) n.news.naver.com
		System.out.println("호스트값 : "+ slashDivider[2]);
		// 패스값 출력하시오 ex) mnews/article/215/0001102585
		System.out.println("패스값 : "+ slashDivider[3]+ "/" + slashDivider[4] + "/" + slashDivider[5] + "/" + slashDivider[6].substring(0,slashDivider[6].indexOf("?")));
		// 쿼리변수이름과 변수값을 출력하시오 변수이름: sid 변수값:103
		System.out.println("변수이름 : " + queryDatas[0] + " 변수값 : " + queryDatas[1] );
		
		
		
	}
	// 강사님 코드
	/*
	static void parseURL(String url) {
		String[] arr = url.split("\\?"); //?구분자로 분리
		
		String[] protocolHostPath = arr[0].split("/");
		
		String protocol = 
				protocolHostPath[0].substring(0, 
						protocolHostPath[0].indexOf(":"));
		System.out.println("프로토콜명:" +protocol);
		
		String host = protocolHostPath[2];
		System.out.println("호스트값:" + host);
		
		String path = "";
		for(int i=3; i<protocolHostPath.length; i++) {
			if(i>2) {
				path += "/";
			}
			path += protocolHostPath[i];
		}
		if(protocolHostPath.length > 2) {
			System.out.println("패스값:" + path);
		}
		
		if(arr.length == 2) {
			String []query = arr[1].split("\\&");
			for(int i=0; i<query.length; i++) {
				String[] queryNameValue = query[i].split("=");
				String queryName = queryNameValue[0];
				String queryValue = queryNameValue[1];
				System.out.println("쿼리변수이름:" + queryName + ", 변수값:" + queryValue);
			}
		}
	}
	*/

}
