package һЩ��ѧ����;

public class �������� {
	public static void main(String[] args) {
		f1(100002);
	}
	
	public static boolean isPrime(long a) {
		
		//С�ڸ���a== i��ƽ��С��a
		for(int i=2;i*i<a;i++) {
			if(a%i==0)
				return false;
		}
		return true;
	}
	
	
	//���100000������ 
	//��n������  ��һ����Ϊ�����ĸ���Ϊ 1/logn   ��ôn������ �����logn������
	//���Ը��������������ܰ�����100000��������n�ķ�Χ
	public static void f1(int a) {//aΪҪ��ڼ�������
		
		//�����n�ķ�Χ
		int n = 2;//���ķ�Χ
		while(n/Math.log(n)<a) {
			n++;
		}
		
		//ɸѡ��  ��ֵ��2��ʼ������2�� 3�� 4��.....����Щ�������Ϊ-1����������
		//����һ�����飬�±�����Ȼ����ֵ�Ǳ��
	    //����˼·��ɸѡ�����ѷ�������ǳ���
		int[] arr = new int[n];
		int i = 2;
		while(i<n) {
			
			//��ǹ��� ����һ��
			if(arr[i]!=0) {
				i++;
				continue;
			}
			
			int k = 2;//���Ʊ���
			while(i*k<n) {
				arr[i*k] = -1;
				k++;//��������
			}
			i++;
		}
		
		int sum = 0;
		for(int j=0;j<arr.length;j++) {
			if(arr[j]==0)
				sum++;
			
			if(sum==a) {
				System.out.println(j);
				return;
			}
		}
	}
}
