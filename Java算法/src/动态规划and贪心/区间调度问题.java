package 动态规划and贪心;

import java.util.Arrays;
import java.util.Scanner;

/*
有n项工作,每项工作分别在si时间开始,在ti时间结束.

对于每项工作,你都可以选择参与与否.如果选择了参与,那么自始至终都必须全程参与.

此外,参与工作的时间段不能重复(即使是开始的瞬间和结束的瞬间的重叠也是不允许的).

你的目标是参与尽可能多的工作,那么最多能参与多少项工作呢?

1≤n≤100000

1≤si≤ti≤10^9

输入:

第一行:n
第二行:n个整数空格隔开,代表n个工作的开始时间
第三行:n个整数空格隔开,代表n个工作的结束时间

样例输入:

5
1 3 1 6 8
3 5 2 9 10

样例输出:

3

说明:选取工作1,3,5
 */

//要求出最多能多多少个工作  那么肯定是最优解的问题 那么就要找到某种规则 每次选最优的
//根据题目可以推出每次按照结束时间最先的进行选 
//当然要判断选的这个工作的开始时间是否大于上一个结束时间  不能交叉

//为什么能得到根据选结束时间小的呢，可以举一些例子来证明
//如果是选开始时间早的话  但是它结束时间很久 那么中间可能有非常多工作时间很短的
//如果是选工作时间最短的  那么它这个工作有可能位于两个连续的工作之间 那么肯定是选两个连续的

//要实现每次选结束时间最早 那么就要对结束时间进行排序  但是怎么保证开始时间又相对应呢
//可以创建一个对象 继承接口 重写CompareTo方法 对对象数组进行排序
public class 区间调度问题 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] s = new int[n];
		int[] t = new int[n];
		Job[] jobs = new Job[n];
		for(int i=0;i<n;i++) {
			s[i] = cin.nextInt();
		}
		for(int i=0;i<n;i++) {
			t[i] = cin.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			jobs[i] = new Job(s[i],t[i]);
		}
		Arrays.sort(jobs);
		int res = f1(jobs,n);
		System.out.println(res);
	}

	private static int f1(Job[] jobs, int n) {
		int cnt = 1;//第一个肯定要添加的 因为第一个结束时间最早
		int last = jobs[0].t;//记录上一个结束时间
		for(int i=1;i<n;i++) {
			if(jobs[i].s>last) {
				cnt++;  //按照结束时间从早到晚排好序了  那么只要开始时间大于上一个结束时间 就++
				last = jobs[i].t;
			}
		}
		
		return cnt;
	}
}
class Job implements Comparable<Job>{
	int s;
	int t;
	
	public Job(int s,int t) {
		this.s = s;
		this.t = t;
	}

	@Override
	public int compareTo(Job obj) {
		int x = this.t-obj.t;//比较结束时间
		if(x==0)
			return this.s-obj.s;//如果结束时间一样的情况 就把开始时间早的排在前面
		else
			return x;
	}
	
}
