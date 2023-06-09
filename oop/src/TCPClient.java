import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
//		String serverIP = "192.168.0.40";
		String serverIP = "127.0.0.1";
		int serverPort = 5433;
		Socket s = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			s = new Socket(serverIP, serverPort); //직접 소켓 객체 생성
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
			String sendMsg = "안녕하세요. 김민규입니다";
//			os.write(sendMsg.getBytes("UTF-8"));
			os.write(sendMsg.getBytes());
//			os.write(65);
		} catch (ConnectException e) {
			System.out.println("서버를 찾지못했습니다");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
