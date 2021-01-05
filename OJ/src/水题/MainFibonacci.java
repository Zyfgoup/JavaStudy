package Ë®Ìâ;

import java.util.Scanner;

public class MainFibonacci {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int a = cin.nextInt();
			System.out.println(fun1(a));
		}
	}
	public static int fun1(int n) {
		if(n == 1||n == 2) {
			return 1;
		}else {
			return fun1(n-1)+fun1(n-2);
		}
	}
}
