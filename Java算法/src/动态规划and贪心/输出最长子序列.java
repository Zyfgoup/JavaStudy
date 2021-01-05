package 动态规划and贪心;

import java.util.Set;
import java.util.TreeSet;

/*
 * 输出最长子序列
 * 算法参考：https://blog.csdn.net/lisonglisonglisong/article/details/41596309
 * 
 * 
 *当dp[i][j] 对应得x[i-1]==y[j-1] 那么把x[i-1]添加进字符串 然后跳到dp[i-1][j-1]继续进行判断
 *如果不相等，则判断 dp[i-1][j] 和 dp[i][j-1]谁大 则跳到哪里继续进行判断 如果这两个相等 则都要进行继续判断(递归)
 */
public class 输出最长子序列 {
	static Set<String> set;
	static int[][] dp;
	
	public static void main(String[] args) {
		set = new TreeSet();
		String s1 = "ABCBDAB";
		String s2 = "BDCABA";
		dp = new int[s1.length()+1][s2.length()+1];
		LCS2(s1,s2);
		traceBack(s1,s2,s1.length(),s2.length(),"");
		
		for(String s:set) {
			System.out.println(s);
		}
		
		
	}
	
	
	
	public static void LCS2(String s1,String s2) {
		//第一行第一列都是0 数组初始化都为0  所以没必要再初始化了
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	
	//求出所有子序列 放进set
	public static void traceBack(String s1,String s2,int i,int j,String str) {
		
		while(i>0&&j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				str += s1.charAt(i-1);
				i--;
				j--;
			}
			else { 
				if(dp[i-1][j]>dp[i][j-1])
					i--;
				else if(dp[i-1][j]<dp[i][j-1])
					j--;
				else {//相等的情况
					traceBack(s1,s2,i-1,j,str);
					traceBack(s1,s2,i,j-1,str);
					return;

				}
			}
		}
			set.add(new StringBuffer(str).reverse().toString());
	}
}
