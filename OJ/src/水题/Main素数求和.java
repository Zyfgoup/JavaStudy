package 水题;

import java.util.Scanner;

public class Main素数求和 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int sum = 0;
			boolean flag = true;
			int n1 = cin.nextInt();
			int[] a = new int[n1];
			
			for(int i=0;i<a.length;i++) {
				a[i] = cin.nextInt();
			}
			for(int i=0;i<a.length;i++) {
				for(int j=2;j<a[i];j++) {
					if(a[i]%j == 0) {
						flag = false;
						break;
					}
				}
				if(flag&&a[i]!=1)
					sum+=a[i];
				
				flag = true;//标记要更新
			}
			System.out.println(sum);
		}
	}
}	
