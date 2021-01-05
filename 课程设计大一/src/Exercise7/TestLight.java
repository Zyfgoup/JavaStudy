package Exercise7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestLight extends JPanel implements ActionListener{
	JRadioButton green;
	JRadioButton yellow;
	JRadioButton red;
	JPanel panel;
	boolean colorgreenlight;
	boolean coloryellowlight;
	boolean colorredlight;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == green) {
			yellow.setSelected(false);
			red.setSelected(false);
			colorgreenlight = true;
		}else if(obj == yellow) {
			green.setSelected(false);
			red.setSelected(false);
			coloryellowlight = true;
		}else {
			green.setSelected(false);
			yellow.setSelected(false);
			colorredlight = true;
		}
		repaint();
	}
	 
	public void paintComponent(Graphics gr) {
		gr.setColor(Color.white);
		gr.fillRect(0, 0, this.getWidth(),this.getHeight());
		
		gr.setColor(Color.BLACK);
		gr.drawRect(180, 100, 90, 270);
		gr.drawOval(190, 115, 70, 70);
		gr.drawOval(190, 200, 70, 70);
		gr.drawOval(190, 280, 70, 70);
		
		if(colorgreenlight) {
			colorgreenlight = false;
			gr.setColor(Color.green);
			gr.fillOval(190, 115, 70, 70);
		}
		if(coloryellowlight) {
			coloryellowlight = false;
			gr.setColor(Color.YELLOW);
			gr.fillOval(190, 200, 70, 70);
		}
		if(colorredlight){
			colorredlight = false;
			gr.setColor(Color.red);
			gr.fillOval(190, 280, 70, 70);
		}
	}
	
	public TestLight() {
		green = new JRadioButton("ÂÌµÆ");
		yellow = new JRadioButton("»ÆµÆ");
		red = new JRadioButton("ºìµÆ");
		green.addActionListener(this);
		yellow.addActionListener(this);
		red.addActionListener(this);
		panel = new JPanel();
		panel.add(green);
		panel.add(yellow);
		panel.add(red);
		JFrame frame = new JFrame("ºìÂÌµÆ");
		frame.add(this);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		TestLight tl = new TestLight();
	}
}
