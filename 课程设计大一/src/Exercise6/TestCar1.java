package Exercise6;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


public class TestCar1 extends Applet {
	JButton button1= new JButton("��ʼ�˶�");
	JButton button2= new JButton("����");
	JButton button3= new JButton("����");
	JButton button4= new JButton("ֹͣ");
	JPanel panel = new JPanel();
	
	
	int i;//���Ƴ����ٶ�
	int x1 = 15;//�����ӵ�Xֵ
	int x2 = 0;//�����xֵ
	int x3[] = {35,20,90,75,35};//���ζ����Xֵ
	int y1[] = {520,545,545,520,520};//���ζ����Yֵ
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
		
		//��ĩ������,���ܻ������ �����ҵ�������ȶ���εĶ�������һ
		g.setColor(Color.green);
		g.fillPolygon(x3,y1,5);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
}
