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
	int i;//���Ƴ����ٶ�
	int x1 = 15;//�����ӵ�Xֵ
	int x2 = 0;//�����xֵ
	int x3[] = {35,20,90,75,35};//���ζ����Xֵ
	int y1[] = {520,545,545,520,520};//���ζ����Yֵ
	//һЩ���в�ͬЧ���İ�ť
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JPanel panel;
	Timer timer;

	public TestCar() {
		panel = new JPanel();
		button1 = new JButton("��ʼ�˶�");
		button2 = new JButton("����");
		button3 = new JButton("����");
		button4 = new JButton("ֹͣ");
		button1.addActionListener(new buttonListener());
		button2.addActionListener(new buttonListener());
		button3.addActionListener(new buttonListener());
		button4.addActionListener(new buttonListener());
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		JFrame frame = new JFrame("С���˶�");
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
		g.fillOval(x1, 575, 25, 25); //xy��������Բ��Ӿ��ε����ϽǵĶ���λ��
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
