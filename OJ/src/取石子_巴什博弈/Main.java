package 取石子_巴什博弈;

import java.util.Scanner;
/*
 * 一共a个 一次最多取b个 tt第一次取a%（b+1）个 此后 , tt可保证室友与tt每各取一次和为b+1个 tt必胜
	否则 若a%（b+1）==0 则tt不能必胜 聪明的室友赢
	
 巴什博奕（Bash Game）：
只有一堆n个物品，两个人轮流从这堆物品中取物，规定每次至少取一个，最多取m个。最后取光者得胜。
显然，如果n=m+1，那么由于一次最多只能取m个，所以，无论先取者拿走多少个，后取者都能够一次拿走剩余的物品，后者取胜。
因此我们发现了如何取胜的法则：如果n=（m+1）r+s，（r为任意自然数，s≤m),那么先取者要拿走s个物品，如果后取者拿走k（≤m)个，
那么先取者再拿走m+1-k个，结果剩下（m+1）（r-1）个，以后保持这样的取法，那么先取者肯定获胜。
总之，要保持给对手留下（m+1）的倍数，就能最后获胜。
 */
public class Main {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int a = cin.nextInt();
			int b = cin.nextInt();//总共n个，每次最后取m个不代表每次取m个
			
			if(a%(b+1) != 0)
				System.out.println("Win");
			else
				System.out.println("Lose");
			
		}
	}
}


