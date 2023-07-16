//class Parent{
//	public Parent() {
//		System.out.print("A");
//	}
//	public Parent(int a) {
//		System.out.print("B");
//	}
//	public void fn() {
//		System.out.print("C");
//	}
//}
//class Child extends Parent{
//	public Child() {
//		System.out.print("D");
//	}
//	public Child(int a) {
//		super(a);
//		System.out.print("E");
//	}
//	public Child(double a) {
//		System.out.print("F");
//	}	
//	public void fn() {
//		System.out.print("G");
//	}
//}
//public class Problem2 {
//	public static void main(String[] args) {
//		Parent a = new Child();
//		Child b = new Child();
//		Child c = new Child(5);
//	}
//}
