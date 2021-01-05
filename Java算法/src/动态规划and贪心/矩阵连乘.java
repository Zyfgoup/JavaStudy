package ��̬�滮and̰��;

public class �������� {
	static int[] p= {30,35,15,5,10,20,25};//p[0]��һ��������� p[1]...p[6]�ֱ��ǵ�i��������� ��ôp[i-1]���ǵ�i���������
	public static void main(String[] args) {
		int[][] m = new int[p.length][p.length];
		int[][] s = new int[p.length][p.length];
		int n = 6;
		int r = matrixChain(p, n, m, s);
		System.out.println(r);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(m[i][j]+" ");
			}
		System.out.println();
		}
		
		traceBack(s,1,6);
//		Multiply A2,2 and A3,3
//		Multiply A1,1 and A2,3
//		Multiply A4,4 and A5,5
//		Multiply A4,5 and A6,6
//		Multiply A1,3 and A4,6
	}
	
	public static int matrixChain(int[] p,int n, int[][] m,int[][] s) {
		for(int i=1;i<=n;i++)m[i][i] = 0;
		for(int r=2;r<=n;r++) {//��ģ��С����
			for(int i=1;i<=n-r+1;i++) {//�ӵ�һ����ʼ ÿ�ζ�ȡ����Ϊr�ľ��������м���
				int j = i+r-1;//��߽�
				
				m[i][j] = m[i+1][j]+p[i-1]*p[i]*p[j];//��ʼ�� ���Կ����ǵ�һ������ ���������  m[i][i] = 0
				s[i][j] = i;//��ʾ��i���Ͽ�
				
				for(int k=i+1;k<j;k++) {
					int t = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(t<m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
		return m[1][n];
	}
	
	public static void traceBack(int[][] s,int i,int j) {
		if(i==j)
			return;
		traceBack(s,i,s[i][j]);
		traceBack(s,s[i][j]+1,j);
		System.out.print("Multiply A"+i+","+s[i][j]);
		System.out.println(" and A"+(s[i][j]+1)+","+j);
	}
}
