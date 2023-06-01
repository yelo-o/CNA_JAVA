import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class JCFTest {

	public static void m(Collection c) {
		c.add("one");
		c.add(c);
		c.add(true);
		c.add(new String("one"));
		c.add(4.0F);
		
		System.out.println("자료수 : " + c.size());
		System.out.println(c); //c.toString() 자동호출됨 
//		System.out.println("======================================");
		
		//방법 1 (while문)
//		Iterator it = c.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		//방법 2 (향상된 for문)
//		for(Object o : c) {
//			System.out.println(o);
//		}
		//방법 3 (forEach 사용)
		Stream st = c.stream();
		st.forEach(System.out::println);
		
		
	}
	// m 메서드 오버로드 
	public static void m(Map m) {
		m.put("one", "first");
		m.put(2, "second");
		m.put(true, "third");
		m.put(new String("one"), "fourth");
		m.put(4.0F, "fifth");
		System.out.println("자료수 : " + m.size());
		System.out.println(m);
		
		Object value = m.get("one"); //one이라는 키와 매칭되는 값을 value 변수에 저장
		System.out.println("key : one, value : " + value);
		
		java.util.Date d = (java.util.Date) value;
		
		// 방법1 (while문)
//		Set keys = m.keySet();
//		Iterator it = keys.iterator();
//		while(it.hasNext()) {
//			Object key = it.next(); //키를 하나하나 얻는 과정 
//			Object value2 = m.get(key);
//			System.out.println("key : " + key + " value : " + value2);
//		}
		
		// 방법2 (향상된 for문)
//		for(Object key:m.keySet()) {
//			Object value2 = m.get(key);
//			System.out.println("key : " + key + " value : " + value2);
//		}
		
		// 방법3 (forEach 메소드)
		m.keySet().stream().forEach(key->System.out.println("key:" + key+",value:" + m.get(key)));
	}
	
	
	public static void main(String[] args) {
		
		Collection c;
//		c = new Collection();
		System.out.println("ArrayList 객체");
		c = new ArrayList();
		m(c);
		
		System.out.println();
		System.out.println("HashSet 객체");
		c = new HashSet();
		m(c);
		
		System.out.println();
		System.out.println("HashMap 객체");
		Map m;
		m = new HashMap();
		m(m);
	}

}
