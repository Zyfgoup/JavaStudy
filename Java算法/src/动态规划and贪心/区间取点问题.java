package 动态规划and贪心;

import java.util.Arrays;
import java.util.Scanner;

//数轴上有n个闭区间[ai,bi]。取尽量少的点，使得每个区间内都至少有一个点（不同区间内含的点可以是同一个）。
/*
Intervals
You are given n closed, integer intervals [ai, bi] and n integers c1, ..., cn.
Write a program that:
reads the number of intervals, their end points and integers c1, ..., cn from the standard input,
computes the minimal size of a set Z of integers which has at least ci common elements with interval [ai, bi], for each i=1,2,...,n,
writes the answer to the standard output.

Input
The first line of the input contains an integer n (1 <= n <= 50000) -- the number of intervals.
The following n lines describe the intervals. The (i+1)-th line of the input contains three integers ai,
bi and ci separated by single spaces and such that 0 <= ai <= bi <= 50000 and 1 <= ci <= bi - ai+1.

Output
The output contains exactly one integer equal to the minimal size of set Z
sharing at least ci elements with interval [ai, bi], for each i=1,2,...,n.
Sample Input
5
3 7 3
8 10 3
6 8 1
1 3 1
10 11 1
Sample Output
6
*/
//POJ1201   要用树的数组形式

//用这种时间会超时，只是体会贪心的思想，每一步的最优解得到最终的最优解
//一样是根据末端点排序的思想，只不过每段区间都需要取够对应的点，但是有些交叉的区间，一个点可以同时满足两个区间
//所以要找到用最少的点
//取点时也是从最末端开始取，但是所有区间投影在一条线段上时，点是会有重合的，所以要排除重复的问题，如果某个点在这个区间取了，
//那么下个区间也可以取到这个点的话，就需要先判断在这个区间上有没有点被标记了 那么该取的点就要减去被标记的
//用一个数组 长度为排好序后最后一个对象的t值+1作为长度， 最末端
public class 区间取点问题 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Intervals[] intervals = new Intervals[n];
		for(int i=0;i<n;i++) {
			intervals[i] = new Intervals(cin.nextInt(),cin.nextInt(),cin.nextInt());
		}
		
		//按照末尾位置排序
		Arrays.sort(intervals);
		
		int max = intervals[n-1].t;//末端的最大值
		int[] axis = new int[max+1];//用来记录哪些点时标记过，防止重复标记
		
		for(int i=0;i<n;i++) {
			int s = intervals[i].s;
			int t = intervals[i].t;
			
			int cnt = sum(axis,s,t);//计算该段区间有多少个点了
			
			intervals[i].c-=cnt;//减去已标记的点
			//如果还有点为标记，那么就从最末端开始，如果该点已经标记就往左继续探索
			while(intervals[i].c>0) {
				if(axis[t] == 0) {//从最末端开始
					axis[t] = 1;
					intervals[i].c--;
					t--;
				}else//这个点被选过了
					t--;
			}
		}
		
		System.out.println(sum(axis,0,max));
	}
	
	private static int sum(int[] axis, int s, int t) {
		int count = 0;
		for(int i=s;i<=t;i++) {
			if(axis[i]!=0)
				count++;
		}
		return count;
	}

	private static class Intervals implements Comparable<Intervals>{
		int s;//起点
		int t;//终点
		int c;//该区间要取的点
		
		public Intervals(int s,int t,int c) {
			this.s = s;
			this.t= t;
			this.c = c;
		}

		@Override
		public int compareTo(Intervals o) {
			//用t来排序
			int x = this.t-o.t;
			if(x==0)//如果末尾点相同，则看起始位置
				return this.s-o.s;
			return x;
		}
	}
}
