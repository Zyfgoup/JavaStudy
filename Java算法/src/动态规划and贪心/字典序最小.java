package ��̬�滮and̰��;

import java.util.Scanner;

/*
�ֵ�����С����

��һ������ΪN���ַ���S,����һ���ַ���T,����ҲΪN��

�����T��һ���մ�����󷴸����������������

1. ��S��ͷ��ɾ��һ���ַ����ӵ�T��β��
2. ��S��β��ɾ��һ���ַ����ӵ�T��β��

Ŀ����������ɵ��ַ���T���ֵ��򾡿���С

1��N��2000
�ַ���Sֻ������дӢ����ĸ

���룺�ַ���S
������ַ���T

POJ - 3617 Ҫ��ÿ80���ַ��������
 */

//����������ACDBCB    ���ʱABCBCD
//�����ԣ�ÿ��ֻ��ȡͷ����β����ô˭С��ȡ˭�������ͬ�Ϳ���һ��

//�õ�һ�����봮�ķ��������������Ƚϴ�С compareTo()������˭Сȡ˭������ĸ��ֱ�����ȵ���n
public class �ֵ�����С {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			sb.append(cin.next());
		}
		f(sb.toString());
	}

	private static void f(String s) {
		String s1 = new StringBuffer(s).reverse().toString();
		StringBuffer sb1 = new StringBuffer();
		int N = s.length();
		int cnt = 0;
		while(sb1.length()<N ) {  //����һ��ʼ��sb1.length()<s.length()���ж��Ǵ���ģ���Ϊs�ĳ����ǻ�����ȡ���ַ������
			if(s.compareTo(s1)<=0) {
				sb1.append(s.charAt(0)); 
				s = s.substring(1);//���� ȥ�����ַ�
			}else {
				sb1.append(s1.charAt(0));
				s1 = s1.substring(1);//����
			}
			
			if(sb1.length()%80==0) {
				System.out.println(sb1.substring(cnt*80, (cnt+1)*80));
				cnt++;
			}
			
		}
		
		//ʣ�ಿ��
		if(sb1.length()>cnt*80) {
			System.out.println(sb1.substring(cnt*80));
		}
		
	}
}
