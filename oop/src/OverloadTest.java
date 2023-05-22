class R{ // 사각형
	double area;
	void make(double w) {
		area = w * w;
	}
	void make(double w, double h) {
		area = w * h;
	}
	void print() {
		System.out.println("사각형의 면적은 " + area + "입니다");
	}
}

public class OverloadTest {
	public static void main(String[] args) {

		R r1 = new R();
		r1.make(3,4); // 적절한 타입(int)의 매개변수가 없지만 double 타입으로 자동 형변환되어 전달 됨
		
		R r2 = new R();
		r2.make(5.0);
		
		r1.print();
		r2.print();
		
	}

}
