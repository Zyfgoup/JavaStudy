package ��ά�������;
/*
 * ����һ��N*N�ľ��������������ֻ��0��1�����ر߿�ȫ��1����������εĵı߳�����
 *   {0, 1, 1, 1, 1},
	 {0, 1, 0, 0, 1},
	 {0, 1, 0, 0, 1},
	 {0, 1, 1, 1, 1},
	 {0, 1, 0, 1, 1}��
 �������У��߿�ȫ��1����������εĴ�С��4*4������4
 */
public class �߽�Ϊ1������ӷ��� {
	static int[][][] rec;
	public static void main(String[] args) {
	    int[][] A = {
	            {0, 1, 1, 1, 1},
	            {0, 1, 0, 1, 0},
	            {0, 1, 1, 1, 1},
	            {0, 1, 1, 1, 1},
	            {0, 1, 0, 1, 1}
	        };
	    //��������¼�Һ���
		helpRec(A);
		
		//��ӡ����
		print(rec,A.length);
		
		System.out.println(solve(A));
	}
	
	//���������ⷨ
	//�����׿�ʼ����������ÿ��Ԫ�ص�Ϊ���������ϽǶ����n�׾����Ƿ�߿�ȫΪ1
	//��i+n>N�������Ѿ���������������n�׵ı߿�Ϊ1 �ľ�����
	//��j+n>Nͬ��Ҳ�Ǳ�������ĳ�е�����Ѿ���������Ϊn�ױ߿�Ϊ1�ľ�����
	public static int f1(int[][] matrix) {
		int N = matrix.length;
		int n = N;
		while(n>0) {
			for(int i=0;i<N;i++) {
				if(i+n>N)
					break;
				l3:for(int j=0;j<N;j++) {
					if(j+n>N)
						break;
					
					//����ĸ���
					int r = i;
					int c = j;
					
					//�����
					while(c<j+n) {
						if(matrix[r][c++]==0)
							continue l3;//����ָ��ѭ���м���ѭ��
					}
					c--;//c��ѭ����=j+n�ָ�
					
					//�����
					while(r<i+n) {
						if(matrix[r++][c]==0)
							continue l3;
					}
					r--;
					
					//��
					while(c>=j) {
						if(matrix[r][c--]==0)
							continue l3;
					}
					c++;
					
					//��
					while(r>=i) {
						if(matrix[r--][c]==0)
							continue l3;
					}
					r++;
					
					return n;
				}
				
			}
			n--;
		}
		return n;
	}
	
	//�Ż�����  Ԥ����   �����ڶ�̬�滮���
	//��һ��������ά��������¼ÿ��Ԫ��λ�����ұߺ��±�1�ĸ���  �������� ���Ԫ��Ϊ0���Ͷ�Ϊ0
	
	
	//��Ȼ�Ǳ�������ÿ��Ԫ�أ�ֻ����ʱ��ÿ��Ԫ��ֻ��Ҫ�ж�4��������Һ��µ�1�Ƿ�����߿�ȫΪ1�ľ��󼴿�
	public static int solve(int[][] matrix) {
		int N = matrix.length;
		int n = N;
		while(n>0) {
			for(int i=0;i<N;i++) {
				if(i+n>N)
					break;
				for(int j=0;j<N;j++) {
					if(j+n>N)
						break;
					
					if(check(i,j,n))
						return n;
				}
			}
			n--;
		}
		return n;
	}
	
	private static boolean check(int i, int j, int n) {
		//���Ͻǵ��ұ�1������Ҫ>=n
		//���Ͻǵ��±�1������Ҫ>=n
		//���½ǵ��ұߵ�1������Ҫ>=n
		//���Ͻǵ��±ߵ�1������Ҫ>=n
		
		if(rec[i][j][0]>=n&&rec[i][j][1]>=n&&rec[i+n-1][j][0]>=n&&rec[i][j+n-1][1]>=n)
			return true;
		
		return false;
	}

	//��ӡ��¼��Ԫ�ص��Һ��µ�1�ĸ���
	public static void print(int[][][] rec,int N) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(rec[i][j][0]+","+rec[i][j][1]+"\t");
			}
			System.out.println();
		}
	}
	
	//��¼����ÿ��Ԫ�ص��Һ��µ�����1�ĸ��� ��������
	public static void helpRec(int[][] arr) {
		int n = arr.length;
		rec = new int[n][n][2];//��¼ÿ��Ԫ�ص��Һ���������1 ������2
		
		//�����һ�п�ʼ��¼
		int row = n-1;
		
		//�ȼ�¼���һ��
		for(int i=n-1;i>=0;i--) {
			int value = arr[row][i];
			if(value==1) {
				//��ΪҪi+1������ ���±�Խ�� �������һ�����һ��Ԫ�ص�������
				if(i==n-1)
					rec[row][i][0] = 1;
				
				//�����ұ�Ԫ�ص��ұ�1����������¼Ŀǰ��
				else 
					rec[row][i][0] = rec[row][i+1][0]+1;
				
				//��¼�����һ��ÿ��Ԫ���ұ�������1��ҲҪ��¼�µ�
				//��Ϊ�����һ���������������1�Ļ��Ͷ���1��
				rec[row][i][1]=1;
			}	
		}
		
		
		//���ϼ�¼������forѭ��  ����row--
		row--;
		for(int i=row;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				int value = arr[i][j];
				if(value==1) {
					//��ΪҪj+1������ ���±�Խ�� �������һ�����һ��Ԫ�ص�������
					if(j==n-1)
						rec[i][j][0] = 1;
					//�����ұ�Ԫ�ص��ұ�1����������¼Ŀǰ��
					else 
						rec[i][j][0] = rec[i][j+1][0]+1;
					
					//�·���1
					rec[i][j][1] = rec[i+1][j][1]+1;
				}	
			}
		}
	}
}
