package ��̬�滮and̰��;
/**
 * ��Ʒ�������� ������һ����Ʒ�����ظ�ȡ��
 * ��ȫ��������
 * �����ڳ�ʼ�����һ�е�ʱ��������ͬ����ʼ��ʱ����ֻ����һ����Ʒaʱ��state[row][j] = values[row]*j/weight[row]
 * Ȼ���ڵ��Ƶ�ʱ����Щ��ͬ��state[row][j] = max{state[row+1][j],state[row][j-weight[row]]+values[row]}������ץʱ�����ڵ�����ȥƥ��������
 * Ҫץ��ʱ����ץ�������Ʒ�ļ�ֵ��Ȼ����ʣ�µ�����ȥƥ��ͬһ�У�Ϊʲôƥ��ͬһ�У�������Ϊʣ�µ����������ظ�ץ��ǰ��Ʒ������������
 *
 * ͬʱ������⣬ץһ��֮����ʣ����������¿��ǵ�ǰ��ѡ��������Ʒ��ʵ������ץ2��������������������
 */
public class ��ȫ�������� {
	
	  static int[] values = {9, 5, 3, 1};
	  static int[] weights = {7, 4, 3, 2};
	  static int n = 4;
	  static int total = 10;
	  static int[][] state = new int[n][total + 1];//��ͬ����Ʒ��Χ�²�ͬ��������װ����������ֵ
	  
	public static void main(String[] args) {
		
	}
	
	public static int dp() {
		int row = 0;
		int v=1;
		int w = weights[row];
		for(;v<total+1;v++) {
			state[0][v] = values[row]*(v/w); //�Ե�һ�г�ʼ�� v/w��ʾ����װ������һ����Ʒ
		}
		
		
		for(int i=1;i<n;i++) {
			w = weights[i];
			
			for(int j=1;j<total+1;j++) {//j��ʾΪ��ǰ��װ��������
				
				
				if(j>=w) {//��װ�������
					//Ҫץ  ����ץ�ظ��� һ��ʼ�뵽��forѭ����
					//����Ҫ֪��ץ��һ��֮�� �ܷ����ץ�ͱ����state[i][j-w]״̬��������
					//���Բ���Ҫ��forѭ��������ץ�����ظ�
					
					int v1 = values[i]+state[i][j-w];  //ץ��һ���� ������ǰ�� ��j-w ��ʵ�Ѿ������˿���ץ���ٴ��ظ���
					//Ҫ������state[][]��ʾʲô����
					
					//��ץ
					int v2 = state[i-1][j];
					
					state[i][j] = Math.max(v1, v2);
				}else {
					//����װ�������
					state[i][j] = state[i-1][j];
				}
			}
		}
		return state[n-1][total];
	}
}
