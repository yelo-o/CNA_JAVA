package ocp;

abstract class Animal {
	String animalType;
	
	abstract void cry(); // 변경 발생 부분 추상화를 통한 분리
}

class Cat extends Animal {
	@Override
	void cry() { 
		System.out.println("냐옹");
	}
}

class Dog extends Animal {
	@Override
	void cry() { 
		System.out.println("멍멍");
	}
}

public class OcpExample2{
	//메인 메서드
	public static void main(String[] args) {
		Cat cat = new Cat(); //Animal 타입의 cat 객체 생성
		Dog dog = new Dog(); //Animal 타입의 dog 객체 생성
		cat.cry();
		dog.cry();
	}
}


