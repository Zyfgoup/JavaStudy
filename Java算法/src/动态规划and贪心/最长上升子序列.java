package 动态规划and贪心;

public class 最长上升子序列 {
	static int[] arr = {4, 2, 3, 1, 5, 6, 4, 8, 5, 9};  // 6
	public static void main(String[] args) {

	    System.out.println(dp(arr)); 

	}
	
	//O(nlogn) 不是很懂
	public static int dp1(int[] arr) {
		int[] dp = new int[arr.length+1];
		dp[1] = arr[0]; // 长度为1的递增子序列 初始化为第一个元素
		int p = 1;//记录 dp数组存到哪个位置了了
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>dp[p]) {
				dp[p++] = arr[i];
			}else {
				//扫描dp数组，将arr[i]放在第一个大于arr[i]的位置 注意是覆盖掉 其他不变
				for(int j=1;j<=p;j++) {
					if(dp[j]>arr[i]) {
						dp[j] = arr[i];
						break;
					}
				}
			}
		}
		return p;//下标为最长的递增子序列
	}
	
	
	//O(n^2)
	private static int dp(int[] arr) {
		int[] dp = new int[arr.length];  //dp[i]表示从arr[0]到arr[i]这个位置的最长子序列
		
		dp[0] = 1;//本身也算上升子序列  长度为1
		
		for(int i=1;i<arr.length;i++) {
			int cnt =1;
			
			//比较从0到i-1中是否小于arr[i] 如果是那么就为上升子序列 
			//那么就是dp[i] = dp[j]+1 
			//但是要求最长 所以是max
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]) {
					cnt = Math.max(cnt,dp[j]+1);
				}
			}
			//给dp[i]赋值最长的子序列长度
			dp[i] = cnt;
		}
		
		
		//遍历dp数组 取最大的
		int ans = 0;
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>ans)
				ans = dp[i];
		}
		return ans;
	}

}
