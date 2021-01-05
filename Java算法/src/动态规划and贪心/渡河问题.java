package ��̬�滮and̰��;

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


//����̰�Ĳ���ʱ  ���Ƿ������ӵ�һ������ʱ �������ʺ�������� 
//����ֻ�ܿ��²� + ��֤ ����ô�Ϳ���ͨ����֤  ����  ����һЩ��ѧ�ϵĴ��뷨��


//�ɺ�����
//����ֻ���ĸ���ʱ  ��ô����a b c d�ٶȴӿ쵽������Ļ�
//����ǰ���ab�� a��  cd�� b�� ab��  ��ô���ѵ�ʱ���� a+3b+d ���Ƿ�����Ŀ����������������
//������� ab�� a�� ac�� a�� ad��  ��ô����2a+b+c+d  
//ͬʱ��ȥa+b+d  ��ô����2b  a+c  
//�ɷ��� ��� c��ֵ����b�Ļ� ��ô���ǵ�һ�ַ������
//��� c==b ��ô���ǵڶ��ַ������� 

public class �ɺ����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    for (int i = 0; i < T; i++) {
	      int n = sc.nextInt();
	      int[] speed = new int[n];
	      for (int j = 0; j < n; j++) {
	        speed[j] = sc.nextInt();
	      }
	      Arrays.sort(speed);//������
	      f1(speed,n);
	    }
	}

	
	private static void f1(int[] speed, int n) {
		int ans = 0;
		
		while(n>0) {
			if(n==1) {
				ans+= speed[0];
				break;//����ѭ�� ���˱߽�
			}else if(n==2) {
				ans+=speed[1];//�Ѿ��ź�����  ��ô�����ٶ�����
				break;
			}
			//3���˵���� Ҫ�ٶ���� ��ô����������϶���a+b+c
			else if(n==3) {
				ans+= speed[0]+speed[1]+speed[2];
				break;
			}else {
				//��Ϊn��һ��ֻΪ4,������ʵ�൱��ÿ�ΰ��������������͹��� Ȼ��n-2����һ���µ����������
				
				//��һ�����  a�� cd�� b��  ��Ϊ��һ��ֻΪ4
				int res1 = speed[1]+speed[0]+speed[n-1]+speed[1];
				//�ڶ���  ac�� a�� ad�� a��
				int res2 = speed[n-2]+speed[n-1]+2*speed[0];
				
				ans+=min(res1,res2);
				n-=2;//������ȥ ÿ�ν�������������˹�ȥ
			}
		}
		System.out.println(ans);
	}


	private static int min(int res1, int res2) {
		return (res1<res2)? res1:res2;
	}
}
