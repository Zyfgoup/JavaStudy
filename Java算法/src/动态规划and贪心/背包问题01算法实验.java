package 动态规划and贪心;

public class 背包问题01算法实验 {
	public static void main(String[] args) {
		int n = 5;
		int C = 20;
		int[] w = {0,6,4,8,8,4};
		int[] v1 = {0,8,4,8,10,2};
		int[][] v = new int[n+1][C+1];
		System.out.println(dp(v,w,v1,C,n));
		traceBack(C,w,n,v);
	}
	
	public static int dp(int[][] v,int[] w,int[] v1,int C,int n) {
		//初始化表的第一行  第一行只能选第一个物品 所以j>=w[1]的情况下 就可以将v[1]赋值给v[1][j]
		for(int j=1;j<=C;j++) {
			if(j>=w[1])//能拿该物品
				v[1][j] = v1[1];
			/*else
				dp[0][i] = 0;        数组本来初始化就为0*/
		}
		//其他行
		for(int i=2;i<=n;i++) {
			//j表示列 就是最大负重
			for(int j=1;j<=C;j++) {
				
				//能取该行李的情况下 又要分要和不要
				if(j>=w[i]) {
					int i1 = v1[i]+v[i-1][j-w[i]];//选择当前行李后 再加上 剩余重量的情况下 能选前i-1个物品的最大效益
					int i2 = v[i-1][j];//不拿该物品 那么就等于在能拿i-1个 总重量为j的情况下的最大效益
					v[i][j] = Math.max(i1, i2);//取二者中的最大值
				}else {
					//重量不够拿该行李
					v[i][j] = v[i-1][j]; //那么就看选前i-1个行李的最大收益
				}
				
			}
		}
		
		return v[n][C]; //最后返回 在能选前n个行李的情况下  总重量为C的最大效益
	}
	
	public static void traceBack(int C,int[] w,int n,int[][] v) {
		for(int i=n;i>=1;i--) {//从最后面开始往回找
			if(v[i][C]==v[i-1][C]) //如果没有值相等表示没有取第i个行李那么就继续循环
				continue;
			else { //取了该行李
				System.out.println("拿了第"+i+"个行李");//打印取了第几个行李
				C -= w[i]; //最大负重要减去第i个行李的重量
			}
		}
	}
}
