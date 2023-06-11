package ch14;


class WorkObject {
	public synchronized void methodA() { //동기화 메소드
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " : methodA 작업 실행" );
		notify(); //다른 스레드를 실행 대기 상태(Runnable)로 만듦
		try {
			wait(); //자신의 스레드를 일시 정지 상태로 만듦
		} catch (InterruptedException e) {
		}
	}
	public synchronized void methodB() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + " : methodB 작업 실행" );
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}

class ThreadA extends Thread {
	private WorkObject workObject;
	
	public ThreadA(WorkObject workObject) { //공유 작업 객체를 받음
		setName("ThreadA");
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodA();
		}
	}
}
class ThreadB extends Thread {
	private WorkObject workObject;
	
	public ThreadB(WorkObject workObject) { //공유 작업 객체를 받음
		setName("ThreadB");
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObject.methodB();
		}
	}
}

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject workObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);
		
		threadA.start();
		threadB.start();

	}

}
