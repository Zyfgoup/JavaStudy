package 动态规划and贪心;

import java.util.Arrays;
import java.util.Scanner;

public class 贪心_资源调度 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		P[] p = new P[n];
		int[] t = new int[n+1];//预计服务时间 长度加1 方便计算
		for(int i=0;i<n;i++) {
			t[i+1] = cin.nextInt();
			int d = cin.nextInt();
			p[i] = new P(i+1,d);
		}
		int[] a = new int[n+1];
		
		f1(p,a,t);
		
	}

	private static void f1(P[] p, int[] a, int[] t) {
		Arrays.sort(p);//对客户实例数组进行按di排序 不改变相对应的客户序号
		
		a[1] = 0;  //对应f(1) 固定为0
		
		for(int i=1;i<p.length;i++) { //遍历数组
			//a[x]等于按顺序大小的前一个a[x-1]加上第i-1个的预计客户服务时间t[i-1]
			a[p[i].num] = a[p[i-1].num]+t[p[i-1].num]; 
		}
		
		//输出a[i]
		for(int i=1;i<a.length;i++) {
			System.out.println("f["+i+"]: "+a[i]);
		}
	}
	
}
class P implements Comparable<P>{
	int num;//客服序号
	int d;//希望服务完结时间
	
	public P(int num,int d) {
		this.num = num;
		this.d = d;
	}

	@Override
	public int compareTo(P o) {
		return this.d-o.d;
	}
}
