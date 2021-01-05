package Test12;

import javax.swing.JFrame;

public class TestCaculator  {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		CaculatorPanel c = new CaculatorPanel();
		frame.add(c);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
