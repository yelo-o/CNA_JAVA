import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		//		String serverIP = "192.168.0.40";
		String serverIP = "127.0.0.1";
		int serverPort = 5432;
		Socket s = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		InputStream is = null;
		DataInputStream dis = null;
		//키보드로 입력하기
		Scanner sc = new Scanner(System.in);

		try {
			s = new Socket(serverIP, serverPort); //직접 소켓 객체 생성
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			is = s.getInputStream();
			dis = new DataInputStream(is);
			String sendMsg;
			do {
				sendMsg  = sc.nextLine();
				dos.writeUTF(sendMsg);
				String recieveMsg = dis.readUTF();
				System.out.println("from 서버 : " + recieveMsg);

			}while(!sendMsg.equals("quit"));

		} catch (ConnectException e) {
			System.out.println("서버를 찾지못했습니다");
		} catch (SocketException e) {
			System.out.println("서버와 연결이 해제되었습니다");
		} catch (EOFException e) {
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
