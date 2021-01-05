package Exercise5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestFan extends JPanel implements ActionListener{
	int a=-15;//用来画扇形所需的角度变化
	int i;//用来设置Timer构造器中的delay值
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JPanel panel;
	Timer timer;
	
	public TestFan() {
		button1 = new JButton("一档");
		button2 = new JButton("二档");
		button3 = new JButton("三档");
		button4 = new JButton("关闭");
		button1.addActionListener(new buttonListener());
		button2.addActionListener(new buttonListener());
		button3.addActionListener(new buttonListener());
		button4.addActionListener(new buttonListener());
		panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		JFrame frame = new JFrame("风扇转动");
		frame.add(this);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		timer = new Timer(i,this);
	}
	
		//画出风扇形状
	public void paintComponent(Graphics g) {
		//每次重画的时候先画一个填充了白色的矩形，大小跟JFrame设置的大小一样
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);
		g.drawOval(120, 100, 250, 250);
		
		a=a+5;
		//x - 要填充弧的左上角的 x 坐标。y - 要填充弧的左上角的 y 坐标。width - 要填充弧的宽度。
		//height - 要填充弧的高度。startAngle - 开始角度。arcAngle - 相对于开始角度而言，弧跨越的角度。
		//0 度角位于 3 点钟位置。正值指示逆时针旋转，负值指示顺时针旋转。
		g.setColor(Color.blue);
		g.fillArc(120, 100, 250, 250, a, -30);
		g.setColor(Color.black);
		g.fillArc(120, 100, 250, 250, a+60, -30);
		g.setColor(Color.red);
		g.fillArc(120, 100, 250, 250, a+120, -30);
		g.setColor(Color.orange);
		g.fillArc(120, 100, 250, 250, a+180, -30);
		g.setColor(Color.green);
		g.fillArc(120, 100, 250, 250, a+240, -30);
		g.setColor(Color.pink);
		g.fillArc(120, 100, 250, 250, a+300, -30);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public static void main(String[] args) {
		TestFan tf = new TestFan();
	}
	
	private class buttonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==button1) {
				timer.setDelay(50);// 这个setDelay()就是在运行中可以设置delay的值了
				timer.start();
			}else if(obj == button2) {
				timer.setDelay(25);
				timer.start();//如果不加这句语句，当点击关闭按钮时，再点击二档或者三档的按钮则不会转动了
			}else if(obj == button3) {
				timer.setDelay(15);
				timer.start();
			}else {
				timer.stop();
			}
		}
	}
}

