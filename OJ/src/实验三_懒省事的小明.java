import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//��ÿ����С����������� һֱ�����ô������ʡ����
//���ǲ����������� ��ôÿ�κϲ��� ��Ҫ��������
//��ôҪ��ʲô���ܲ���Ŀ첢�Ҳ�ѯ��С��ֵ�Ŀ����
//java�е����ȼ���������С����ʵ�ֵ�  ���Զ�ͷ��λ����Զ����С��ֵ ���ǲ����������
public class ʵ����_��ʡ�µ�С�� {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while(n-->0) {
			int m = cin.nextInt();
			Queue<Integer> que = new PriorityQueue();
			for(int i=0;i<m;i++) {
				int a = cin.nextInt();
				que.add(a);
			}
			for(Integer i:que) {
				System.out.print(i+" ");
			}
			int sum = 0;
			
			if(que.size()==1) {
				System.out.println(que.poll());
			}
			
			
			//����ʣһ���ܵĽ�����ڶ����� ����ѭ������ ע��һ���������ֻ��һ��ʱҲҪ���д���
			while(que.size()!=1) {
				int t = que.poll();
				t+=que.poll();
				sum+=t;
				que.add(t);

			}
			System.out.println(sum);
		}
	}
}
