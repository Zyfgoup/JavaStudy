package ��̬�滮and̰��;

public class �Ҽٱ� {
	public static void main(String[] args) {
		System.out.println(checkFaker(9));
	}
	
	public static int checkFaker(int n) {
		int[] a = new int[n+1]; //����+1 �����ʾ
		if(n==1)
			return 0; // n==1 ����Ҫ����
		if(n==2)
			return 1; // n==2 ����һ��
		if(n==3)
			return 1; // n==3 ����һ��
		if(n>3) {
			a[1]=0;
			a[2]=1;
			a[3]=1;
			for(int i=4;i<=n;i++) {
				if(i%2==0)  //Ϊż�� �� ƽ��n�������� ���мٱҵ�һ����  ������(1+ n/2��Ӳ������ʹ����ƽ�ҳ��ٱ�)
					a[i] = a[i/2]+1;
				else    //Ϊ����  ����ǰһ��һ���Ĳ��Դ���
					a[i] = a[i-1];
			}
			return a[n];  //����n��Ӳ�ҵ����ٲ��Դ���
		}
		return -1; //��ʾ��������ĿҪ��
	}
}
