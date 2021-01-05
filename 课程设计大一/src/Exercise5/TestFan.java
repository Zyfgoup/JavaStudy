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
	int a=-15;//��������������ĽǶȱ仯
	int i;//��������Timer�������е�delayֵ
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JPanel panel;
	Timer timer;
	
	public TestFan() {
		button1 = new JButton("һ��");
		button2 = new JButton("����");
		button3 = new JButton("����");
		button4 = new JButton("�ر�");
		button1.addActionListener(new buttonListener());
		button2.addActionListener(new buttonListener());
		button3.addActionListener(new buttonListener());
		button4.addActionListener(new buttonListener());
		panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		JFrame frame = new JFrame("����ת��");
		frame.add(this);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		timer = new Timer(i,this);
	}
	
		//����������״
	public void paintComponent(Graphics g) {
		//ÿ���ػ���ʱ���Ȼ�һ������˰�ɫ�ľ��Σ���С��JFrame���õĴ�Сһ��
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);
		g.drawOval(120, 100, 250, 250);
		
		a=a+5;
		//x - Ҫ��仡�����Ͻǵ� x ���ꡣy - Ҫ��仡�����Ͻǵ� y ���ꡣwidth - Ҫ��仡�Ŀ�ȡ�
		//height - Ҫ��仡�ĸ߶ȡ�startAngle - ��ʼ�Ƕȡ�arcAngle - ����ڿ�ʼ�Ƕȶ��ԣ�����Խ�ĽǶȡ�
		//0 �Ƚ�λ�� 3 ����λ�á���ֵָʾ��ʱ����ת����ֵָʾ˳ʱ����ת��
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
				timer.setDelay(50);// ���setDelay()�����������п�������delay��ֵ��
				timer.start();
			}else if(obj == button2) {
				timer.setDelay(25);
				timer.start();//������������䣬������رհ�ťʱ���ٵ���������������İ�ť�򲻻�ת����
			}else if(obj == button3) {
				timer.setDelay(15);
				timer.start();
			}else {
				timer.stop();
			}
		}
	}
}

