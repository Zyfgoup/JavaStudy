package Test10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NotHelloWorld {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(()->{
			JFrame frame=new NotHelloWorldFrame();
			frame.setTitle("NotHelloWorld");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class NotHelloWorldFrame extends JFrame{
	public NotHelloWorldFrame() {
		add(new NotHelloWorldComponent());
		pack();
	}
}

	
	class NotHelloWorldComponent extends JComponent{
		
		public static final int X = 75;
		public static final int Y = 100;
		
		private static final int WIDTH = 300;
		private static final int HEIGHT = 200;
		
		
		//�Զ����ø÷���
		public void paintComponent(Graphics g) {
			g.drawString("Not a Hello,World program", X, Y);
			
		}
		//Ӧ��Ҳ���Զ����� ���صĿ����pack�������Ӧ
		//���û��������� pack()��ֻ��һ����С�Ĵ���ʲôҲ�������ġ�
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH,HEIGHT);
		}
		
	}

