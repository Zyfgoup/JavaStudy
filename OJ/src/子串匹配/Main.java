package 子串匹配;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int n = cin.nextInt();
		
		for(int i=0;i<n;i++){
			String a = cin.next();
			String b = cin.next();
			int count = 0;//计数
			
			for(int j=0;j<=b.length()-a.length();j++) {//要<=  细心一点
				if(b.substring(j,a.length()+j).equals(a)) //不能用 == 来判断 比较的是地址
					count++;
			}
			System.out.println(count);
		}
	}
}
