package ��̬�滮and̰��;

public class ��������01�㷨ʵ�� {
	public static void main(String[] args) {
		int n = 5;
		int C = 20;
		int[] w = {0,6,4,8,8,4};
		int[] v1 = {0,8,4,8,10,2};
		int[][] v = new int[n+1][C+1];
		System.out.println(dp(v,w,v1,C,n));
		traceBack(C,w,n,v);
	}
	
	public static int dp(int[][] v,int[] w,int[] v1,int C,int n) {
		//��ʼ����ĵ�һ��  ��һ��ֻ��ѡ��һ����Ʒ ����j>=w[1]������� �Ϳ��Խ�v[1]��ֵ��v[1][j]
		for(int j=1;j<=C;j++) {
			if(j>=w[1])//���ø���Ʒ
				v[1][j] = v1[1];
			/*else
				dp[0][i] = 0;        ���鱾����ʼ����Ϊ0*/
		}
		//������
		for(int i=2;i<=n;i++) {
			//j��ʾ�� ���������
			for(int j=1;j<=C;j++) {
				
				//��ȡ������������ ��Ҫ��Ҫ�Ͳ�Ҫ
				if(j>=w[i]) {
					int i1 = v1[i]+v[i-1][j-w[i]];//ѡ��ǰ����� �ټ��� ʣ������������� ��ѡǰi-1����Ʒ�����Ч��
					int i2 = v[i-1][j];//���ø���Ʒ ��ô�͵���������i-1�� ������Ϊj������µ����Ч��
					v[i][j] = Math.max(i1, i2);//ȡ�����е����ֵ
				}else {
					//���������ø�����
					v[i][j] = v[i-1][j]; //��ô�Ϳ�ѡǰi-1��������������
				}
				
			}
		}
		
		return v[n][C]; //��󷵻� ����ѡǰn������������  ������ΪC�����Ч��
	}
	
	public static void traceBack(int C,int[] w,int n,int[][] v) {
		for(int i=n;i>=1;i--) {//������濪ʼ������
			if(v[i][C]==v[i-1][C]) //���û��ֵ��ȱ�ʾû��ȡ��i��������ô�ͼ���ѭ��
				continue;
			else { //ȡ�˸�����
				System.out.println("���˵�"+i+"������");//��ӡȡ�˵ڼ�������
				C -= w[i]; //�����Ҫ��ȥ��i�����������
			}
		}
	}
}
