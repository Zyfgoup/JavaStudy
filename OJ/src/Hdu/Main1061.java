package Hdu;

import java.util.Scanner;

//n��n�η� �ĸ�λ����ʲô
public class Main1061 {
	public static void main(String[] args) {
		
//		String str = "sdasfsd";
//		String s = str.substring(4); //���±�4��ʼ�����	
//		System.out.println(s);
		
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		/*while(n-->0) {
			int a = cin.nextInt();
			int temp = (int)Math.pow(a, a);
			String str = Integer.toString(temp);
			System.out.println(str.substring(str.length()-1));
		}
		
		*����  ��������n���ܴܺ�
		*/
	

		
		//�������
	
//		for(int i=1;i<50;i++) {
//			int sum =1;
//			for(int j=1;j<=i;j++) {
//				sum*=i;
//				if(sum>10)
//					sum%=10;
//			}
//			System.out.print(sum);
//			
//		}
		//���Է���1476563690163656749014765636901636567490147656369
		//ÿ20�ظ�һ��
		while(n-->0) {
			int a[]= {1,4,7,6,5,6,3,6,9,0,1,6,3,6,5,6,7,4,9,0};
			int b=cin.nextInt();
			int c = (b-1)%20;     //Ҫb-1 �����±��0��ʼ
			System.out.println(a[c]);
		}
		
		
//��������
//		1�����дη�����1
//		0�����дη�����0
//		5�����дη�����5
//		6�����дη�����6
//		2^1=2 2^2=4 2^3=8 2^4=6(�ĸ�һѭ��)
//		3^1=3 3^2=9 3^3=7 3^4=1(�ĸ�һѭ��)
//		7^1=7 7^2=9 7^3=3 7^4=1(�ĸ�һѭ��)
//		4^1=4 4^2=6(����һѭ��)
//		8^1=8 8^2=4(����һѭ��)
//		9^1=9 9^2=1(����һѭ��)
		//�պó���һ��ѭ������Ϊ0 �±��ӦΪ0  ���Է����±�Ϊ0��λ��
//		int a[][] = {{0},{1},{6,2,4,8},{1,3,9,7},{6,4},{5},{6},{1,7,9,3,},{6,8,4,2},{1,9}};
//
//		while(n-->0) {
//			int b= cin.nextInt();
//			int c=b%10;
//			if(c==0||c==1||c==5||c==6) {
//				System.out.println(c);
//			}else if(c==4||c==9)
//				System.out.println(a[c][b&2]);
//			else
//				System.out.println(a[c][b%4]);
//		}
		
		
		//�����ģ�����������
//		while(n-->0) {
//			int a=cin.nextInt();
//			System.out.println(PowerMod(a, a, 10));
//		}
//
//	}
//	public static long PowerMod(int a, int b, int c)
//	{  
//	    long  ans = 1; 
//	    a = a % c; 
//	    while(b>0) {  
//	        if(b % 2 == 1) 
//	            ans = (ans * a) % c; 
//	        b = b/2;      //���ǳ���2  �����ż�������ڶ���bΪ1  Ȼ��ans���ǻ�仯
//	        a = (a * a) % c; 
//	    } 
//	    return ans; 
	}
}
