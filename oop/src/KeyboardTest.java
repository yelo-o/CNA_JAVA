import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

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
		Scanner sc = null;
		try {
			int readValue = is.read();
			int readValue2 = is.read();
			int readValue3 = is.read();
			int readValue4 = is.read();
			int readValue5 = is.read();
			ir = new InputStreamReader(is);
//			int readValue = ir.read();
			System.out.println("입력된 값 : " + readValue + readValue2 + readValue3 + readValue4 + readValue5);
		} catch (IOException e) {
			e.printStackTrace();
		}
//			sc = new Scanner(is);
////			String readLine = sc.nextLine();
////			System.out.println("입력된 값 : " + readLine);
//			String read = sc.next();
//			int i = sc.nextInt();
//			System.out.println();
			
	}
}
