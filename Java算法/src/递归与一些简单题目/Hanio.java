package 递归与一些简单题目;

public class Hanio {
	public static void main(String[] args) {
		f1('a','b','c',3);
	}
	
	public static void f1(char a,char b,char c,int n) {
		if(n==1) {
			System.out.println("将第"+n+"个盘从"+a+"移动到"+b);
			return;
		}
		
		
		f1(a,c,b,n-1);
		System.out.println("将第"+n+"个盘从"+a+"移动到"+b);
		f1(c,b,a,n-1);

	}
}
