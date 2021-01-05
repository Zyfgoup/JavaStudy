package 括号配对问题;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in); //用Scanner时间要久一点
		//学用流
		int n = cin.nextInt();
		String s1 = cin.nextLine();  
		while(n-->0){
			String str = cin.nextLine();//nextLine（）自动读取了被next（）去掉的Enter作为他的结束符，所以没办法给str从键盘输入值。
			//只键入数字 会直接输出一个NO，所以在前面先用一个nextLine读取nextInt的Enter
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
