import java.util.Scanner;

//������ģ��������
/*
 * ����1*2*3*4=24 ��ô������a[0]=4 a[1]=2   //����������װ������ 
 * 24*5 = 120  ��ô����a[0]*5 = 20 a[1]*5=10  //ÿһλֻ����0-9
 * ������Ҫ��λ  ��ô����a[0]=20%10=0  a[1]=a[1]+a[0]/10=12 a[1] = a[1]%10=2  a[2] = a[2]+a[1]/10 =1  
 * �ͱ��120��  
 * �ؼ����ڶԽ�λ�Ŀ��� 
 */
public class ��ȷ�׳�1000 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			int n = cin.nextInt();
			f(n);
		}
	}
	public static void f(int n) {
		if(n==0||n==1) {
			System.out.println(1);
			return;
		}
		
		int[] arr = new int[3000];//ȡһ������������1000����λ��
		arr[0] = 1;//����һλ��ֵΪ0  ����ʹ�X2��ʼ
		int length = 1;//������¼һ���ж���λ��
		int wei = 0;//��ʾ��ǰλ�����λ������
		int j;
		for(int i=2;i<=n;i++) {
			
			//ÿ��arr[j]��Ҫ*i
			for(j=0;j<length;j++) {
				arr[j]=arr[j]*i+wei;//*i��Ҫ����ǰ��һλ������
				wei = arr[j]/10;//���λ��������
				arr[j] = arr[j]%10;//ÿ��λֻ����0-9
			}
			// ���arr[length-1]/10����Ҫ���λ��������=0����ô�ͱ�ʾ����Ҫ��������λ
			while(wei>0) {
				//��Ϊj��==length������ѭ����������ʱj�Ѿ��ǽ����µ�һλ��
				//��Ϊarr[j-1]λ���Ѿ�ĥ��10�ģ��������︳ֵ��ǰ��һλ������
				arr[j]=wei%10;
				wei/=10;
				j++;//�±�ҲҪ���� ������λ��������Ϊ0��Ҫ�������µĸ�λ
			}
			
			//�����µĸ�λ����ô��Ҫ����length
			length = j;
		}
		
		//�������
		for(int i=length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}
