package ASCII������;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		for(int i=0;i<n;i++) {
			String str = cin.next();
			char[] c = str.toCharArray();
			sort(c);
			display(c);
			
		}
	}
	
	public static void sort(char[] c) {
		for(int i=0;i<c.length-1;i++) {//n�����ݵ�ð�ݣ���Ҫn-1��ð��
			for(int j=0;j<c.length-1-i;j++) {//��һ�αȽ�n-1���ڶ���n-2
				if(c[j]>c[j+1]) {
					char temp = c[j];
					c[j] = c[j+1];
					c[j+1] = temp;
				}
			}
		}
	}
	public static void display(char[] c) {
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println();
	}
}
