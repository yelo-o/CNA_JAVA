package ch14;

class PrintThread extends Thread {
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("실행 중...");
				Thread.sleep(1); //일시정지상태로 만들어 interrupt로 인한 예외발생
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
}
public class InterruptExample {

	public static void main(String[] args) {
		Thread thread = new PrintThread();
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		thread.interrupt(); //일시정지 상태를 방해한다
	}

}
