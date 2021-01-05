package ��̬�滮and̰��;

public class ����������� {
	static int[] arr = {4, 2, 3, 1, 5, 6, 4, 8, 5, 9};  // 6
	public static void main(String[] args) {

	    System.out.println(dp(arr)); 

	}
	
	//O(nlogn) ���Ǻܶ�
	public static int dp1(int[] arr) {
		int[] dp = new int[arr.length+1];
		dp[1] = arr[0]; // ����Ϊ1�ĵ��������� ��ʼ��Ϊ��һ��Ԫ��
		int p = 1;//��¼ dp����浽�ĸ�λ������
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>dp[p]) {
				dp[p++] = arr[i];
			}else {
				//ɨ��dp���飬��arr[i]���ڵ�һ������arr[i]��λ�� ע���Ǹ��ǵ� ��������
				for(int j=1;j<=p;j++) {
					if(dp[j]>arr[i]) {
						dp[j] = arr[i];
						break;
					}
				}
			}
		}
		return p;//�±�Ϊ��ĵ���������
	}
	
	
	//O(n^2)
	private static int dp(int[] arr) {
		int[] dp = new int[arr.length];  //dp[i]��ʾ��arr[0]��arr[i]���λ�õ��������
		
		dp[0] = 1;//����Ҳ������������  ����Ϊ1
		
		for(int i=1;i<arr.length;i++) {
			int cnt =1;
			
			//�Ƚϴ�0��i-1���Ƿ�С��arr[i] �������ô��Ϊ���������� 
			//��ô����dp[i] = dp[j]+1 
			//����Ҫ��� ������max
			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j]) {
					cnt = Math.max(cnt,dp[j]+1);
				}
			}
			//��dp[i]��ֵ��������г���
			dp[i] = cnt;
		}
		
		
		//����dp���� ȡ����
		int ans = 0;
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>ans)
				ans = dp[i];
		}
		return ans;
	}

}
