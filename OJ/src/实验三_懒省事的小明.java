import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//把每次最小的两个堆相加 一直如此那么就是最省力的
//但是不好用排序做 那么每次合并后 又要重新排序
//那么要有什么是能插入的快并且查询最小的值的快的呢
//java中的优先级队列是用小顶堆实现的  所以队头的位置永远是最小的值 但是并不是有序的
public class 实验三_懒省事的小明 {
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
			
			
			//最后就剩一个总的结果存在队列里 所以循环条件 注意一个当输出的只有一堆时也要进行处理
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
