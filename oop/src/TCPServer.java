import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		int port = 5432; //1521;//65536;
		InputStream is = null;
		DataInputStream dis = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		try {
			ss = new ServerSocket(port); //포트 열기
			Socket s = null;
			while(true) {
				String clientAddress = "";
				try {
					s = ss.accept(); //클라이언트의 접속을 기다린다
					InetAddress clientIP = s.getInetAddress();
					clientAddress = clientIP.getHostAddress();
					System.out.println("클라이언트 "+ clientAddress + " 가 접속했습니다");
					is = s.getInputStream();
					dis = new DataInputStream(is);
					
					os = s.getOutputStream();
					dos = new DataOutputStream(os);
					String receiveMsg;
					while(true) {
						receiveMsg = dis.readUTF();
						if(receiveMsg.equals("quit")) {
							break;
						}
						System.out.println("클라이언트 " + clientAddress + ">" + receiveMsg);
						String sendMsg = receiveMsg;
						dos.writeUTF(sendMsg);
					}
				} catch (SocketException e) {
					System.out.println("클라이언트와의 연결이 해제되었습니다");
				} catch (IOException e) {
				} finally { //한 클라이언트와의 일을 끝낸다
					System.out.println("클라이언트" + clientAddress + "접속해제");
					if(s != null) {
						try {
							s.close();
						} catch (IOException e) {
						}
					}
				}
			}
			} catch (IllegalArgumentException e) { //런타임에러이기 때문에 컴파일러가 체크못함
				System.out.println(port + " 포트가 틀렸어요");
			} catch (BindException e) {
				System.out.println(port + " 포트는 이미 사용중입니다");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("TCPSERVER END");
		}
	}
