package ��ά�������;

import java.util.Arrays;

/*
 * 
 * �ٶ�ֻ��һ�У��Ǿͺ�������������һ��
 * ����޶����У����԰����а�����ͣ�Ȼ�����֮����һά��������������к�һ��
 * ����
 * �������ǴӰѵ�һ�е�����㣬�����ۼӺ����ÿһ�к󣬶���һ������������
 * �Եڶ�����Ϊ��㣬�����ۼӺ����ÿһ�к󣬶���һ������������
 *
 * ÿ��������ĺ�����ʷ���ֵ�Ƚϣ�������������
 */
public class �Ӿ�������� {
	public static void main(String[] args) {
		  int[][] matrix = {
			        {-90, 48, 78},
			    };
		  System.out.println(f(matrix));
	}
	
	public static int f(int[][] matrix) {
		int beginrow = 0;
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[] sums = new int[m];//��ÿ�а������
		
		int max = 0;//��ʷ����ĺ͵����ֵ
		
		while(beginrow<n) {
			
			//��beginrow�е�n�а������
			for(int i=beginrow;i<n;i++) {
				
				for(int j=0;j<m;j++) {
					sums[j]+=matrix[i][j];
				}
				
				//ÿ���𽥼�һ�����
				//�������һά�����������������͵ķ���
				int a = �������������ĺ�.f2(sums);
				if(a>max)
					max = a;
			}
			
			Arrays.fill(sums, 0);//�Ѽ�¼ÿ�а��������0
			beginrow++;
		}
		return max;
		
	}
}
