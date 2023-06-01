import java.util.ArrayList;
import java.util.Date;
/**
 * 코드의 안정성을 위해
 * @author flyordig
 *
 */
public class GenericTest {

	public static void main(String[] args) {
		ArrayList<String> list; //String값만 저장가능하다는 뜻
		list = new ArrayList<>();
		
		list.add("one");
		list.add("two");
		list.add("three");
//		list.add(new Date()); //Generic으로 생성했으므로 String값만 넣을 수 있음
		
		String str1 = list.get(0);
//		Date dt1 = list.get(0);

	}

}
