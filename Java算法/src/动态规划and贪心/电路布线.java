package ��̬�滮and̰��;

public class ��·���� {
	public static void main(String[] args) {
		int[] c = {0,8,7,4,2,5,1,9,3,10,6};//����Ϊ11  
		int n = 10;
		int[][] size = new int[n+1][n+1];//size[i][j]��ʾ�϶�1-i�¶�1-j�а�����Ŀ�������߷�ʽ һ���ж��������ཻ��
		MNS(c,n,size);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(size[i][j]+" ");
			}
			System.out.println();
		}
		
		int[] net = new int[size[n][n]];
		traceBack(c,n,net,size);	
		for(int i=0;i<net.length;i++) {
			System.out.print(net[i]+" ");// 9 7 5 3
		}
	}
	
	public static void MNS(int[] c,int n,int[][] size) {
		for(int j=0;j<c[1];j++)
			size[1][j] = 0;
		for(int j=c[1];j<=n;j++) {
			size[1][j] =1;
		}
		
		for(int i=2;i<n;i++) {//������n  ���һ��ʡȥһЩ����Ҫ�ļ�����
			for(int j=0;j<c[i];j++)
				size[i][j]=size[i-1][j]; //j<c[i]ʱ ��ʾ��ǰi,c[i]��û���� ���Ը�ֵsize[i-1][j]��ֵ
			for(int j=c[i];j<=n;j++) {
				//��������ʱ  
				//���жϵ����ϵ�ǰ�������ټ���ǰ1:i-1��1��c[i]-1������ཻ��
				//�Ͳ�Ҫ��ǰ������ ǰ1:i-1��1��j������ཻǰ
				//˭��ֵ�Ƚϴ�
				size[i][j] = Math.max(size[i-1][j], size[i-1][c[i]-1]+1);
			}
		}
		size[n][n] = Math.max(size[n-1][n], size[n-1][c[n]-1]+1);
	}
	
	public static void traceBack(int[] c,int n,int[] net,int[][] size) {
		int j=n;
		int m=0;
		for(int i=n;i>1;i--) {
			if(size[i][j]!=size[i-1][j]) {//������������ǰ����(n,c[n])������� ��ô�ͱ�ʾ��������������ཻ�Ӽ����һ��Ԫ��
				net[m++] = i;
				j=c[i]-1; // ��Ϊ������size[i-1][j]  ��ôsize[i][j]�϶����� size[i-1][c[i]-1]+1  ���+1�ʹ�����������ཻ���һ������
			}
			
		}
		//ǰ��ֻ���쵽��i=2 �������i=1��ô��i=0ʱȫΪ0 
		//���Ե����ж� ���j���ڵ���c[1] ��ô1 c[1]Ҳ�ǽ��һ��Ԫ��
		if(j>=c[1])
			net[m++]=1;
	}
}
