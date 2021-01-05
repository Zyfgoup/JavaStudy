package �ݹ���һЩ����Ŀ;

public class ���һ����Ч����a��n���ݵ��㷨 {
	public static void main(String[] args) {
		System.out.println(f(2,3));
	}
	
	public static int  f(int a,int n) {
		int sum=1;
		if(n==0)
			return 1;
		if(n==1)
			return a;
		
		//O(n)
//		for(int i=0;i<n;i++) {
//			sum*=a;
//		}
		
		//O(logn)
		while(n>1) {
			if(n%2!=0)
				sum*=a;
			a*=a;
			n/=2;
		}
		return sum*a;
	}
}
