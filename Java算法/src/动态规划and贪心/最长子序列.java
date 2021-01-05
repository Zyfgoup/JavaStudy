package 动态规划and贪心;

import java.util.Set;

/* 最长子序列长度：
 * 详细算法思想参考：https://blog.csdn.net/lisonglisonglisong/article/details/41548557
 * 
 * 
X[1...m] = {A, B, C, B, D, A, B}
Y[1...n] = {B, D, C, A, B, A}
可以看出，X 和 Y 的最长公共子序列有 “BDAB”、“BCAB”、“BCBA”，即长度为4。
子序列则只需保持相对顺序，并不要求连续
 */


/*设f(x,y,i,j)表示两个字符串的最长公共子序列，从i,j开始比
 *  当x[i]==y[j]时  那么就可以将问题变成从[2....m]和[2....n]两个字符串的最长子序列再加上1    1+f(x,y,i+1,y+1)
 *  当x[i]!=y[j]时，那么就可以有 f(x,y,i+1,j)或者是f(x,y,i,j+1) 原理同上 划分成子问题
 *  因为要求最长的子序列  那么就是max(f(x,y,i+1,j),f(x,y,i,j+1))
 *  边界条件 就是i, j其中一个为0了 
 */

public class 最长子序列 {
	static String s1 = "ABCBDAB";
	static String s2 = "BDCABA";
	public static void main(String[] args) {
		int[][] b = new int[s1.length()+1][s2.length()+1];
		System.out.println(LCS1(s1,s2,0,0));
		System.out.println(LCS2(b));
		System.out.println();
		for(int n=0;n<b.length;n++) {
			for(int m=0;m<b[0].length;m++) {
				System.out.print(b[n][m]+" ");
			}
			System.out.println();
		}
		LCS(b,s1.length(),s2.length());
	}
	
	
	//递归的方法求解  但是时间复杂度为O(2^n)指数级的增长，画出递归树可以发现会出现很多重复的调用，
	//所以具有动态规划的特性之一问题具有重叠子问题的特性
	public static int LCS1(String s1,String s2,int i,int j) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		if(i==s1.length()||j==s2.length())
			return 0;
		
		if(c1[i]==c2[j])
			return 1+LCS1(s1,s2,i+1,j+1);
		else
			return Math.max(LCS1(s1,s2,i+1,j),LCS1(s1,s2,i,j+1));
	}
	
	//dp求解  通过一个二维数组来保存子问题的结果，避免重复计算 ，用空间换时间 O(nm)
	//这里 两个串 没有先后之分 都可以
	public static int LCS2(int[][] b) {
		
		//长度为字符串+1
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		//第一行第一列都是0 数组初始化都为0  所以没必要再初始化了
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//注意调用的charAt()方法是从0开始的  这里都是从1开始
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					b[i][j] = 1;//1表示从左斜上方得来
				}else if(dp[i-1][j]>=dp[i][j-1]) {
					dp[i][j] = dp[i-1][j];
					b[i][j] = 2; //从上一行同列获得
				}else {
					dp[i][j] = dp[i][j-1];
					b[i][j] = 3;
				}
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return dp[s1.length()][s2.length()];
		
	}
	
	//输出最长子序列  的其中一种情况
	public static void LCS(int[][] b,int i,int j) {
		
			
			
		if(i==0||j==0) 
			return;
		
		if(b[i][j]==1) {
			LCS(b,i-1,j-1);
			//注意调用的charAt()方法是从0开始的  这里都是从1开始
			System.out.print(s1.charAt(i-1));
		}else if(b[i][j]==2)
			LCS(b,i-1,j);
		else
			LCS(b,i,j-1);
	}

	
}
