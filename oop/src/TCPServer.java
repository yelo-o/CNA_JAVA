import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		int port = 5432; //1521;//65536;
		InputStream is = null;
		DataInputStream dis = null;
		try {
			ss = new ServerSocket(port); //포트 열기
			Socket s = null;
			while(true) {
				s = ss.accept(); //클라이언트의 접속을 기다린다
				InetAddress clientIP = s.getInetAddress();
				String clientAddress = clientIP.getHostAddress();
				System.out.println("클라이언트 "+ clientAddress + " 가 접속했습니다");
				is = s.getInputStream();
				//			System.out.println((char)is.read());
				//			byte[] bArr = new byte[100];
				//			int readByteSize = is.read(bArr);
				//			String receiveMsg = new String(bArr, 0, readByteSize);
				dis = new DataInputStream(is);
				String receiveMsg;
//			do {
//				receiveMsg = dis.readUTF();
//				System.out.println("클라이언트 " + clientAddress + ">" + receiveMsg);
//			}while(!receiveMsg.equals("quit"));
				while(true) {
					receiveMsg = dis.readUTF();
					if(receiveMsg.equals("quit")) {
						break;
					}
					System.out.println("클라이언트 " + clientAddress + ">" + receiveMsg);
				}
			}
			
		} catch (IllegalArgumentException e) { //런타임에러이기 때문에 컴파일러가 체크못함
			System.out.println(port + " 포트가 틀렸어요");
		} catch (BindException e) {
			System.out.println(port + " 포트는 이미 사용중입니다");
		} catch (SocketException e) {
			System.out.println("클라이언트와의 연결이 해제되었습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TCPSERVER END");
	}

}
