import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.my.product.dto.Product;

public class ObjectIOTest {
	public static void writeTest() {
		/*
		 * a.ser 파일에 객체 쓰기
		 * 목적지 : a.ser 파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : ObjectOutputStream
		 */
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("..\\a.ser"));
			Date dt = new Date(); //implemets Serializable된 클래스라서 직렬화 가능
			oos.writeObject(dt);

			Product p = new Product("C0001", "아메리카노" , 1000); //상품 객체
			oos.writeObject(p);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void readTest() {
		/*
		 * a.ser 파일의 객체 읽기
		 * 자원 : a.ser 파일
		 * 노드스트림 : FileInputStream
		 * 필터스트림 : ObjectInputStream
		 */
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("..\\a.ser"));
			while(true) {
				Object obj = ois.readObject();
				System.out.println(obj); //obj.toString() 자동호출됨
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e){
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		readTest();
//		writeTest();
	}

}
