package ��̬�滮and̰��;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����n�����壬��i����������Ϊwi��ѡ����������壬ʹ��������������C��
 */
public class ����װ������ {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] w = new int[n];//��ʾ����
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
