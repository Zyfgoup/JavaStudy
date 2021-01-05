package Ë®Ìâ;

import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int a = cin.nextInt();
			
			for(int i=1;i<=a;i++) {
				if(i%2 != 0)
				System.out.print(i+" ");
			}
			System.out.println("");
			for(int i=2;i<=a;i++) {
				if(i%2 == 0)
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
}
