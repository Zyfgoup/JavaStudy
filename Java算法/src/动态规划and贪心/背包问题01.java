package 动态规划and贪心;

import java.util.Arrays;

/*
有n个重量和价值分别为wi，vi的物品，从这些物品中挑选出总重量不超过W的物品，求所有挑选方案中价值总和的最大值。
    1≤n≤100
    1≤wi，vi≤100
    1≤W≤10000
输入：
    n=4
    (w,v)={(2,3),(1,2),(3,4),(2,2)}
    W=5

输出：
    7（选择第0，1，3号物品）
因为对每个物品只有选和不选两种情况，所以这个问题称为01背包。
 */
public class 背包问题01 {
	 static int[] w = {2, 1, 3, 2};//重量表
	  static int[] v = {3, 2, 4, 2};//价值表
	  static int n = 4;//物品数量
	  static int W = 5;//背包的承重极限
	  static int[][] dp = new int[n+1][W+1];
	  
	  static int[][] res;
	public static void main(String[] args) {
		System.out.println(dfs(0,W));
		
		res = new int[n][W+1];
		//将数组全部初始化为-1
		for(int i=0;i<n;i++) {
			Arrays.fill(res[i], -1);
		}
		
		System.out.println(f1(0,W));
		
		System.out.println(dp());
		traceback(W,w);
	}
	
	
	//深搜的复杂度为O(2^n)
	//i表示当前要做选择的的第几个物品
	public static int dfs(int i,int ww) {
		
		//边界
		if(i==n) {
			return 0; //没有物品可以继续选了
		}
		
		if(ww<=0) {
			return 0; //选完了或者超过了
		}
		
		
		int v2 = dfs(i+1,ww);//不选当前物品
		
		//选当前物品 但是要判断会不会超过总重量
		if(ww>=w[i]) {
			int v1 = v[i]+dfs(i+1,ww-w[i]);//注意w[i]与v[i]的区别 别写错了
			return Math.max(v1, v2);
		}else
			return v2;
	}
	
	
	//记忆型递归  可以避免一些重复计算  对dfs画出递归树时，可以发现会有些状态是重复计算的，那么我们可以将每一次的计算记录下来
	//在每一次计算一个新状态时，看看之前有没有计算过，有的话就就直接用，不需要重复计算了
	public static int f1(int i,int ww) {
		//边界
		if(i==n) {
			return 0; //没有物品可以继续选了
		}
		
		if(ww<=0) {
			return 0; //选完了或者超过了
		}
		
		//计算前先查询之前有没计算过该子问题
		if(res[i][ww]>=0) //一开始将数组全部初始化为-1  因为有些可能为0
			return res[i][ww];
		
		
		int v2 = dfs(i+1,ww);//不选当前物品
		
		int ans;
		
		//选当前物品 但是要判断会不会超过总重量
		if(ww>=w[i]) {
			int v1 = v[i]+dfs(i+1,ww-w[i]);//注意w[i]与v[i]的区别 别写错了
			ans = Math.max(v1, v2);
		}else
			ans = v2;
		
		//计算后记录计算结果
		res[i][ww] = ans;
		return ans;
	}
	
	
	//dp 打表的方法，  dp[i][j]表示 可以选前i个物品的情况下  总重量为j  不超过j能选的最大价值
	public static int dp() {
		
		//初始化表的第一行  第一行只能选第一个物品 所以j>=w[0]的情况下 就可以将w[0]赋值给dp[0][j]
		for(int j=1;j<W+1;j++) {
			if(j>=w[0])//能拿该物品
				dp[1][j] = v[0]; //又将w[0]与v[0]写错了
			/*else
				dp[0][i] = 0;        数组本来初始化就为0*/
		}
		
		//表的第一列  总重量为0  所以都为0 
		
		//其他行
		for(int i=2;i<=n;i++) {
			
			//j表示列 就是总重量
			for(int j=1;j<=W;j++) {
				
				//要的起该物品的情况下 又要分要和不要
				if(j>=w[i-1]) {
					int i1 = v[i-1]+dp[i-1][j-w[i-1]];//选择当前物品后 再加上 剩余重量的情况下 能选前i-1个物品的最大价值
					int i2 = dp[i-1][j];//不拿该物品 那么就等于在能拿i-1个 总重量为j的情况下的最大价值
					dp[i][j] = Math.max(i1, i2);
				}else {
					//重量不够拿该物品
					dp[i][j] = dp[i-1][j]; //那么就看选前i-1个
				}
				
			}
		}
		
		return dp[n][W]; //最后返回 在能选前n-1个的情况下  总重量为5的最大价值，也就是题目的意思
		
	}
	
	public static void traceback(int C,int[] W) {
		for(int i=n;i>=1;i--) {
			if(dp[i][C]==dp[i-1][C])
				continue;
			else {
				System.out.println("拿了第"+i+"个行李");//打印拿了第几个行李
				C -= w[i-1];
			}
		}
	}
}
