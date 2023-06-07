import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOTest {

	public static void main(String[] args) {
		/*
		 * a.txt 파일을 바이트 단위로 읽기
		 * 자원 : a.txt 파일
		 * 노드스트림 : FileInputStream
		 */
		FileInputStream fis;
		try {
			//			fis = new FileInputStream(".\\resource\\a.txt"); //oop - resource - a.txt
			fis = new FileInputStream("..\\aunicode.txt"); //CNA_JAVA - a.txt
//			while(true) {
//				int readValue = fis.read();
//				if(readValue == -1) {
//					break;
//				}
			int readValue = -1;
			while((readValue = fis.read()) != -1) {
				System.out.println(readValue + " : " + (char)readValue);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
