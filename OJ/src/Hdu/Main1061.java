package Hdu;

import java.util.Scanner;

//n的n次方 的个位数是什么
public class Main1061 {
	public static void main(String[] args) {
		
//		String str = "sdasfsd";
//		String s = str.substring(4); //从下边4开始到最后	
//		System.out.println(s);
		
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		/*while(n-->0) {
			int a = cin.nextInt();
			int temp = (int)Math.pow(a, a);
			String str = Integer.toString(temp);
			System.out.println(str.substring(str.length()-1));
		}
		
		*最常规的  但是这里n可能很大
		*/
	

		
		//暴力打表
	
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
		//可以发现1476563690163656749014765636901636567490147656369
		//每20重复一次
		while(n-->0) {
			int a[]= {1,4,7,6,5,6,3,6,9,0,1,6,3,6,5,6,7,4,9,0};
			int b=cin.nextInt();
			int c = (b-1)%20;     //要b-1 数组下标从0开始
			System.out.println(a[c]);
		}
		
		
//方法三：
//		1的所有次方都是1
//		0的所有次方都是0
//		5的所有次方都是5
//		6的所有次方都是6
//		2^1=2 2^2=4 2^3=8 2^4=6(四个一循环)
//		3^1=3 3^2=9 3^3=7 3^4=1(四个一循环)
//		7^1=7 7^2=9 7^3=3 7^4=1(四个一循环)
//		4^1=4 4^2=6(两个一循环)
//		8^1=8 8^2=4(两个一循环)
//		9^1=9 9^2=1(两个一循环)
		//刚好除尽一个循环余数为0 下标对应为0  所以放在下边为0的位置
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
		
		
		//方法四：快速幂运算
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
//	        b = b/2;      //这是除于2  如果是偶数倒数第二次b为1  然后ans还是会变化
//	        a = (a * a) % c; 
//	    } 
//	    return ans; 
	}
}
