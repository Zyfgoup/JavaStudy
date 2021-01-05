package Exercise3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPieChart extends JPanel{
	public TestPieChart() {
		JFrame frame = new JFrame("饼状图"); 
		frame.add(this);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		TestPieChart tpc = new TestPieChart();
	}
	
	public void paintComponent(Graphics g) {
		int x = this.getWidth()/4;
		int y = this.getHeight()/4;
		int width = this.getWidth()/2;
		int height = this.getHeight()/2;

		g.setColor(Color.white);
		g.fillArc(x, y, width, height, 0, -144);
	
		g.setColor(Color.red);
		g.fillArc(x, y, width, height, -144, -108);
		
		g.setColor(Color.yellow);
		g.fillArc(x, y, width, height, -252, -36);
		
		g.setColor(Color.pink);
		g.fillArc(x, y, width, height, -288, -72);
		
		g.setColor(Color.black);
		g.drawOval(x, y, width, height);
		g.setFont(new Font("宋体",Font.BOLD+Font.ITALIC,18));
		g.drawString("期末成绩 -- 40%", x*2, y*3);
		g.drawString("期中考试 -- 30%", x/2, y*2);
		g.drawString("平时测验 -- 10%", x*2,y);
		g.drawString("作业 -- 20%", (int)(x*2.8),(int)(y*1.5));
		
	}
}
