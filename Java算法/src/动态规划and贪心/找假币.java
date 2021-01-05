package 动态规划and贪心;

public class 找假币 {
	public static void main(String[] args) {
		System.out.println(checkFaker(9));
	}
	
	public static int checkFaker(int n) {
		int[] a = new int[n+1]; //长度+1 方便表示
		if(n==1)
			return 0; // n==1 不需要测试
		if(n==2)
			return 1; // n==2 测试一次
		if(n==3)
			return 1; // n==3 测试一次
		if(n>3) {
			a[1]=0;
			a[2]=1;
			a[3]=1;
			for(int i=4;i<=n;i++) {
				if(i%2==0)  //为偶数 则 平分n放在两端 含有假币的一侧轻  问题变成(1+ n/2个硬币最少使用天平找出假币)
					a[i] = a[i/2]+1;
				else    //为奇数  则与前一个一样的测试次数
					a[i] = a[i-1];
			}
			return a[n];  //返回n个硬币的最少测试次数
		}
		return -1; //表示不符合题目要求
	}
}
