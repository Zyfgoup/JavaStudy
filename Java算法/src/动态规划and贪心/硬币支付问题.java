package ��̬�滮and̰��;

import java.util.Scanner;

/*
Ӳ������

��1Ԫ,5Ԫ,10Ԫ,50Ԫ,100Ԫ,500Ԫ��Ӳ�Ҹ�c1,c5,c10,c50,c100,c500ö.

����Ҫ����ЩӲ����֧��AԪ,������Ҫ����öӲ��?

�ٶ��������ٴ���һ��֧������.

0��ci��10^9

0��A��10^9

����:

��һ������������,�ֱ�����С����6����ֵ��Ӳ�ҵĸ���

�ڶ���ΪA,������֧����AԪ

����:

����

3 2 1 3 0 2
620

���

6
*/
//̰���㷨�� Ҫ�����Ž� ��ôÿ�ζ���ѡ��������ֵ ��ô���õ���Ӳ�������϶������ٵ�

//�����ٵ�Ӳ��֧������������Ӳ�ұ�ʾ��һ����Ϸ�������ô�������һ�����Ž�
//��֪��ҪӲ������ ��ôӦ�þ�������ֵ��ģ����Դ���ֵ���Ŀ�ʼ����  Ҫע����ֵ������ �п���Ϊ0
//�����һ����500 ��ô���� (A/500)�������������500��ʾ  A-��A/500��*500 ����ʣ���
//����A/500 ���ܴ��� ��ֵ������ ��������Ҫ����Ƿ����� ��ô����˭�Ƚ�С ����˭



public class Ӳ��֧������ {
	static int[] coins = {1,5,10,50,100,500};
	static int[] shu = new int[6];
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		for(int i=0;i<6;i++) {
			shu[i] = cin.nextInt();
		}
		
		int A = cin.nextInt();//AԪ
		
		System.out.println(f1(A,5));
	}
	private static int  f1(int A, int cur) {
		//��ֵ
		if(cur<0)
			return 0;
		if(A==0)
			return 0;
		
		int a = A/coins[cur];//������������coins[i]
		
		//���a����b shu[cur] ��ô���Ҳֻ����shu[cur]��
		//���aС��b ��ôҲֻ����a��
		int b = min(a,shu[cur]);//����ֵ�������Ƚ� ˭Сѡ˭
		return b+f1(A-(coins[cur]*b),cur-1);
		
	}
	private static int min(int a, int i) {
		return (a<i)? a:i;
	}
}
