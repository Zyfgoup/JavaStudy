import java.util.Scanner;
/*
 *  7 8 1
 *  6 9 2
 *  5 4 3
 */

public class 实验三_蛇形矩阵 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			int n = cin.nextInt();
			print(n);
			System.out.println();
		}
	}
	
	public static void print(int n) {
		if(n==0)
			return;
		int[][] matrix = new int[n][n];
		int num = 1;
		int leftRow = 0; int leftCol = 0;
		int rightRow = n-1;int rightCol = n-1;
		//小于等于就可以打印
		while(leftRow<=rightCol) {
			int r = leftRow; int c = rightCol;
			while(r<=rightRow) {
				matrix[r++][c] = num++;
			}
			//恢复
			r--;
			
			//右下角已经在第一个while循环赋值了 所以c--
			c--;
			while(c>=leftCol) {
				matrix[r][c--] = num++;
			}
			
			c++;
			r--;
			
			while(r>=leftRow) {
				matrix[r--][c] = num++;
			}
			r++;
			
			c++;
			while(c<rightCol) {
				matrix[r][c++] = num++;
			}
			
			//边界 左边的加 右边的-
			rightRow--;
			rightCol--;
			
			leftRow++;
			leftCol++;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
		
				System.out.println();
		}
	}
}
