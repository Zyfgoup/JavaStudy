package �ݹ���һЩ����Ŀ;

public class Hanio {
	public static void main(String[] args) {
		f1('a','b','c',3);
	}
	
	public static void f1(char a,char b,char c,int n) {
		if(n==1) {
			System.out.println("����"+n+"���̴�"+a+"�ƶ���"+b);
			return;
		}
		
		
		f1(a,c,b,n-1);
		System.out.println("����"+n+"���̴�"+a+"�ƶ���"+b);
		f1(c,b,a,n-1);

	}
}
