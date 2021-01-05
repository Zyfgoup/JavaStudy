package dfs;
/*
 * �����һ���㷨�����������n�ʺ����⡣�����n�ʺ�����ָ��һ��n*n�������Ϸ���n�����ӣ�
 * ʹ��ÿ��ÿ�к�ÿ���Խ����϶�ֻ��һ�����ӣ�����ڷŵķ�������

 ����һ��int n���뷵�ط���������֤nС�ڵ���15
 */
public class n�ʺ����� {
	static int n;
	static int cnt;//�����ж����ַŷ�
	static int[] rec;
	public static void main(String[] args) {
		  	n = 5;
		    rec = new int[n];
		    dfs(0);
		    System.out.println(cnt);
	}
	
	
	//������ ��Ϊÿһ��ֻ����һ��   rec[row] = ������ʾ���еĻʺ���ڵڼ���  ���� rec[0]=1 ��ʾ��1�еĻʺ���ڵ�2��
	public static void dfs(int row) {
		if(row==n) {
			cnt++;//���˱߽� ��++
			return;//return ��������������
		}
		
		//���γ��԰ѻʺ����ÿһ��
		for(int col=0;col<n;col++) {
			if(check(row,col)) {
				rec[row] = col; //��ʾrow���еĻʺ����col��
				dfs(row+1);//����֮��ͽ�����һ��
				
				rec[row] = 0; //����Ų���ȥ ��ô��Ҫ����Ϊ0 Ȼ�����forѭ�����߷�����һ�����
				//������ʵ������Ҳ���� �����������Ϊ���ü����  ���Բ�����Ϊ0Ҳû�й�ϵ
				
			}
		}
	}

	//��������û�лʺ� �������Խ�����û�лʺ�
	//����Ҫ�������û�лʺ���Ϊ�Ǵӵ�һ�п�ʼ�������ѷţ���ô�µ�һ�п϶���û�ŵ�
	//��������Խ��߿��Ի���һ��3X3��ͼ�ɷ��� ���Խ�������зŻʺ� ��ô��������������϶��뱾��Ҫ�ŵ����i-rec[i] = row-col
	//������Խ��ߵ�ĳ��λ�÷��˻ʺ� ��ô������ӿ϶���� i+rec[i] = row+col;
	private static boolean check(int row, int col) {
		//�ӵ�0��鵽row-1  ��Ϊrow�ʹ���row�������϶����ǻ�û�лʺ�� ����ֻ��Ҫ�����ǰ���ÿһ����û�ŵ�ͬһ���еĻʺ�
		for(int i=0;i<row;i++) {
			if(rec[i]==col||i+rec[i]==row+col||i-rec[i]==row-col)
				return false;
		}
		return true;
	}
}
