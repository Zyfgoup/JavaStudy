package dfs;

public class n�ʺ�Գ��Ż� {
	 static int n;
	static int cnt;//�����ж����ַŷ�
	static int[] rec;
	public static void main(String[] args) {
		  	n = 5;
		    rec = new int[n];
		    dfs(0,(n+1)/2); //ע���±��Ǵ�0��ʼ
		    System.out.println(cnt*2);
	}
	
	
	//������ ��Ϊÿһ��ֻ����һ��   rec[row] = ������ʾ���еĻʺ���ڵڼ���  ���� rec[0]=1 ��ʾ��1�еĻʺ���ڵ�2��
	//y��ʾ���������ı߽�� ֻ�ܷŵ�1�е���y-1�� ��Ϊforѭ����С�� <y
	public static void dfs(int row,int y) {
		if(row==n) {
			cnt++;//���˱߽� ��++
			return;//return ��������������
		}
		
		//���γ��԰ѻʺ���ڱ߽��ÿһ��
		for(int col=0;col<y;col++) { //<y  һ��ʼд��<=y ��ô������nʱ�ͻ���� col = n�������
			if(check(row,col)) {
				rec[row] = col; //��ʾrow���еĻʺ����col��
				
				//������Ϊ����ʱ����һ�еĻʺ�����м�λ��ʱ �ڶ��еĻʺ��������������� 
				if(n%2!=0 && row==0 && col==(n+1)/2-1)  //Ҫ-1����Ϊ�±��0��ʼ
					dfs(row+1,(n+1)/2-1); 
				else
					dfs(row+1,n); //����ڶ��п�ʼ���Է����κ�һ��
				
				
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
