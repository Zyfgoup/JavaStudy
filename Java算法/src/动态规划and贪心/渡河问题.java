package 动态规划and贪心;

import java.util.Arrays;
import java.util.Scanner;

/*
A group of N people wishes to go across a river with only one boat, which can at most carry two persons.
Therefore some sort of shuttle arrangement must be arranged in order to row the boat back and forth so that all people may cross.
Each person has a different rowing speed; the speed of a couple is determined by the speed of the slower one.
Your job is to determine a strategy that minimizes the time for these people to get across.

Input

The first line of the input contains a single integer T (1 <= T <= 20), the number of test cases.
Then T cases follow.
The first line of each case contains N, and the second line contains N integers giving the time for each people to cross the river.
Each case is preceded by a blank line. There won't be more than 1000 people and nobody takes more than 100 seconds to cross.

Output

For each test case, print a line containing the total number of seconds required for all the N people to cross the river.

Sample Input
1
4
1 2 5 10
Sample Output
17
 */


//当用贪心策略时  我们发现例子的一种最优时 不代表适合所有情况 
//我们只能靠猜测 + 验证 （那么就可以通过反证  举例  或者一些数学上的代入法）


//渡河问题
//假设只有四个人时  那么按照a b c d速度从快到慢排序的话
//如果是按照ab过 a回  cd过 b回 ab过  那么花费的时间是 a+3b+d 这是符合题目给的例子输出的情况
//如果按照 ab过 a回 ac过 a回 ad过  那么就是2a+b+c+d  
//同时减去a+b+d  那么就是2b  a+c  
//可发现 如果 c的值大于b的话 那么就是第一种方案最快
//如果 c==b 那么就是第二种方案更快 

public class 渡河问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int i = 0; i < T; i++) {
	      int n = sc.nextInt();
	      int[] speed = new int[n];
	      for (int j = 0; j < n; j++) {
	        speed[j] = sc.nextInt();
	      }
	      Arrays.sort(speed);//先排序
	      f1(speed,n);
	    }
	}

	
	private static void f1(int[] speed, int n) {
		int ans = 0;
		
		while(n>0) {
			if(n==1) {
				ans+= speed[0];
				break;//跳出循环 到了边界
			}else if(n==2) {
				ans+=speed[1];//已经排好序了  那么就是速度慢的
				break;
			}
			//3个人的情况 要速度最快 那么可以推算出肯定是a+b+c
			else if(n==3) {
				ans+= speed[0]+speed[1]+speed[2];
				break;
			}else {
				//因为n不一定只为4,所以其实相当于每次把最慢的两个人送过河 然后n-2当成一个新的子问题求解
				
				//第一种情况  a回 cd过 b回  因为不一定只为4
				int res1 = speed[1]+speed[0]+speed[n-1]+speed[1];
				//第二种  ac过 a回 ad过 a回
				int res2 = speed[n-2]+speed[n-1]+2*speed[0];
				
				ans+=min(res1,res2);
				n-=2;//递推下去 每次解决最慢的两个人过去
			}
		}
		System.out.println(ans);
	}


	private static int min(int res1, int res2) {
		return (res1<res2)? res1:res2;
	}
}
