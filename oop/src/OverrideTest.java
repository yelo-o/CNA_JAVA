abstract class Shape{
	protected double area;
	abstract void make(); //하위클래스에서 반드시 재정의해야할 메서드
	void print() {
		System.out.println("면적은 "+ area);
	}
	public String toString() {
		return "도형의 면적 :" + area;
	}
}
class Circle extends Shape{
	private int radius;
	Circle(int radius){
		if(radius > 0) {
			this.radius = radius;
		}else {
			System.out.println("반지름은 0보다 커야합니다");
		}
	}
	void make() {
		this.area = Math.PI * Math.pow(radius, 2);
	}
	void print() {
		System.out.println("반지름이 " + this.radius + "인 원의 " );
		super.print();
	}
	public String toString() {
		return "원 " + super.toString();
	}
}
class Rectangle extends Shape{
	private int width, height;
	Rectangle(int width, int height){
		if(width>0 && height>0) {
			this.width = width;
			this.height = height;
		}
	}
	void make() {
		area = width * height;
	}
	void print() {
		System.out.println("가로" + this.width + ", 세로 " + this.height + "인 사각형의 ");
		super.print();
	}
}
class Triangle{
	public static void test(Shape s) {
		s.make();
		s.print();
		System.out.println(s); //s.toString() 메서드 호출됨
	}
}

public class OverrideTest {
	public static void test(Shape s) {
		s.make();
		s.print();
		System.out.println(s); //s.toString() 메서드 호출됨
								//Circle@XXXX
								//Rectangle@XXXX
								//도형의 면적:~
								//도형의 면적:~
	}
	
	public static void main(String[] args) {
		Circle c;
		Rectangle r;
		Triangle t;
		
		c = new Circle(5); //반지름이 5인 원객체
//		c.mc(); //원의 면적을 계산한다
//		c.print();
		test(c);

		r = new Rectangle(3,4);
//		r.mr();
//		r.print();
		test(r);
		
		Shape s;
//		s = new Shape(); //abstract class는 객체 생성 불가
	}

}
