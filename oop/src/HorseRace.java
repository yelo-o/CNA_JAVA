import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Horse extends Canvas implements Runnable{
	private int x;
	private int y;
	private String name;
	Horse(String name){
		x = 50;
		y = 10;
		this.name = name;
	}
	@Override
	public void paint(Graphics g) {
		g.drawString(name, x, y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i =0 ; i<10;i++) {
			x += 5;
			this.repaint();
			long mills = (long)(Math.random()*1000 +1);
			try {
				Thread.sleep(mills);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
public class HorseRace {
	private JFrame f;
	private JButton btStart, btReady;
	private Horse[] horses;
	public HorseRace() {
		f = new JFrame("달리기");
		btStart = new JButton("달려");
		btReady = new JButton("준비");
		horses = new Horse[3];
		String []names = {"하이그랜드", "해운대갈매기", "온포인트"};

		Container c = f.getContentPane(); //프레임 뒷판
		c.setLayout(new GridLayout(4, 1)); //4행 1열
		for(int i=0; i<names.length; i++) {
			Horse h = horses[i];
			h = new Horse(names[i]);
			horses[i] = new Horse(names[i]);
			c.add(horses[i]); //Horse의 paint()가 자동호출됨
		}
		Panel  panel = new Panel();
		panel.add(btReady);
		panel.add(btStart);
		c.add(panel);

		btReady.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Horse h : horses) {
					h.setX(0);
					h.repaint();
				}
			}
		});
		btStart.addActionListener((e) -> { 
			for(Horse h:horses) {
//				h.setX(h.getX() + 10);
//				h.repaint();
				new Thread(h).start();
			}
		});


		f.setSize(500, 300);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new HorseRace();

	}

}
