import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		// Student를 저장하는 HashSet 생성
		HashSet<Student> hashSet = new HashSet<>();

		// Student 저장
		hashSet.add(new Student("1"));
		hashSet.add(new Student("1")); //같은 학번이므로 중복 저장이 안됨
		hashSet.add(new Student("2"));

		// 저장된 Student 수 출력
		System.out.println("저장된 Student 수 : " + hashSet.size());
	}
}

class Student {
	private String studentNum;

	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}
	// 여기에 코드를 작성하세요.
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			if(studentNum.equals(student.getStudentNum())) {
				return true;
			}
		}
		return false;
	}
}