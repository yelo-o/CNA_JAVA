class Shape{
	double area;
	void make() {
		
	}
	void print() {
		System.out.println("면적은 "+ area);
	}
	public String toString() {
		return "도형의 면적 :" + area;
	}
}
class Circle extends Shape{
	int radius;
	Circle(int radius){
		this.radius = radius;
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
	int width, height;
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
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
	}

}
