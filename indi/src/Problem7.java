class Parent{
	String name="Parent";
	public Parent() {
		System.out.print(this.name);
	}
}
class Child extends Parent{
	public Child(String name) {
		System.out.print(this.name);
	}
}
public class Problem7 {
	public static void main(String[] args) {
		Child c = new Child("Soojebi");
	}
}