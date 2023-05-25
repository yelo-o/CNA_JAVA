import com.my.dto.Person;
import com.my.student.dto.Student;
class Parent{
	int a;
	void p() {
		System.out.println(a);
	}
}
class Child extends Parent{
	String a;
	Child(){
		super(); // 현재 객체의 부모 영역생성자 호출한다
	}
	void c() {
		System.out.println("현재객체의 a="+ this.a + ", 현재 객체의 부모의 a=" + super.a );
	}
}
class Child2 extends Child{
	boolean a;
	void c2() {
		System.out.println(a + ", " + super.a); // false, null
		c(); // null, 0
	}
}
public class InheritanceTest {
	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.a); //0
		System.out.println("==================");
		
		Child c = new Child();
		System.out.println(c.a); //null
		
		c.a = "hello";
		
		parent.p(); //0
		c.c(); //hello
		c.p(); //0
		
		Person p;
		p = new Person();
		Student s;
		s = new Student();
		p.setName("사람");
		s.setName("학생");
		s.setNo("학번");
	}
}
