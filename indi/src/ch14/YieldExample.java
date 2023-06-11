package ch14;

class WorkThread extends Thread{
	public boolean work = true;
	public WorkThread(String name) {
		setName(name);
	}
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName() + " : 작업처리");
			}else {
				Thread.yield();
			}
		}
	}
}

public class YieldExample {
	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("workThreadA"); 
		WorkThread workThreadB = new WorkThread("workThreadB"); 
		
		workThreadA.start();
		workThreadB.start();

		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
		}
		workThreadA.work = false; //workThreadB에게 양보
		
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
		}
		workThreadA.work = true; // 양보 취하
		
	}

}
