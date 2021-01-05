package Exercise6;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


public class TestCar1 extends Applet {
	JButton button1= new JButton("开始运动");
	JButton button2= new JButton("加速");
	JButton button3= new JButton("减速");
	JButton button4= new JButton("停止");
	JPanel panel = new JPanel();
	
	
	int i;//控制车的速度
	int x1 = 15;//车轮子的X值
	int x2 = 0;//车身的x值
	int x3[] = {35,20,90,75,35};//梯形顶点的X值
	int y1[] = {520,545,545,520,520};//梯形顶点的Y值
	public void init() {
//		button1.addActionListener(new buttonListener());
//		button2.addActionListener(new buttonListener());
//		button3.addActionListener(new buttonListener());
//		button4.addActionListener(new buttonListener());
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		add(panel);
		setSize(1000,600);
	}
	public void paint(Graphics g) {
		
		x1=x1+2;
		x2=x2+2;
		for(int i=0;i<x3.length;i++) {
			x3[i] = x3[i]+2;
		}
		
		g.setColor(Color.BLACK);
		g.fillOval(x1, 575, 25, 25); 
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
}
