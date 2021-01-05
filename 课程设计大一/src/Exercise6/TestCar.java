package Exercise6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class TestCar extends JPanel implements ActionListener{
	int i;//控制车的速度
	int x1 = 15;//车轮子的X值
	int x2 = 0;//车身的x值
	int x3[] = {35,20,90,75,35};//梯形顶点的X值
	int y1[] = {520,545,545,520,520};//梯形顶点的Y值
	//一些能有不同效果的按钮
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JPanel panel;
	Timer timer;

	public TestCar() {
		panel = new JPanel();
		button1 = new JButton("开始运动");
		button2 = new JButton("加速");
		button3 = new JButton("减速");
		button4 = new JButton("停止");
		button1.addActionListener(new buttonListener());
		button2.addActionListener(new buttonListener());
		button3.addActionListener(new buttonListener());
		button4.addActionListener(new buttonListener());
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		JFrame frame = new JFrame("小车运动");
		frame.setSize(1000,685);
		frame.add(panel,BorderLayout.NORTH);
		frame.add(this);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		timer = new Timer(i,this);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		x1=x1+2;
		x2=x2+2;
		for(int i=0;i<x3.length;i++) {
			x3[i] = x3[i]+2;
		}
		
		g.setColor(Color.BLACK);
		g.fillOval(x1, 575, 25, 25); //xy的坐标是圆外接矩形的左上角的顶点位置
		g.fillOval(x1+50, 575, 25, 25);
		
		g.setColor(Color.ORANGE);
		g.fillRect(x2, 545, 110,30);
		
		//首末点相重,才能画多边形 ，并且点的总数比多边形的顶点数多一
		g.setColor(Color.green);
		g.fillPolygon(x3,y1,5);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	public static void main(String[] args) {
		TestCar tc = new TestCar();
	}
	
	private class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==button1) {
				timer.setDelay(50);
				timer.start();
			}else if(obj == button2) {
				timer.setDelay(15);
			}else if(obj == button3) {
				timer.setDelay(65);
			}else {
				timer.stop();
			}
		}
	}
}
