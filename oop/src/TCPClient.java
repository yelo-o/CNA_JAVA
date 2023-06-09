import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
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
		//키보드로 입력하기
		Scanner sc = new Scanner(System.in);
		
		try {
			s = new Socket(serverIP, serverPort); //직접 소켓 객체 생성
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
//			String sendMsg = "안녕하세요. 김민규입니다";
//			os.write(sendMsg.getBytes("UTF-8"));
//			os.writeUTF(sendMsg);
//			os.write(65);
			
			//키보드로 quit 문자열까지 서버로 send 반복한다
			String sendMsg;
			do {
				sendMsg  = sc.nextLine();
				dos.writeUTF(sendMsg);
			}while(!sendMsg.equals("quit"));
			
		} catch (ConnectException e) {
			System.out.println("서버를 찾지못했습니다");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
