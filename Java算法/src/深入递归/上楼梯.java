package 深入递归;
/*
有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
请实现一个方法，计算小孩有多少种上楼的方式。
为了防止溢出，请将结果Mod 1000000007

给定一个正整数int n，请返回一个数，代表上楼的方式数。
保证n小于等于100000。

核心都是逐步生成结果     
递归的话就是自下而上的从一般情况推广到复杂情况，然后再写成递归看起来是从自上而下的求解 但是底层还是自下而上一层一层往上返回结果
递推迭代 就是很能直观体现逐步生成结果的过程
*/


public class 上楼梯 {
	static final int mod = 1000000007;
	public static void main(String[] args) {
		System.out.println(f1(5));
	}
	
	/*
	 * 当只有一阶台阶的时候 只有一种走法
	 * 有两阶的时候 有 2种
	 * 有三阶的时候 有4种
	 * 当有四阶的时候 有7种 = 1+2+4
	 * 可以这样想  当有四阶的时候  如果踏一阶 剩下三阶 那么三阶一共有4种走法
	 * 如果踏二阶 剩下二阶有2种走法 
	 * 如果踏三阶 剩下一阶有1种走法
	 * 所以第n阶有多少种走法 就是等于 f(n-1)+f(n-2)+f(n-3)  
	 * 
	 */
	
	//递归求解
	public static int f1(int n) {
		if(n==0||n==1)
			return 1;
		if(n==2)
			return 2;
		/*if(n==3)
			return 4;
			可写可不写 因为当有三阶的时候 计算分f(0)+f(1)+f(2)
			如果不写 那么n==0也要返回1*/

		return f1(n-1)%mod+f1(n-2)%mod+f1(n-3)%mod;
	}
	
	//递推 迭代的方式  因为用递归如果递归层数太深的话很容易造成栈内存溢出
	public static int f2(int n) {
		if(n<0)
			return 0;
		if(n==1||n==0)
			return 1;
		if(n==2)
			return 2;
		
		//这里用递推如果n==3直接判断返回 所以要写
		if(n==3)
			return 4;
		
		int x1=1;
		int x2=2;
		int x3=4;
		for(int i=4;i<=n;i++) {
			int temp = x1;
			x1 = x2%mod;
			x2 = x3%mod;
			x3 = ((x1+x2)%mod+temp)%mod;//  (a + b) % p = (a % p + b % p) % p
			//x1 x2取模了 所以这里要先加起来再取模保持取模不变
		}
		return x3;
	}
	
}
