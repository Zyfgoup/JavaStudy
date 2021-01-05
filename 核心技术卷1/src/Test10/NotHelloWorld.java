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
		
		
		//自动调用该方法
		public void paintComponent(Graphics g) {
			g.drawString("Not a Hello,World program", X, Y);
			
		}
		//应该也是自动调用 返回的宽高与pack（）相对应
		//如果没有这个方法 pack()后只有一个最小的窗口什么也看不见的。
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH,HEIGHT);
		}
		
	}

