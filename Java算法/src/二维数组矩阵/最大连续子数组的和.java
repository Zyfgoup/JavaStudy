package 二维数组矩阵;
/*
 * 求一个数组的连续子数组的和最大(一个数也可以是最大)
 */
public class 最大连续子数组的和 {

	public static void main(String[] args) {
		int[] arr = {1,-2,3,5,-2,6,-1,3};
		System.out.println(f2(arr));
	}
	
	//暴力穷举
	public static void f1(int[] arr) {
		int maxSum = arr[0];//记录最大和
		
		for(int j=0;j<arr.length;j++) {
			int sum = arr[j];//从第j个开始加上j后面的元素  然后这里先用一个max来记录这一趟循环中的最大值
			int maxOfJ = sum;
			
			for(int i=j+1;i<arr.length;i++) {
				sum += arr[i];
				
				//如果sum大于maxOfJ就更新maxOfJ
				if(sum>maxOfJ)
					maxOfJ = sum;
			}
			
			//每走一趟就比较更新记录最终的结果
			if(maxOfJ>maxSum)
				maxSum = maxOfJ;
		}
		
		System.out.println(maxSum);
	}
	
	
	//递推 O(n)
	//从左往右开始加，如果加起来为负数的那些数就抛弃，用一个变量来记录加的过程中的最大值
	public static int f2(int[] arr) {
		
		if(arr.length==0)
			return 0;
		
		//记录哪串子数组
		int left=0;
		int right = 0;
		
		int sum = arr[0];
		
		//记录最大值
		int max = sum;
		
		
		for(int i=1;i<arr.length;i++) {
			if(sum>=0)
				sum+=arr[i];
			else {
				sum = arr[i];
				left = i;//更新左
			}
			
			if(sum>max) {
				max = sum;
				right = i;
			}
		}
		return max;
	}
}
