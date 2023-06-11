package ch14;

class PrintThread2 extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("실행 중...");
			if(Thread.interrupted()) { //interrupt() 메소드가 호출되면 while 문을 빠져나감
				break;
			}
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}
public class InterruptExample2 {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		thread.interrupt(); //일시정지 상태를 방해한다
	}

}
