package Test10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SizeFrameTest {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(()->{//�¼������̵߳�ִ�д���
			JFrame frame = new SizeFrame();
			frame.setTitle("SizeFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
			frame.setVisible(true);
		});
	}
}

class SizeFrame extends JFrame{
	public SizeFrame() {
		//getScreenSize()��������һ��Dimension�Ķ�����Ļ�Ĵ�С��
		Toolkit kit = Toolkit.getDefaultToolkit();//Toolkit������ܶ��뱾�ش���ϵͳ�򽻵��ķ���
		Dimension screenSize = kit.getScreenSize();
		
		//��Ļ�Ĵ�С
		int screenHeight = screenSize.height;//�߶� /����
		int screenWidth = screenSize.width;//���
		
		setSize(screenWidth/2,screenHeight/2);
        setLocationByPlatform(true);
		//��������
		Image img = new ImageIcon("123.gif").getImage();
		setIconImage(img);
	}
}
