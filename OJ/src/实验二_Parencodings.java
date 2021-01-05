import java.util.Scanner;
import java.util.Stack;

/*http:acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=16
zoj 1016--Parencodin*/
//把p序列转换成字符串
//把字符串转化为字符数组，遍历数组 如果是左括号就把下标i压入栈中，如果为右括号就出栈
//那么此时i与出栈获得的k值就能获得w序列  此时w的值应该为(i-k)/2+1 i-k表示有i-k个字符，
//那么/2就是有多少组配对了那么就有多少个左括号再加上本身

public class 实验二_Parencodings {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int t = cin.nextInt();
		while(t-->0) {
			int n = cin.nextInt();
			int[] arr = new int[n];
			StringBuilder sb = new StringBuilder();
			//输入数组 把数组转化为字符串
			for(int i=0;i<n;i++) {
				arr[i] = cin.nextInt();
				if(i==0) {
					for(int j=0;j<arr[i];j++) {
						sb.append("(");
					}
					sb.append(")");
				}else {
					for(int j=0;j<arr[i]-arr[i-1];j++) {
						sb.append("(");
					}
					sb.append(")");
				}
			}
			char[] c = sb.toString().toCharArray();
			f1(c,n);
			
		}
	}
	
	public static void  f1(char[] c,int n) {
		Stack<Integer> s = new Stack();//用来存放左括号的位置
		int index = 0;//输出w序列的下标
		
		for(int i=0;i<c.length;i++) {
			if(c[i]=='(')
				s.push(i);
			else {
				int k = s.pop();//出栈
				if(index++<n-1)
					System.out.print((i-k)/2+1+" ");
				else
					System.out.print((i-k)/2+1+"\n");
			}
		}
		
	}
}
