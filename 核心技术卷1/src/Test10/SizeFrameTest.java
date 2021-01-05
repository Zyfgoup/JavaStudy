package Test10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SizeFrameTest {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(()->{//事件分派线程的执行代码
			JFrame frame = new SizeFrame();
			frame.setTitle("SizeFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
			frame.setVisible(true);
		});
	}
}

class SizeFrame extends JFrame{
	public SizeFrame() {
		//getScreenSize()方法返回一个Dimension的对象（屏幕的大小）
		Toolkit kit = Toolkit.getDefaultToolkit();//Toolkit类包括很多与本地窗口系统打交道的方法
		Dimension screenSize = kit.getScreenSize();
		
		//屏幕的大小
		int screenHeight = screenSize.height;//高度 /长度
		int screenWidth = screenSize.width;//宽度
		
		setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
		//？？？？
		Image img = new ImageIcon("123.gif").getImage();
		setIconImage(img);
	}
}
