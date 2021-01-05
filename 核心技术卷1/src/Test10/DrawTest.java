package Test10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new DrawFrame();
			frame.setTitle("DrawTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class DrawFrame extends JFrame{
	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}
}

class DrawComponent extends JComponent{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX,topY,width,height);
		g2.draw(rect);//传入一个Shape类的对象形参  
		
		//下面这两种方法画椭圆都可以  是矩形的内切椭圆
		Ellipse2D ellipse = new Ellipse2D.Double(leftX,topY,width,height);
//		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		g2.draw(new Line2D.Double(leftX, topY, leftX+width, topY+height));
		
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		//中心点+外接矩形的一个点
		circle.setFrameFromCenter(centerX, centerX, centerX+radius, centerY+radius);
		g2.draw(circle);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH,HEIGHT);
	}
}
