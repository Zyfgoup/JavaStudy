package ������ϰ;

public class Triangle {
	double area;
	int height;
	int length;
	public static void main(String[] args) {
		Triangle ta[]=new Triangle[4];
		int x=0;
		
		while(x<4) {
			ta[x]=new Triangle();
			ta[x].height=(x+1)*2;
			ta[x].length=x+4;
			ta[x].setArea();
			System.out.print("triangle "+x+", area");
			System.out.println("="+ta[x].area);
			x++;
		}
		
		int y=x;
		x=27;
		Triangle t5=ta[2];
		System.out.println(t5.area);//���18.0
		 ta[2].area=343;
		 System.out.print("y="+y);
		 System.out.println(",t5 area="+t5.area);//���343.0��ζ��ta[2].areaҲ���ݸ�t5.area��
	}
	void setArea() {
		area=(height*length)/2;
		
	}
}
