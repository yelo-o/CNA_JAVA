import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardTest {

	public static void main(String[] args) {

		/*
		 * 키보드자원으로부터 한문자씩 입력받기
		 * 자원 : 키보드
		 * 노드스트림 : System.in
		 * 필터스트림 : InputStreamReader
		 */
		InputStream is = System.in;
		InputStreamReader ir = null;
		try {
//			int readValue = is.read();
			ir = new InputStreamReader(is);
			int readValue = ir.read();
			System.out.println("입력된 값 : " + readValue + ", 문자값 : " + (char)readValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
