class Share{
	int balance;
	public void push() { //100번 반복 - balance 1씩 증가
		for(int i=0;i<100;i++) {
			synchronized(this) {
				this.notify(); //현재 공유객체를 사용하는 wait된 스레드를 깨운다
				System.out.print("before push : " + balance);
				this.balance++;
				System.out.println(", after push : " + balance);
			}
		}
	}

	public void pop() { //100번 반복 - balance 1씩 감소
		for(int i=0;i<100;i++) {
			synchronized(this) {
				if(balance ==0) { //Pop thread가 cpu를 점유중일 때, balance가 0이면 this.wait()하도록 한다
					try {
						this.wait(); //현재 공유객체를 사용하는 스레드를 일시중지한다
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("before pop : " + balance);
				this.balance--;
				System.out.println(", after pop : " + balance);
			}
		}
	}
}

class Push extends Thread {
	Share s;
	Push(Share s){
		this.s = s;
	}
	//스레드가 할일
	@Override
	public void run() {
		s.push();
	}
}
class Pop extends Thread {
	Share s;
	Pop(Share s){
		this.s = s;
	}
	//스레드가 할일
	@Override
	public void run() {
		s.pop();
	}
}

public class ShareTest {

	public static void main(String[] args) {
		Share s = new Share();
		Push ps = new Push(s);
		Pop po = new Pop(s);

		ps.start();
		po.start();
	}
}
