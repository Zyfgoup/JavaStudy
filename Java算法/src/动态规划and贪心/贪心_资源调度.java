package ��̬�滮and̰��;

import java.util.Arrays;
import java.util.Scanner;

public class ̰��_��Դ���� {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		P[] p = new P[n];
		int[] t = new int[n+1];//Ԥ�Ʒ���ʱ�� ���ȼ�1 �������
		for(int i=0;i<n;i++) {
			t[i+1] = cin.nextInt();
			int d = cin.nextInt();
			p[i] = new P(i+1,d);
		}
		int[] a = new int[n+1];
		
		f1(p,a,t);
		
	}

	private static void f1(P[] p, int[] a, int[] t) {
		Arrays.sort(p);//�Կͻ�ʵ��������а�di���� ���ı����Ӧ�Ŀͻ����
		
		a[1] = 0;  //��Ӧf(1) �̶�Ϊ0
		
		for(int i=1;i<p.length;i++) { //��������
			//a[x]���ڰ�˳���С��ǰһ��a[x-1]���ϵ�i-1����Ԥ�ƿͻ�����ʱ��t[i-1]
			a[p[i].num] = a[p[i-1].num]+t[p[i-1].num]; 
		}
		
		//���a[i]
		for(int i=1;i<a.length;i++) {
			System.out.println("f["+i+"]: "+a[i]);
		}
	}
	
}
class P implements Comparable<P>{
	int num;//�ͷ����
	int d;//ϣ���������ʱ��
	
	public P(int num,int d) {
		this.num = num;
		this.d = d;
	}

	@Override
	public int compareTo(P o) {
		return this.d-o.d;
	}
}
