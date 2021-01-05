package 一些数学问题;

public class 素数问题 {
	public static void main(String[] args) {
		f1(100002);
	}
	
	public static boolean isPrime(long a) {
		
		//小于根号a== i的平方小于a
		for(int i=2;i*i<a;i++) {
			if(a%i==0)
				return false;
		}
		return true;
	}
	
	
	//求第100000个素数 
	//从n个数中  抽一个数为素数的概率为 1/logn   那么n个数中 大概有logn个素数
	//所以根据这个可以求出能包含有100000个素数的n的范围
	public static void f1(int a) {//a为要求第几个素数
		
		//先求出n的范围
		int n = 2;//数的范围
		while(n/Math.log(n)<a) {
			n++;
		}
		
		//筛选法  把值从2开始的数的2倍 3倍 4倍.....的这些数都标记为-1则不是素数了
		//开辟一个数组，下标是自然数，值是标记
	    //基本思路是筛选法，把非素数标记出来
		int[] arr = new int[n];
		int i = 2;
		while(i<n) {
			
			//标记过了 就下一个
			if(arr[i]!=0) {
				i++;
				continue;
			}
			
			int k = 2;//控制倍数
			while(i*k<n) {
				arr[i*k] = -1;
				k++;//倍数增加
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
