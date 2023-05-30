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

# 2023.05.25(목)

## 상속
	- 다중 상속 안됨
	- 부모의 private 멤버 변수/메서드는 자식에게 물려줄 수 있다.
		- 다만, 자식이 접근을 못할 뿐
	- 상위클래스의 멤버변수와 메서드는 하위클래스에게 상속 됨. 하위클래스가 간결해짐
## super	
	- 의미 : 현재 사용중인 객체의 부모 영역
	- 메소드 내에서만 사용 가능
	- ※ this : 현재 사용중인 객체
	
## 해시코드
	- 객체 정보값
	- UML표기법 
		+hashcode():int

## 오버라이딩
	* 정의 : 상위클래스의 메서드를 하위클래스에서 재정의
	* 규칙
		- 상속관계의 메서드
		- 메서드 이름, 매개변수, 반환형 같아야 한다
		- 하위클래스의 메서드 접근 범위 >= 상위클래스의 메서드 접근 범위
			public							       public
			public, default						   default
			public, default, private			   private	

sysout(new A(5)); // A@XXXXXXXXXX 
-> void println(Object obj){; -> String의 valueOf(Object x){; -> x.toString() 호출 됨

## 자바최상위 클래스
	java.lang.Object
	
## abstract 예약어
	- abstract 메서드 : 하위 클래스에서 반드시 재정의가 되어야할 메서드 → 추상 메서드
	- 추상메서드를 포함하고 있는 클래스는 반드시 추상클래스가 되어야 함
	
## abstract vs final
abstract 메서드 : 반드시 하위클래스에서 재정의되어야 한다
final 메서드 : 하위클래스에서 재정의되면 안된다

public abstract class Test{
	abstract void m() {}
	final void m1() {}
}

class TestChild1 extends Test{} -- ERROR : m()재정의 안됨
class TestChild2 extends Test{void m(){} voidm1(){}} -- ERROR : m1() 재정의 금지된 메서드를 재정의 함


## 인터페이스
	시스템에 접속할 수 있는 접속장치
	
## SOLID 원칙
	객체지향의 SOLID 원칙이 무엇인지에 대해서 공부해 올 것