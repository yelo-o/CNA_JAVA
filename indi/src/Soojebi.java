class A{
	int a = 10;
	public A() {
		System.out.print("가");
	}
	public A(int x) {
		System.out.print("나");
	}
}
class B extends A{
	int a = 20;
	public B() {
		super();
		System.out.print("다");
	}
	public B(int x) {
		System.out.print("라");
	}
	
}
public class Soojebi {
	public static void main(String[] args) {
		B b1 = new B();
		A b2 = new B();
		System.out.print(b1.a + b2.a);
	}
}
