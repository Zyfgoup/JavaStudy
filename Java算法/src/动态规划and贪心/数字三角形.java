package ��̬�滮and̰��;

import java.util.Scanner;

/**
 * ����������(POJ1163)<br>
 *
 * ��������������Ѱ��һ���Ӷ������ױߵ�·����ʹ��·����������������֮�����<br>
 * ·���ϵ�ÿһ����ֻ�������»� �����ߡ�ֻ��Ҫ���������ͼ��ɣ����ظ�������·����<br>
 * �����ε���������1С�ڵ���100������Ϊ 0 - 99<br>
 * �����ʽ��<br>
 * 5 //��ʾ�����ε����� ����������������<br>
 *      7<br>
 *     3 8<br>
 *    8 1 0<br>
 *   2 7 4 4<br>
 *  4 5 2 6 5<br>
 * Ҫ���������<br>
 */
public class ���������� {
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
	
	
	//dp ����������
	public static int dp(int[][] triangle) {
		int rowCount = triangle.length;
		int colCount = triangle[rowCount-1].length;//���һ�е�����
		
		//ÿһ��ֻ��ǰһ���йأ��Ҹ��ǵĲ�Ӱ������ ���Կ����ö�̬����
		int dp[] = new int[colCount];
		
		for(int k=0;k<colCount;k++) {
			dp[k] = triangle[rowCount-1][k]; //�����һ�и�ֵdp[]���г�ʼ��
		}
		
		for(int k=rowCount-2;k>=0;k--) {
			//�б��ж�1
			for(int j=0;j<k+1;j++) {
				dp[j] = triangle[k][j]+Math.max(dp[j], dp[j+1]); //�������һ�е�������� 
			}
		}
		return dp[0];
	}
}
