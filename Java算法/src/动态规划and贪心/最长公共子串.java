package 动态规划and贪心;
/*
 * 计算两个字符串的最大公共子串（Longest Common Substring）的长度，字符不区分大小写。
 */


/*
 * 算法思想其实跟求最长子序列差不多  只不过子序列不需要连续  而子串要连续
 * 因为要连续的所以当x[i-1]!=y[j-1]时 dp[i][j]=0
 * 其他都是一样的
 * 
 * 如果要输出最长子串 那么就记录max值  的 i，j坐标
 * 因为将s1[i-1] s1[i-2] .... s[i-max] 存入字符串里 反转输出即可
 */
public class 最长公共子串 {
	public static void main(String[] args) {
		String s1 = "CADJH";
		String s2 = "ACDJHCADJADJHCADJ";
		System.out.println(f1(s1,s2));//5
	}
	
	

	//因为每一行都只跟上一行有关系 所以可以用一位数组来存储结果
	public static int  f1(String s1,String s2) {
		if(s1.equals("")||s2.equals(""))
			return 0;
		int max = 0;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
					if(max<dp[i][j])
						max = dp[i][j];
				}
				/*else   数组没有赋值的默认为0  可以省略不写这语句了
					dp[i][j] = 0;*/
	
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return max;
		
	}
}
