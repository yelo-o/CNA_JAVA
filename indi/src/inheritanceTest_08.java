class Person {
	String name;
	Person(String name){
		this.name = name;
	}
	void walk() {
		System.out.println("걷습니다");
	}
}
class Student extends Person {
	int studentNo;
	Student(String name, int studentNo){
		super(name);
		this.studentNo = studentNo;
	}
	void study() {
		System.out.println("공부를 합니다");
	}
}
public class inheritanceTest_08 {
	public static void personInfo(Person person) {
		System.out.println("name : " + person.name);
		person.walk();
		if(person instanceof Student) {
			//Student 타입일 경우 강제 타입 변환
			Student student = (Student) person;
			System.out.println("studentNo : " + student.studentNo);
			student.study();
		}
	}
	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		personInfo(p1);
		System.out.println();
		Person p2 = new Student("김길동", 10);
		personInfo(p2);
	}
}
