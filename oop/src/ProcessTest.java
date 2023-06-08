import java.io.IOException;
import java.io.InputStream;

public class ProcessTest {

	public static void main(String[] args) {
		Process p;
		Runtime r = Runtime.getRuntime();
		String cmd = "cmd"; //명령프롬프트용 앱
		InputStream is = null;
		try {
			p = r.exec(cmd); //프로세스 생성
			
			is = p.getInputStream();
			int readValue = -1;
			while((readValue = is.read()) != -1) {
				System.out.print((char)readValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
