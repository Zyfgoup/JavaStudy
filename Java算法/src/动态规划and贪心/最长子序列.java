package ��̬�滮and̰��;

import java.util.Set;

/* ������г��ȣ�
 * ��ϸ�㷨˼��ο���https://blog.csdn.net/lisonglisonglisong/article/details/41548557
 * 
 * 
X[1...m] = {A, B, C, B, D, A, B}
Y[1...n] = {B, D, C, A, B, A}
���Կ�����X �� Y ��������������� ��BDAB������BCAB������BCBA����������Ϊ4��
��������ֻ�豣�����˳�򣬲���Ҫ������
 */


/*��f(x,y,i,j)��ʾ�����ַ���������������У���i,j��ʼ��
 *  ��x[i]==y[j]ʱ  ��ô�Ϳ��Խ������ɴ�[2....m]��[2....n]�����ַ�������������ټ���1    1+f(x,y,i+1,y+1)
 *  ��x[i]!=y[j]ʱ����ô�Ϳ����� f(x,y,i+1,j)������f(x,y,i,j+1) ԭ��ͬ�� ���ֳ�������
 *  ��ΪҪ�����������  ��ô����max(f(x,y,i+1,j),f(x,y,i,j+1))
 *  �߽����� ����i, j����һ��Ϊ0�� 
 */

public class ������� {
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
	
	
	//�ݹ�ķ������  ����ʱ�临�Ӷ�ΪO(2^n)ָ�����������������ݹ������Է��ֻ���ֺܶ��ظ��ĵ��ã�
	//���Ծ��ж�̬�滮������֮һ��������ص������������
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
	
	//dp���  ͨ��һ����ά����������������Ľ���������ظ����� ���ÿռ任ʱ�� O(nm)
	//���� ������ û���Ⱥ�֮�� ������
	public static int LCS2(int[][] b) {
		
		//����Ϊ�ַ���+1
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		//��һ�е�һ�ж���0 �����ʼ����Ϊ0  ����û��Ҫ�ٳ�ʼ����
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//ע����õ�charAt()�����Ǵ�0��ʼ��  ���ﶼ�Ǵ�1��ʼ
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					b[i][j] = 1;//1��ʾ����б�Ϸ�����
				}else if(dp[i-1][j]>=dp[i][j-1]) {
					dp[i][j] = dp[i-1][j];
					b[i][j] = 2; //����һ��ͬ�л��
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
	
	//����������  ������һ�����
	public static void LCS(int[][] b,int i,int j) {
		
			
			
		if(i==0||j==0) 
			return;
		
		if(b[i][j]==1) {
			LCS(b,i-1,j-1);
			//ע����õ�charAt()�����Ǵ�0��ʼ��  ���ﶼ�Ǵ�1��ʼ
			System.out.print(s1.charAt(i-1));
		}else if(b[i][j]==2)
			LCS(b,i-1,j);
		else
			LCS(b,i,j-1);
	}

	
}
