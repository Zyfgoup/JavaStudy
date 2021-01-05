import java.util.Arrays;
import java.util.Scanner;

public class 实验二_当总统 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(true) {
			int n = cin.nextInt();
			if(n==0)
				break;
			
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = cin.nextInt();
			}
			Arrays.sort(arr);
			int count = 0;
			for(int i=0;i<n/2+1;i++) {
				count += arr[i]/2+1;
			}
			System.out.println(count);
		}
	}
}
