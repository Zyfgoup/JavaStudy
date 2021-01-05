package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 素数环 {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    arr[0] = 1;//第一个总是为1
		    dfs(arr,n,1);
	}
	
	public static void dfs(int[] arr,int n,int cur) {
		if(cur==n&&isPrime(arr[cur-1]+arr[0])) {
			print(arr);
			return;
		}
		
		for(int i=2;i<=n;i++) {
			//因为每次都是从2开始遍历到n 那么就要检查是否前面已经填了那个数字
			if(check(arr,i,cur)) {//检查i是否存在已经填了的数组里面和能否和上一个数相加等于0
				arr[cur] = i;
				dfs(arr,n,cur+1);
				arr[cur] = 0;//回溯
			}
		}
	}

	
	private static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
		
	}

	private static boolean check(int[] arr, int i, int cur) {
		for(int j=0;j<cur;j++) {
			if(arr[j]==i||!isPrime(arr[cur-1]+i))
				return false;
		}
		return true;
	}

	//是否是素数
	private static boolean isPrime(int n) {
		for(int i=2;i*i<=n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}
