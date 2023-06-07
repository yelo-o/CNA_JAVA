import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void writeTest() {
		/*
		 * a.dat 파일에 자료형별 쓰기
		 * 목적지 : a.dat파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("..\\a.dat", true)); //a.dat 파일 만들기
			dos.writeBoolean(false); //1byte
			dos.writeInt(99); //4byte
			dos.writeDouble(123.4); //8byte
			dos.writeUTF("가나"); //6byte
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dos !=null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void readTest() {
		/*
		 * a.dat 파일을 자료형별로 읽기
		 * 자원 : a.dat 파일
		 * 노드스트림 : FileInputStream
		 * 필터스트림 : DataInputStream
		 */
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("..\\a.dat"));
			// 데이터 타입별로 읽기
			while(true) {
				boolean flag = dis.readBoolean();
				int i = dis.readInt();
				double d = dis.readDouble();
				String utf = dis.readUTF();
				System.out.println(flag + ":" + i +":" + d + ":" + utf);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (EOFException e) {
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		writeTest();
		readTest();
	}
}
