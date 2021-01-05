import java.util.Scanner;
/*
 *  7 8 1
 *  6 9 2
 *  5 4 3
 */

public class ʵ����_���ξ��� {
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
		//С�ڵ��ھͿ��Դ�ӡ
		while(leftRow<=rightCol) {
			int r = leftRow; int c = rightCol;
			while(r<=rightRow) {
				matrix[r++][c] = num++;
			}
			//�ָ�
			r--;
			
			//���½��Ѿ��ڵ�һ��whileѭ����ֵ�� ����c--
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
			
			//�߽� ��ߵļ� �ұߵ�-
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
