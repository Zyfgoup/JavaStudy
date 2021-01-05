package 动态规划and贪心;

import java.util.Scanner;

/**
 * 数字三角形(POJ1163)<br>
 *
 * 在数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。<br>
 * 路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。<br>
 * 三角形的行数大于1小于等于100，数字为 0 - 99<br>
 * 输入格式：<br>
 * 5 //表示三角形的行数 接下来输入三角形<br>
 *      7<br>
 *     3 8<br>
 *    8 1 0<br>
 *   2 7 4 4<br>
 *  4 5 2 6 5<br>
 * 要求输出最大和<br>
 */
public class 数字三角形 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[][] triangle = new int[n][];
	    for (int i = 0; i < n; i++) {
	      triangle[i] = new int[i + 1];
	      for (int j = 0; j < i + 1; j++) {
	        triangle[i][j] = sc.nextInt();
	      }
	    }
	    System.out.println(dp(triangle));
	}
	
	
	//dp 从下往上推
	public static int dp(int[][] triangle) {
		int rowCount = triangle.length;
		int colCount = triangle[rowCount-1].length;//最后一行的列数
		
		//每一行只跟前一行有关，且覆盖的不影响后面的 所以可以用动态数组
		int dp[] = new int[colCount];
		
		for(int k=0;k<colCount;k++) {
			dp[k] = triangle[rowCount-1][k]; //将最后一行赋值dp[]进行初始化
		}
		
		for(int k=rowCount-2;k>=0;k--) {
			//行比列多1
			for(int j=0;j<k+1;j++) {
				dp[j] = triangle[k][j]+Math.max(dp[j], dp[j+1]); //自身加下一行的左或者右 
			}
		}
		return dp[0];
	}
}
