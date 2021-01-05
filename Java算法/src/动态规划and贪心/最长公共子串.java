package ��̬�滮and̰��;
/*
 * ���������ַ�������󹫹��Ӵ���Longest Common Substring���ĳ��ȣ��ַ������ִ�Сд��
 */


/*
 * �㷨˼����ʵ����������в��  ֻ���������в���Ҫ����  ���Ӵ�Ҫ����
 * ��ΪҪ���������Ե�x[i-1]!=y[j-1]ʱ dp[i][j]=0
 * ��������һ����
 * 
 * ���Ҫ�����Ӵ� ��ô�ͼ�¼maxֵ  �� i��j����
 * ��Ϊ��s1[i-1] s1[i-2] .... s[i-max] �����ַ����� ��ת�������
 */
public class ������Ӵ� {
	public static void main(String[] args) {
		String s1 = "CADJH";
		String s2 = "ACDJHCADJADJHCADJ";
		System.out.println(f1(s1,s2));//5
	}
	
	

	//��Ϊÿһ�ж�ֻ����һ���й�ϵ ���Կ�����һλ�������洢���
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
				/*else   ����û�и�ֵ��Ĭ��Ϊ0  ����ʡ�Բ�д�������
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
