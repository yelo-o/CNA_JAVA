# `23.05.19(금)

## C언어(절차지향) JAVA언어(객체지향)의 다른 점
<p align="center">
    <img src="https://github.com/yelo-o/CNA_JAVA/assets/64743180/d8680942-61c5-40a9-b55f-e8d1318ab639">
</p>


# `23.05.22(월)
- lastIndexOf : 해당 문자열이 마지막으로 나오는 곳을 가리킴

- 정규표현식 <- 추후에 공부 

- 향상된 for문
	int[] numbers = new int[] {1,2,3,4,5};
	for(int number : numbers){
		System.out.print(number+" ");
	}
	>> 1 2 3 4 5
	
- 객체지향 프로그래밍 특징
	- 캡슐화 : 객체의 필드, 메소드를 하나로 묶고 실제 구현 내용을 외부에 감추는 것
	- 상속 : 부모 객체와 자식 객체가 있으며, 부모 객체는 자기가 가지고 있는
			 필드와 메소드를 자식 객체에게 물려주어 자식 객체가 사용할 수 있도록 한다.
	- 다형성 : 사용 방법은 동일하지만 실행 결과가 다양하게 나오는 성질
	
- 필드 VS 로컬변수
	- 선언 위치 : 클래스 선언 블록		   VS 생성자, 메소드 선언 블록
	- 존재 위치 : 객체 내부 			   VS 생성자, 메소드 호출 시에만 존재
	- 사용 위치 : 객체 내/외부 어디든 사용 VS 생성자, 메소드 블록 내부에서만 사용

- 메소드 오버로드 : 메서드 이름은 같고 매개변수를 다르게(자료형이 다르거나 개수가 다르거나 순서가 다르거나)

### this 메모리 구조 예시
<p align="center">
    <img src="https://github.com/yelo-o/CNA_JAVA/assets/64743180/ff4cd0d5-6173-40cf-adbd-c295326cf02b">
</p>


### static
	- 객체 단위로 관리되어야 하는 것은 static으로 만들지 말라
	- 메모리 효율성 측면에서 웬만하면 만들지 않는 것을 추천
	- this 예약어 쓸 수 없음
	- 인스턴스 메서드 사용 불가
	
### static 메모리 구조 예시
<p align="center">
    <img src="https://github.com/yelo-o/CNA_JAVA/assets/64743180/96fd1962-27d2-4a16-ade8-501e5b55c62a">
</p>

### package
	다른 패키지에 있는 클래스를 사용하려면 import 사용 ex) import com.my.asia.Korea
	
### 접근제어자(Access Modifier)
	- 종류 : public / protected / package(default) / private
	- 멤버변수 : 상수-public, 변수-private
	- 정보은닉용도
	
### 객체생성법


### 생성자
객체 생성시 자동호출되는 특수메서드
생성자명은 클래스명과 같고 반환형 없음
생성자가 없으면 기본 상태 
public class의 기본생성자는 public으로
default class의 기본생성자는 default로 만들어짐

### 자바빈(JavaBean)
	자바빈 = 컴포넌트
	컴포넌트란? : 객체보다 재사용성이 더 높은 큰 덩어리
	자바빈의 조건
		1. public class
		2. public 매개변수없는 생성자
		3. property용 멤버변수는 public이면 안됨
		4. property용 public setter메서드/getter메서드 필요 
