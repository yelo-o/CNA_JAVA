package ch14;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();

				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch(Exception e) {
					}
				}
			}
		});
		
		thread.start();
		// make Toolkit instance


		for(int i=0; i<5; i++) {
			System.out.println("Thing");
			try {
				Thread.sleep(500);
			} catch(Exception e) {
			}
		}

	}

}
