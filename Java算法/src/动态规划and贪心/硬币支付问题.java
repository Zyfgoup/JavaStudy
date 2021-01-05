package 动态规划and贪心;

import java.util.Scanner;

/*
硬币问题

有1元,5元,10元,50元,100元,500元的硬币各c1,c5,c10,c50,c100,c500枚.

现在要用这些硬币来支付A元,最少需要多少枚硬币?

假定本题至少存在一种支付方案.

0≤ci≤10^9

0≤A≤10^9

输入:

第一行有六个数字,分别代表从小到大6种面值的硬币的个数

第二行为A,代表需支付的A元

样例:

输入

3 2 1 3 0 2
620

输出

6
*/
//贪心算法， 要求最优解 那么每次都是选择最大的面值 那么最后得到的硬币数量肯定是最少的

//用最少的硬币支付，很明显是硬币表示的一种组合方案，那么就是求出一个最优解
//可知道要硬币最少 那么应该尽量用面值大的，所以从面值最大的开始递推  要注意面值的数量 有可能为0
//假设第一次用500 那么就是 (A/500)就是能用最多张500表示  A-（A/500）*500 就是剩余的
//但是A/500 可能大于 面值的数量 所以这里要求出是否满足 那么就是谁比较小 就用谁



public class 硬币支付问题 {
	static int[] coins = {1,5,10,50,100,500};
	static int[] shu = new int[6];
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		for(int i=0;i<6;i++) {
			shu[i] = cin.nextInt();
		}
		
		int A = cin.nextInt();//A元
		
		System.out.println(f1(A,5));
	}
	private static int  f1(int A, int cur) {
		//基值
		if(cur<0)
			return 0;
		if(A==0)
			return 0;
		
		int a = A/coins[cur];//能用最多多少张coins[i]
		
		//如果a大于b shu[cur] 那么最多也只能用shu[cur]张
		//如果a小于b 那么也只能用a张
		int b = min(a,shu[cur]);//与面值的数量比较 谁小选谁
		return b+f1(A-(coins[cur]*b),cur-1);
		
	}
	private static int min(int a, int i) {
		return (a<i)? a:i;
	}
}
