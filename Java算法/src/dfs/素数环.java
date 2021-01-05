package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class ������ {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    arr[0] = 1;//��һ������Ϊ1
		    dfs(arr,n,1);
	}
	
	public static void dfs(int[] arr,int n,int cur) {
		if(cur==n&&isPrime(arr[cur-1]+arr[0])) {
			print(arr);
			return;
		}
		
		for(int i=2;i<=n;i++) {
			//��Ϊÿ�ζ��Ǵ�2��ʼ������n ��ô��Ҫ����Ƿ�ǰ���Ѿ������Ǹ�����
			if(check(arr,i,cur)) {//���i�Ƿ�����Ѿ����˵�����������ܷ����һ������ӵ���0
				arr[cur] = i;
				dfs(arr,n,cur+1);
				arr[cur] = 0;//����
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

	//�Ƿ�������
	private static boolean isPrime(int n) {
		for(int i=2;i*i<=n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}
