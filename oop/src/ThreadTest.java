import java.text.SimpleDateFormat;
import java.util.Date;
class Fifth implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("CAPTON PLAY");
		}
	}
}
class Fourth implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("SOUND PLAY");
		}
	}
}
class Third implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("동영상PLAY");
		}
	}
}
class Second implements Runnable {
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		for(int i=0;i<10;i++) {
			System.out.println(sdf.format(new Date()));
			int mills = 1000; //1000분의 1000초 (1ms)
			try {
				Thread.sleep(mills);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class First extends Thread{
	@Override
	public void run() {
		//스레드가 할 일
		String tName = Thread.currentThread().getName();
		for(int i=1;i<=100;i++) {
			System.out.println(tName + ":" + i);
		}
	}
}
public class ThreadTest {
	public static void test() {
		Thread t = Thread.currentThread();
		String tName = t.getName();
		System.out.println("test() 현재 사용중인 스레드이름 : " + tName);
	}
	public static void main(String[] args) {
		First f1 = new First(); //Thread-0
		First f2 = new First(); //Thread-1
		Second s = new Second();
		Thread t1 = new Thread(s);
		//		f1.run();
		f1.start();
		f2.start();
		//		s.start();
		t1.start();

		Thread t = Thread.currentThread();
		String tName = t.getName();
		System.out.println("main() 현재 사용중인 스레드이름 : " + tName);
		test();

		new Thread(new Third()).start();
		new Thread(new Fourth()).start();
		new Thread(new Fifth()).start();
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("익명클래스형태의 스레드");
				}
			}
		} ).start();
		
		new Thread( ()->{
			for(int i=0;i<10;i++) {
				System.out.println("람다식형태의 스레드");
			}
		} ).start();
	}
}
