package 动态规划and贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出n个物体，第i个物体重量为wi。选择尽量多的物体，使得总重量不超过C。
 */
public class 最优装在问题 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] w = new int[n];//表示重量
	    for (int i = 0; i < n; i++) {
	      w[i] = sc.nextInt();
	    }
	    int C = sc.nextInt();
	    
	    Arrays.sort(w);
	    int ans = f(n,w,C);
	    System.out.println(ans);
	}

	private static int f(int n, int[] w, int c) {
		int sum = 0;
		int cnt = 0;
		for(int i=0;i<n;i++) {
			sum+=w[i];
			
			
			if(sum<=c) {
				cnt++;
			}else {
				break;
			}
		}
		return cnt;
	}
}
