package ������ϰ;

import java.security.Principal;

//��1������һ��Circle�࣬����һ��double�͵�radius���Դ���Բ�İ뾶��һ��findArea()��������Բ�������
//��2������һ����PassObject�������ж���һ������printAreas()���÷����Ķ������£�
//		public void printAreas(Cirlce c, int time)
//��printAreas�����д�ӡ���1��time֮���ÿ�������뾶ֵ���Լ���Ӧ����������磬timesΪ5��������뾶1��2��3��4��5���Լ���Ӧ��Բ�����
//��main�����е���printAreas()������������Ϻ������ǰ�뾶ֵ���������н����ͼ��ʾ��
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
