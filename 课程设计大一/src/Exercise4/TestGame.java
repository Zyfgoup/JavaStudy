package Exercise4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGame{
	public TestGame() {
		JFrame frame = new JFrame("井字游戏");
		frame.setLayout(new GridLayout(3,3,20,20));//网格三行三列的布局方式
		
		//用for循环为往框架里面添加九个面板
		for(int i=0;i<9;i++) {
			frame.add(new Game());
		}
		
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		TestGame tg = new TestGame();
	}
}
//Game类继承JPanel类来判断画什么图形
class Game extends JPanel{
	public void paintComponent(Graphics g) {
			int n = (int)(Math.random()*3);
			if(n == 0) {
				g.drawLine(0, 0, this.getWidth(), this.getHeight());
				g.drawLine(this.getWidth(), 0, 0, this.getHeight());
			}else if(n ==1) {
				g.setColor(Color.green);
				g.drawOval(0, 0, this.getWidth(), this.getHeight());
			}else {
				g.setColor(Color.gray);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
			}
		}
}

