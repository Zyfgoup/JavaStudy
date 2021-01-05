package 寒假练习;

import java.security.Principal;

//（1）定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个findArea()方法返回圆的面积。
//（2）定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：
//		public void printAreas(Cirlce c, int time)
//在printAreas方法中打印输出1到time之间的每个整数半径值，以及对应的面积。例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
//在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示。
class Circle {
	double radius;
	
	public double findArea() {
		return Math.PI*radius*radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double r) {
		radius=r;
	}
}
public class PassObject {
	public void printArea(Circle1 c,int time) {
		System.out.println("radius"+"\t\t"+"area");
		int i=1;
		while(i<=time) {
			c.setRadius(i);
			System.out.println(c.getRadius()+"\t\t"+c.findArea());
			i++;
		}
		c.setRadius(i);
	}
	public static void main(String[] args) {
		Circle1 c=new Circle1();
		PassObject p=new PassObject();
		p.printArea(c, 5);
		System.out.println("now radius is"+c.getRadius());
	}
}
