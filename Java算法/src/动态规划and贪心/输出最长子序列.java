package ��̬�滮and̰��;

import java.util.Set;
import java.util.TreeSet;

/*
 * ����������
 * �㷨�ο���https://blog.csdn.net/lisonglisonglisong/article/details/41596309
 * 
 * 
 *��dp[i][j] ��Ӧ��x[i-1]==y[j-1] ��ô��x[i-1]��ӽ��ַ��� Ȼ������dp[i-1][j-1]���������ж�
 *�������ȣ����ж� dp[i-1][j] �� dp[i][j-1]˭�� ������������������ж� ������������ ��Ҫ���м����ж�(�ݹ�)
 */
public class ���������� {
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
		//��һ�е�һ�ж���0 �����ʼ����Ϊ0  ����û��Ҫ�ٳ�ʼ����
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
	
	//������������� �Ž�set
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
				else {//��ȵ����
					traceBack(s1,s2,i-1,j,str);
					traceBack(s1,s2,i,j-1,str);
					return;

				}
			}
		}
			set.add(new StringBuffer(str).reverse().toString());
	}
}
