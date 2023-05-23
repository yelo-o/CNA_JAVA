class R2{
	int width;
	int height;
	float area;
	
	// 생성자 #1 : 기본 생성자
	R2(){ 
		
	}
	R2(int w){
		width = w;
		height = w;
		make();
	}
	
	// 생성자 #2
	R2(int w, int h){ // 생성자 : 리턴 타입이 없고, 클래스 이름과 같음
		width = w;
		height = h;
		make();
	}
	
	void make() {
		area = width * height;
	}
	
	void print() {
		System.out.println("가로 "+ width +", 세로" + height +"인 사각형의 면적은 " + area + "입니다");
	}
}

class C{
	int radius;
	double pi = 3.14;
	double area;
	
	// 기본 생성자
	C(){
		
	}
	
	C(int radius){
		this.radius = radius;
		make();
	}
	
	void make() {
		area = radius * radius * pi;
	}
	void print() {
		System.out.println("반지름이 " + radius + "인 원의 면적은 " + area + "입니다");
	}
}

class Employee{
	String empNo;
	String empName;
	int salary = 0;
	Employee(){
		
	}
	/**
	 * 객체 생성 시 사번과 이름을 초기화한다
	 * @param empNo 사번
	 * @param empName 이름
	 * @param salary 급여
	 */
	Employee(String empNo, String empName){
		this(empNo, empName,0);
	}
	Employee(String empNo, String empName, int salary){
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}
	
	void print() {
		System.out.println("사번:"+ empNo + " ,사원명:" + empName+ ", 기본급:" + salary);
	}
	
}

public class ConstructorTest {

	public static void main(String[] args) {
		R2 r = new R2();
		r.width = 3; // 가로
		r.height = 4; // 세로
		r.make();
		r.print(); // "가로3, 세로 4인 사각형의 면적은 12.0입니다."

		R2 r1 = new R2(5,5);
//		r1.width = 5; // 가로
//		r1.height = 5; // 세로
//		r1.make();
		r1.print(); // "가로3, 세로 4인 사각형의 면적은 25.0입니다."
		
		R2 r2 = new R2(6,7);
//		r2.width = 6; // 가로
//		r2.height = 7; // 세로
//		r2.make();
		r2.print(); // "가로3, 세로 4인 사각형의 면적은 42.0입니다."
		
		C c1 = new C(); // 원 객체를 생성한다
		c1.radius = 5;
		c1.make(); // 원의 면적을 계산한다
		c1.print(); // "반지름이 5인 원의 면적은 xx.xxx입니다" 출력
		
		C c2 = new C(6); // 반지름이 6인 원객체를 생성한다
		c2.print(); // "반지름이 6인 원의 면적은 xx.xxx입니다" 출력
		
		R2 r3 = new R2(8); // 가로8, 세로8인 사각형 객체
		r3.print(); // "가로8, 세로8인 사각형의 면적은 64.0입니다" 출력
		
		Employee e1 = new Employee();
		e1.empNo = "2301";
		e1.empName = "오문정";
		e1.salary = 10000;
		
		Employee e2 = new Employee("2302", "홍길동", 10000);
		Employee e3 = new Employee("2303", "나자바");
		
		e1.print(); // "사번:2301, 사원명:오문정, 기본급:10000"
		e2.print(); // "사번:2302, 사원명:홍길동, 기본급:10000"
		e3.print(); // "사번:2303, 사원명:나자바, 기본급:0"
		
		
	}
}
