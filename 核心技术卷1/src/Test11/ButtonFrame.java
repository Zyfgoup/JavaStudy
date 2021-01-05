package Test11;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame{
	private JPanel buttonPanel;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;
	
	public ButtonFrame() {
		
		setSize(WIDTH,HEIGHT);
		
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("blue");
		JButton redButton = new JButton("red");
		
		buttonPanel = new JPanel();//创建面板的对象
		
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		add(buttonPanel);
		
		
		ColorAction yellowAction = new ColorAction(Color.yellow);
		ColorAction blueAction = new ColorAction(Color.blue);
		ColorAction redAction = new ColorAction(Color.red);
		
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	private class ColorAction implements ActionListener{
		private Color backgroundColor;
		
		public ColorAction(Color c) {
			this.backgroundColor=c;
		}
		
		public void actionPerformed(ActionEvent event) {
			buttonPanel.setBackground(backgroundColor);//面板颜色改变
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new ButtonFrame();
		frame.setTitle("ButtonFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}


