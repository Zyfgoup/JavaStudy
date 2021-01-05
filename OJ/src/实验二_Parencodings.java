import java.util.Scanner;
import java.util.Stack;

/*http:acm.zju.edu.cn/onlinejudge/showProblem.do?problemId=16
zoj 1016--Parencodin*/
//��p����ת�����ַ���
//���ַ���ת��Ϊ�ַ����飬�������� ����������žͰ��±�iѹ��ջ�У����Ϊ�����žͳ�ջ
//��ô��ʱi���ջ��õ�kֵ���ܻ��w����  ��ʱw��ֵӦ��Ϊ(i-k)/2+1 i-k��ʾ��i-k���ַ���
//��ô/2�����ж������������ô���ж��ٸ��������ټ��ϱ���

public class ʵ���_Parencodings {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int t = cin.nextInt();
		while(t-->0) {
			int n = cin.nextInt();
			int[] arr = new int[n];
			StringBuilder sb = new StringBuilder();
			//�������� ������ת��Ϊ�ַ���
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
		Stack<Integer> s = new Stack();//������������ŵ�λ��
		int index = 0;//���w���е��±�
		
		for(int i=0;i<c.length;i++) {
			if(c[i]=='(')
				s.push(i);
			else {
				int k = s.pop();//��ջ
				if(index++<n-1)
					System.out.print((i-k)/2+1+" ");
				else
					System.out.print((i-k)/2+1+"\n");
			}
		}
		
	}
}
