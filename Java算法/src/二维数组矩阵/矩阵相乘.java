package 二维数组矩阵;

public class 矩阵相乘 {
	public static void main(String[] args) {
		int[][] arr1 = {
			{2,3,4},
			{1,3,5}
		};
		int[][] arr2= {
				{3,1,2},
				{2,4,6},
				{1,1,1}
		};
		f(arr1,arr2);
	}
	
	public static void f(int[][] matrix1,int[][] matrix2) {
		int[][] result = new int[matrix1.length][matrix2[0].length];
		
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				//控制两个矩阵的行列相乘
				int r1=i;int c1 = 0;
				int r2 = 0;int c2 = j;
				while(c1<matrix1[0].length)
					result[i][j]+=matrix1[r1][c1++]*matrix2[r2++][c2];
			}
		}

		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}
