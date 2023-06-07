import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest {

	public static void main(String[] args) {
		/*
		 * a.txt 파일을 문자 단위로 읽기
		 * 자원 : a.txt 파일
		 * 노드스트림 : FileReader
		 */
		FileInputStream fis;
		FileReader fr = null; //fr.close() 하려면 값을 null 값으로 초기화해줘야 함
		try {
//			fis = new FileInputStream(".\\resource\\a.txt"); //oop - resource - a.txt
//			fis = new FileInputStream("..\\aunicode.txt"); //CNA_JAVA - a.txt
			fr = new FileReader("..\\a.txt");
//			while(true) {
//				int readValue = fis.read();
//				if(readValue == -1) {
//					break;
//				}
			int readValue = -1;
			while((readValue = fr.read()) != -1) {
				System.out.println(readValue + " : " + (char)readValue);
			}
//			fr.close(); //자원과의 연결을 끊음
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fr != null) {
				try {
					fr.close(); //자원과의 연결을 끊음
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}