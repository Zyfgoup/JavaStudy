package 深入递归;
/*
 * 假设我们有8种不同面值的硬币｛1，2，5，10，20，50，100，200｝，用这些硬币组合构成一个给定的数值n。
 * 例如n=200，那么一种可能的组合方式为 200 = 3 * 1 + 1＊2 + 1＊5 + 2＊20 + 1 * 50 + 1 * 100.
 * 问总共有多少种可能的组合方式？ (这道题目来自著名编程网站ProjectEuler) 类似的题目还有：

 　　[华为面试题] 1分2分5分的硬币三种，组合成1角，共有多少种组合
 1*x + 2*y + 5*z=10
 　　[创新工厂笔试题] 有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱，有多少组合可以组成n分钱

 1 5 10 25 分 n,多少种组合方法.
 */


public class 硬币表示 {
	public static void main(String[] args) {
		System.out.println(countWays2(26));
	}
	
	
	//递推
	/*
	 * 用一个二维矩阵来记录 只能用该钱及比它少的n分钱的可能
	 * int[][] dp = new int[4][n+1]
	 * 可以看出每行记录的是j分钱用coins[i]或者比其小的面值的能有多少种组合方法
	 * 那么不断地推下去 结果就是dp[3][n]
	 */
	public static int countWay1(int n) {
		int[] coins = {1,5,10,25};
		int[][] dp = new int[4][n+1];//n+1才能计算到n 第一列是特殊的给刚好够本行的j分钱全部用coins[i]来组合成j分钱
		
		for(int i=0;i<4;i++) {
			dp[i][0] = 1;//第一列是特殊的给刚好够本行的j分钱全部用coins[i]来组合成j分钱 所以赋值为1 可能性是一种
		}
		
		for(int i=0;i<n+1;i++) {
			dp[0][i] = 1; //只用1分钱凑所有数值都只有1种可能
		}
		
		for(int i=1;i<4;i++) {
			for(int j=1;j<n+1;j++) {
				
				//这里的意思是遍历到最多能用几张本行 coins[i]的面值 
				for(int k=0;k<=j/coins[i];k++) {
					/*
					 * 如果k=0 那么j-k*coins[i] = j 那么就是不用本行的面值 那么就是全用coins[i-1]的面值 
					 * 那么次数就是dp[i-1][j]这个是不断递推求得的所以这个值是确定的了
					 * 然后当k=1 那么就是用一张本行的面值 那么剩下的钱能有多少种组合方法就看dp[i-1][j-k*coins[i]]的值为多少 
					 *dp[i-1][j-k*coins[i]] 表示不用本行面值的情况下 j-k*coins[i]分钱能有多少种组合方法
					 *
					 *.....继续下去 全部可能都相加起来
					 *
					 *当k=j/coins[i]时  那么j-k*coins[i]=0了  意味着不用coins[i-1]及更小的面值了，
					 *因为全部用coins[i]的面值来表示了，那么组合方案有一种，所以第一列的所有值都为1来表示面值为0的情况
					 */
					dp[i][j]+=dp[i-1][j-k*coins[i]];
				}
			}
		}
		return dp[3][n];//返回能用25面值及更小面值的情况下合成n分钱的组合方案一共有
	}
	
	//递推二  时间复杂度小很多
	 public static int countWays2(int n) {
		 int[] coins = {1,5,10,25};
		 int[] dp = new int[n+1];
		 dp[0] = 1;//j-coins[i]==0了，余额为0了 那么也是一种情况
		 
		 //从低面值开始遍历更新dp[1......n]
		 for(int i=0;i<4;i++) {
			 
			 //j从coins[j]开始，因为小于coins[j]的值更上一次循环得到的dp是一样的 只有从j等于coins[i]开始有新的组成方案
			 //因为用得上coins[i]了
			 for(int j = coins[i];j<n+1;j++) {
				 
				 //dp[j]的组合方案等于上一轮得到的dp[j]就是不使用coins[i]面值情况下的组成方案
				 //再+上使用一张coins[i]的面值，那么余额就剩j-coins[i] 那么此时的索引处的dp是本轮的已经更新过了
				 //其实dp[j-coins[i]] = dp[j-coins[i]]+dp[j-coins[i]-coins[i]]的值  就相当于又用了一张coins[i]的面值
				 //....
				 //就取代了方法一用一个for循环遍历能用多少张coins[i]的面值
				 dp[j] = (dp[j]+dp[j-coins[i]]);
			 }
		 }
		 return dp[n];
	 }
	 
	 //递归实现
	 public static int countWays(int n) {
		 if(n<=0)
			 return 0;
		 return countWaysCore(n,new int[] {1,5,10,25},3);
	 }


	private static int countWaysCore(int n, int[] coins, int cur) {
		
		//基值：如果只使用1分  那么都只有一种组合方案
		if(cur==0) {
			return 1;
		}
		
		int res = 0;
		//用0张coins[cur]
		//用一张coins[cur]
		//...
		for(int i=0;i*coins[cur]<=n;i++) {
			int shengyu = n-i*coins[cur];
			//跟方法一一样 ，用k张coins[i] 就看dp[i-1][j-k*coins[cur]]有多少种组合方法 都加起来 就是dp[i][j]
			res += countWaysCore(shengyu,coins,cur-1);
		}
		
		return res;
	}
}
