package ��̬�滮and̰��;

import java.util.Arrays;

/*
��n�������ͼ�ֵ�ֱ�Ϊwi��vi����Ʒ������Щ��Ʒ����ѡ��������������W����Ʒ����������ѡ�����м�ֵ�ܺ͵����ֵ��
    1��n��100
    1��wi��vi��100
    1��W��10000
���룺
    n=4
    (w,v)={(2,3),(1,2),(3,4),(2,2)}
    W=5

�����
    7��ѡ���0��1��3����Ʒ��
��Ϊ��ÿ����Ʒֻ��ѡ�Ͳ�ѡ���������������������Ϊ01������
 */
public class ��������01 {
	 static int[] w = {2, 1, 3, 2};//������
	  static int[] v = {3, 2, 4, 2};//��ֵ��
	  static int n = 4;//��Ʒ����
	  static int W = 5;//�����ĳ��ؼ���
	  static int[][] dp = new int[n+1][W+1];
	  
	  static int[][] res;
	public static void main(String[] args) {
		System.out.println(dfs(0,W));
		
		res = new int[n][W+1];
		//������ȫ����ʼ��Ϊ-1
		for(int i=0;i<n;i++) {
			Arrays.fill(res[i], -1);
		}
		
		System.out.println(f1(0,W));
		
		System.out.println(dp());
		traceback(W,w);
	}
	
	
	//���ѵĸ��Ӷ�ΪO(2^n)
	//i��ʾ��ǰҪ��ѡ��ĵĵڼ�����Ʒ
	public static int dfs(int i,int ww) {
		
		//�߽�
		if(i==n) {
			return 0; //û����Ʒ���Լ���ѡ��
		}
		
		if(ww<=0) {
			return 0; //ѡ���˻��߳�����
		}
		
		
		int v2 = dfs(i+1,ww);//��ѡ��ǰ��Ʒ
		
		//ѡ��ǰ��Ʒ ����Ҫ�жϻ᲻�ᳬ��������
		if(ww>=w[i]) {
			int v1 = v[i]+dfs(i+1,ww-w[i]);//ע��w[i]��v[i]������ ��д����
			return Math.max(v1, v2);
		}else
			return v2;
	}
	
	
	//�����͵ݹ�  ���Ա���һЩ�ظ�����  ��dfs�����ݹ���ʱ�����Է��ֻ���Щ״̬���ظ�����ģ���ô���ǿ��Խ�ÿһ�εļ����¼����
	//��ÿһ�μ���һ����״̬ʱ������֮ǰ��û�м�������еĻ��;�ֱ���ã�����Ҫ�ظ�������
	public static int f1(int i,int ww) {
		//�߽�
		if(i==n) {
			return 0; //û����Ʒ���Լ���ѡ��
		}
		
		if(ww<=0) {
			return 0; //ѡ���˻��߳�����
		}
		
		//����ǰ�Ȳ�ѯ֮ǰ��û�������������
		if(res[i][ww]>=0) //һ��ʼ������ȫ����ʼ��Ϊ-1  ��Ϊ��Щ����Ϊ0
			return res[i][ww];
		
		
		int v2 = dfs(i+1,ww);//��ѡ��ǰ��Ʒ
		
		int ans;
		
		//ѡ��ǰ��Ʒ ����Ҫ�жϻ᲻�ᳬ��������
		if(ww>=w[i]) {
			int v1 = v[i]+dfs(i+1,ww-w[i]);//ע��w[i]��v[i]������ ��д����
			ans = Math.max(v1, v2);
		}else
			ans = v2;
		
		//������¼������
		res[i][ww] = ans;
		return ans;
	}
	
	
	//dp ���ķ�����  dp[i][j]��ʾ ����ѡǰi����Ʒ�������  ������Ϊj  ������j��ѡ������ֵ
	public static int dp() {
		
		//��ʼ����ĵ�һ��  ��һ��ֻ��ѡ��һ����Ʒ ����j>=w[0]������� �Ϳ��Խ�w[0]��ֵ��dp[0][j]
		for(int j=1;j<W+1;j++) {
			if(j>=w[0])//���ø���Ʒ
				dp[1][j] = v[0]; //�ֽ�w[0]��v[0]д����
			/*else
				dp[0][i] = 0;        ���鱾����ʼ����Ϊ0*/
		}
		
		//��ĵ�һ��  ������Ϊ0  ���Զ�Ϊ0 
		
		//������
		for(int i=2;i<=n;i++) {
			
			//j��ʾ�� ����������
			for(int j=1;j<=W;j++) {
				
				//Ҫ�������Ʒ������� ��Ҫ��Ҫ�Ͳ�Ҫ
				if(j>=w[i-1]) {
					int i1 = v[i-1]+dp[i-1][j-w[i-1]];//ѡ��ǰ��Ʒ�� �ټ��� ʣ������������� ��ѡǰi-1����Ʒ������ֵ
					int i2 = dp[i-1][j];//���ø���Ʒ ��ô�͵���������i-1�� ������Ϊj������µ�����ֵ
					dp[i][j] = Math.max(i1, i2);
				}else {
					//���������ø���Ʒ
					dp[i][j] = dp[i-1][j]; //��ô�Ϳ�ѡǰi-1��
				}
				
			}
		}
		
		return dp[n][W]; //��󷵻� ����ѡǰn-1���������  ������Ϊ5������ֵ��Ҳ������Ŀ����˼
		
	}
	
	public static void traceback(int C,int[] W) {
		for(int i=n;i>=1;i--) {
			if(dp[i][C]==dp[i-1][C])
				continue;
			else {
				System.out.println("���˵�"+i+"������");//��ӡ���˵ڼ�������
				C -= w[i-1];
			}
		}
	}
}
