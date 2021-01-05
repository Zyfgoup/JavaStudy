package 二维数组矩阵;

import java.util.Arrays;

/*
 * 
 * 假定只有一行，那就和求最大和子数组一样
 * 如果限定两行，可以把两行按列求和，然后求和之后按照一维数组求最大子序列和一样
 * ……
 * 所有我们从把第一行当做起点，依次累加后面的每一行后，都求一个最大子数组和
 * 以第二行作为起点，依次累加后面的每一行后，都求一个最大子数组和
 *
 * 每次求出来的和与历史最大值比较，如果更大，则更新
 */
public class 子矩阵的最大和 {
	public static void main(String[] args) {
		  int[][] matrix = {
			        {-90, 48, 78},
			    };
		  System.out.println(f(matrix));
	}
	
	public static int f(int[][] matrix) {
		int beginrow = 0;
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[] sums = new int[m];//把每行按列求和
		
		int max = 0;//历史矩阵的和的最大值
		
		while(beginrow<n) {
			
			//从beginrow行到n行按列相加
			for(int i=beginrow;i<n;i++) {
				
				for(int j=0;j<m;j++) {
					sums[j]+=matrix[i][j];
				}
				
				//每次逐渐加一行求解
				//调用求解一维数组连续子数组最大和的方法
				int a = 最大连续子数组的和.f2(sums);
				if(a>max)
					max = a;
			}
			
			Arrays.fill(sums, 0);//把记录每行按列相加清0
			beginrow++;
		}
		return max;
		
	}
}
