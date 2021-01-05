package 动态规划and贪心;
/**
 * 物品数量无限 （就是一个物品可以重复取）
 * 完全背包问题
 * 首先在初始化最后一行的时候有所不同：初始化时，当只考虑一件物品a时，state[row][j] = values[row]*j/weight[row]
 * 然后在递推的时候有些不同：state[row][j] = max{state[row+1][j],state[row][j-weight[row]]+values[row]}，即不抓时用现在的容量去匹配下面行
 * 要抓的时候，先抓到这个物品的价值，然后用剩下的容量去匹配同一行，为什么匹配同一行，这是因为剩下的容量可以重复抓当前物品（不限数量）
 *
 * 同时必须理解，抓一个之后用剩余的容量重新考虑当前可选的所有物品其实包含了抓2个甚至更多的情况！！！
 */
public class 完全背包问题 {
	
	  static int[] values = {9, 5, 3, 1};
	  static int[] weights = {7, 4, 3, 2};
	  static int n = 4;
	  static int total = 10;
	  static int[][] state = new int[n][total + 1];//不同的物品范围下不同的容量能装出来的最大价值
	  
	public static void main(String[] args) {
		
	}
	
	public static int dp() {
		int row = 0;
		int v=1;
		int w = weights[row];
		for(;v<total+1;v++) {
			state[0][v] = values[row]*(v/w); //对第一行初始化 v/w表示可以装几个第一个物品
		}
		
		
		for(int i=1;i<n;i++) {
			w = weights[i];
			
			for(int j=1;j<total+1;j++) {//j表示为当前能装的总重量
				
				
				if(j>=w) {//能装的情况下
					//要抓  可以抓重复的 一开始想到用for循环来
					//但是要知道抓了一次之后 能否继续抓就变成了state[i][j-w]状态的问题了
					//所以不需要用for循环来求能抓几个重复
					
					int v1 = values[i]+state[i][j-w];  //抓了一个后 调到当前行 的j-w 其实已经包括了可以抓多少次重复的
					//要充分理解state[][]表示什么含义
					
					//不抓
					int v2 = state[i-1][j];
					
					state[i][j] = Math.max(v1, v2);
				}else {
					//不能装的情况下
					state[i][j] = state[i-1][j];
				}
			}
		}
		return state[n-1][total];
	}
}
