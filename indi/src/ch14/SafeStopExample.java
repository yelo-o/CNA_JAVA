package ch14;

class PrintThread0 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	@Override
	public void run() {
		while(!stop) {
			System.out.println("실행 중");
		}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}
	
}

public class SafeStopExample {

	public static void main(String[] args) {
		PrintThread0 printThread = new PrintThread0(); 
		printThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		printThread.setStop(true);

	}

}
