package �����������;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in); //��Scannerʱ��Ҫ��һ��
		//ѧ����
		int n = cin.nextInt();
		String s1 = cin.nextLine();  
		while(n-->0){
			String str = cin.nextLine();//nextLine�����Զ���ȡ�˱�next����ȥ����Enter��Ϊ���Ľ�����������û�취��str�Ӽ�������ֵ��
			//ֻ�������� ��ֱ�����һ��NO��������ǰ������һ��nextLine��ȡnextInt��Enter
			char[] c = str.toCharArray();
			check(c);
		}
	}
	
	public static void check(char[] c) {
		char[] stack = new char[c.length];
		int front=0;
		boolean flag = false;
		for(int i=0;i<c.length;i++) {
			if(c[i] == '['||c[i]=='(')
				stack[front++] = c[i];
			else if(front!=0&&c[i]==']'&&stack[--front] == '[')
				 flag = true;
			else if(front !=0&&c[i]==')'&&stack[--front] == '(')
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
