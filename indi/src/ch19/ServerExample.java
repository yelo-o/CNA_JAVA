package ch19;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("----------------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하고 Enter키를 입력하세요");
		System.out.println("----------------------");

		//TCP 서버시작
		startServer();

		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			if(key.toLowerCase().equals("q")) {
				//TCP 서버 종료
				stopServer();
				break;
			}
		}
		scanner.close();

	}

	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					while(true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");

						//연결수락
						Socket socket = serverSocket.accept();

						//연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();

						System.out.println("[서버]"+isa.getHostName()+"의 연결 요청을 수락함");

						//연결끊기
						socket.close();
						System.out.println("[서버]"+isa.getHostName()+"의 연결을 끊음");
					}
				}catch(IOException e) {
					//System.out.println("Socket Closed");
					System.out.println("[서버] " + e.toString());
					e.printStackTrace();
				}
			}
		};

		//스레드 시작
		thread.start();
	}
	public static void stopServer() {
		try {
			//ServerSocekt을 닫고 Port 언바이딩
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		}catch (IOException e1) {
		}
	}
}
