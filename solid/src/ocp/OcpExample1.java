package ocp;

class Animal1 {
	String animalType;
	
	Animal1(String type) {
		this.animalType = type;
	}
	
	void cry() {
		if(animalType.equals("Cat")) {
			System.out.println("냐옹");
		}else if(animalType.equals("Dog")) {
			System.out.println("멍멍");
		}else if(animalType.equals("Bird")) {
			System.out.println("짹짹");
		}else if(animalType.equals("Duck")) {
			System.out.println("꽥꽥");
		}
	}
}

public class OcpExample1{
	//메인 메서드
	public static void main(String[] args) {
		Animal1 cat = new Animal1("Cat"); //Animal 타입의 cat 객체 생성
		Animal1 dog = new Animal1("Dog"); //Animal 타입의 dog 객체 생성
		cat.cry(); 
		dog.cry();
	}

}