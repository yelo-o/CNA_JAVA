abstract class 동물 {
	abstract void sound();
}
class 강아지 extends 동물 {
	@Override
	void sound() {
		System.out.println("멍멍");
	}
}
class 고양이 extends 동물 {
	@Override
	void sound() {
		System.out.println("야옹");
	}
}
public class inheritanceTest_09 {
	public static void main(String[] args) {
		강아지 dog = new 강아지();
		dog.sound();
		
		고양이 cat = new 고양이();
		cat.sound();
		
		animalSound(new 강아지());
		animalSound(new 고양이());
		
	}
	public static void animalSound(동물 animal) {
		animal.sound();
	}
}
