package ��̬�滮and̰��;

import java.util.Arrays;
import java.util.Scanner;

/*
��n���,ÿ����ֱ���siʱ�俪ʼ,��tiʱ�����.

����ÿ���,�㶼����ѡ��������.���ѡ���˲���,��ô��ʼ���ն�����ȫ�̲���.

����,���빤����ʱ��β����ظ�(��ʹ�ǿ�ʼ��˲��ͽ�����˲����ص�Ҳ�ǲ������).

���Ŀ���ǲ��뾡���ܶ�Ĺ���,��ô����ܲ�����������?

1��n��100000

1��si��ti��10^9

����:

��һ��:n
�ڶ���:n�������ո����,����n�������Ŀ�ʼʱ��
������:n�������ո����,����n�������Ľ���ʱ��

��������:

5
1 3 1 6 8
3 5 2 9 10

�������:

3

˵��:ѡȡ����1,3,5
 */

//Ҫ�������ܶ���ٸ�����  ��ô�϶������Ž������ ��ô��Ҫ�ҵ�ĳ�ֹ��� ÿ��ѡ���ŵ�
//������Ŀ�����Ƴ�ÿ�ΰ��ս���ʱ�����ȵĽ���ѡ 
//��ȻҪ�ж�ѡ����������Ŀ�ʼʱ���Ƿ������һ������ʱ��  ���ܽ���

//Ϊʲô�ܵõ�����ѡ����ʱ��С���أ����Ծ�һЩ������֤��
//�����ѡ��ʼʱ����Ļ�  ����������ʱ��ܾ� ��ô�м�����зǳ��๤��ʱ��̵ܶ�
//�����ѡ����ʱ����̵�  ��ô����������п���λ�����������Ĺ���֮�� ��ô�϶���ѡ����������

//Ҫʵ��ÿ��ѡ����ʱ������ ��ô��Ҫ�Խ���ʱ���������  ������ô��֤��ʼʱ�������Ӧ��
//���Դ���һ������ �̳нӿ� ��дCompareTo���� �Զ��������������
public class ����������� {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] s = new int[n];
		int[] t = new int[n];
		Job[] jobs = new Job[n];
		for(int i=0;i<n;i++) {
			s[i] = cin.nextInt();
		}
		for(int i=0;i<n;i++) {
			t[i] = cin.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			jobs[i] = new Job(s[i],t[i]);
		}
		Arrays.sort(jobs);
		int res = f1(jobs,n);
		System.out.println(res);
	}

	private static int f1(Job[] jobs, int n) {
		int cnt = 1;//��һ���϶�Ҫ��ӵ� ��Ϊ��һ������ʱ������
		int last = jobs[0].t;//��¼��һ������ʱ��
		for(int i=1;i<n;i++) {
			if(jobs[i].s>last) {
				cnt++;  //���ս���ʱ����絽���ź�����  ��ôֻҪ��ʼʱ�������һ������ʱ�� ��++
				last = jobs[i].t;
			}
		}
		
		return cnt;
	}
}
class Job implements Comparable<Job>{
	int s;
	int t;
	
	public Job(int s,int t) {
		this.s = s;
		this.t = t;
	}

	@Override
	public int compareTo(Job obj) {
		int x = this.t-obj.t;//�ȽϽ���ʱ��
		if(x==0)
			return this.s-obj.s;//�������ʱ��һ������� �Ͱѿ�ʼʱ���������ǰ��
		else
			return x;
	}
	
}
