import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * “饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
一个优先级，初始时 (0 时刻) 优先级都为 0。
每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
优先级小于等于 3，则会被清除出优先缓存。
给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
先缓存中。
【输入格式】
第一行包含 3 个整数 N、 M 和 T。
以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
一个订单。
【输出格式】
输出一个整数代表答案。
【样例输入】
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
 */
public class 十蓝桥杯G题 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		Set<Integer> set = new HashSet<Integer>();
		
		int N = cin.nextInt();
		int M = cin.nextInt();
		int T = cin.nextInt();
		
		int[][] orders = new int[M][2] ; // [i][0]记录时刻  [i][1]记录店
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<2;j++) {
				orders[i][j] = cin.nextInt();
			}
		}
		
		
		int[] priority = new int[N]; //店的优先级
		int[] sign = new int[N];//某个时刻是否有订单
		
		//遍历1-T时刻
		for(int i=1;i<=T;i++) {
			//遍历订单
			for(int j=0;j<M;j++) {
				if(orders[j][0]==i) { //如果是这个时刻的订单
					priority[orders[j][1]-1] += 2; //要记得减一 因为店铺是1 2  下标是从0开始
					if(priority[orders[j][1]-1]>5 && !set.contains(orders[j][1])) {
						set.add(orders[j][1]);
					}
					
					sign[orders[j][1]-1] = 1; //表示有订单
				}
			}
			
			for(int k=0;k<N;k++) {
				if(sign[k] == 0 && priority[k]>0) {
					priority[k] --;
				}
				if(priority[k]<=3) {
					set.remove(k+1); //移除店铺
				}
			}
			
			sign = new int[N];
		}
		System.out.println(set.size());
	}
}
