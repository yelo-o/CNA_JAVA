import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("클래스 이름을 입력하세요. ex)java.util.Date");
		String className = sc.nextLine();
		try {
			Class<?> clazz = Class.forName(className); //RuntimeDynamicLoad //<?> : 어떤 자료형이 와도 상관없다는 뜻
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m:methods) {
				System.out.println(m.getName());
			}

			//			clazz.newInstance()
			try {
				Constructor constructor = clazz.getConstructor();
				try {
					Object obj = constructor.newInstance();
					System.out.println(obj); //obj.toString()가 자동호출됨
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
