package ��̬�滮and̰��;

import java.util.Arrays;
import java.util.Scanner;

//��������n��������[ai,bi]��ȡ�����ٵĵ㣬ʹ��ÿ�������ڶ�������һ���㣨��ͬ�����ں��ĵ������ͬһ������
/*
Intervals
You are given n closed, integer intervals [ai, bi] and n integers c1, ..., cn.
Write a program that:
reads the number of intervals, their end points and integers c1, ..., cn from the standard input,
computes the minimal size of a set Z of integers which has at least ci common elements with interval [ai, bi], for each i=1,2,...,n,
writes the answer to the standard output.

Input
The first line of the input contains an integer n (1 <= n <= 50000) -- the number of intervals.
The following n lines describe the intervals. The (i+1)-th line of the input contains three integers ai,
bi and ci separated by single spaces and such that 0 <= ai <= bi <= 50000 and 1 <= ci <= bi - ai+1.

Output
The output contains exactly one integer equal to the minimal size of set Z
sharing at least ci elements with interval [ai, bi], for each i=1,2,...,n.
Sample Input
5
3 7 3
8 10 3
6 8 1
1 3 1
10 11 1
Sample Output
6
*/
//POJ1201   Ҫ������������ʽ

//������ʱ��ᳬʱ��ֻ�����̰�ĵ�˼�룬ÿһ�������Ž�õ����յ����Ž�
//һ���Ǹ���ĩ�˵������˼�룬ֻ����ÿ�����䶼��Ҫȡ����Ӧ�ĵ㣬������Щ��������䣬һ�������ͬʱ������������
//����Ҫ�ҵ������ٵĵ�
//ȡ��ʱҲ�Ǵ���ĩ�˿�ʼȡ��������������ͶӰ��һ���߶���ʱ�����ǻ����غϵģ�����Ҫ�ų��ظ������⣬���ĳ�������������ȡ�ˣ�
//��ô�¸�����Ҳ����ȡ�������Ļ�������Ҫ���ж��������������û�е㱻����� ��ô��ȡ�ĵ��Ҫ��ȥ����ǵ�
//��һ������ ����Ϊ�ź�������һ�������tֵ+1��Ϊ���ȣ� ��ĩ��
public class ����ȡ������ {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		Intervals[] intervals = new Intervals[n];
		for(int i=0;i<n;i++) {
			intervals[i] = new Intervals(cin.nextInt(),cin.nextInt(),cin.nextInt());
		}
		
		//����ĩβλ������
		Arrays.sort(intervals);
		
		int max = intervals[n-1].t;//ĩ�˵����ֵ
		int[] axis = new int[max+1];//������¼��Щ��ʱ��ǹ�����ֹ�ظ����
		
		for(int i=0;i<n;i++) {
			int s = intervals[i].s;
			int t = intervals[i].t;
			
			int cnt = sum(axis,s,t);//����ö������ж��ٸ�����
			
			intervals[i].c-=cnt;//��ȥ�ѱ�ǵĵ�
			//������е�Ϊ��ǣ���ô�ʹ���ĩ�˿�ʼ������õ��Ѿ���Ǿ��������̽��
			while(intervals[i].c>0) {
				if(axis[t] == 0) {//����ĩ�˿�ʼ
					axis[t] = 1;
					intervals[i].c--;
					t--;
				}else//����㱻ѡ����
					t--;
			}
		}
		
		System.out.println(sum(axis,0,max));
	}
	
	private static int sum(int[] axis, int s, int t) {
		int count = 0;
		for(int i=s;i<=t;i++) {
			if(axis[i]!=0)
				count++;
		}
		return count;
	}

	private static class Intervals implements Comparable<Intervals>{
		int s;//���
		int t;//�յ�
		int c;//������Ҫȡ�ĵ�
		
		public Intervals(int s,int t,int c) {
			this.s = s;
			this.t= t;
			this.c = c;
		}

		@Override
		public int compareTo(Intervals o) {
			//��t������
			int x = this.t-o.t;
			if(x==0)//���ĩβ����ͬ������ʼλ��
				return this.s-o.s;
			return x;
		}
	}
}
