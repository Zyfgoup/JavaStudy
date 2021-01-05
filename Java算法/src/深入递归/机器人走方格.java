package 深入递归;
/*
有一个X*Y的网格，一个机器人只能走格子且只能向右或向下走，要从左上角走到右下角。
请设计一个算法，计算机器人有多少种走法。
给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
*/

//当x=y=1时  只有一种走法
//当x=2 y=1,那么也只能向右走  1种
//当x=1 y=2，只能向下走  1种
//当x=y=2 ，有2种
/*
 * 那么当x=y=3时呢  可发现此时向右走一格 剩余网格变成x=2y=3,向下走一格 剩余网格就变成x=3 y=2
 * 当x=2,y=3时，向下走 变成x=2y=2,那么就有2种  向右走变成x=1,y=3只能向下走那么就有1种
 * 同理可推出x=3 y=2
 * 
 * 根据以上可发现当x=1时  只能向下走   y=1时只能向右走
 * 
 * 核心都是逐步生成结果     
递归的话就是自下而上的从一般情况推广到复杂情况，然后再写成递归看起来是从自上而下的求解 但是底层还是自下而上一层一层往上返回结果
递推迭代 就是很能直观体现逐步生成结果的过程
 * 
 */

public class 机器人走方格 {
	public static void main(String[] args) {
		System.out.println(f1(3,3));
		System.out.println(f2(3,3));
	}
	
	//递归求解
	//根据上面的一般情况可以退出dp公式  那么就是f(x,y)=f(x-1,y)+f(x,y-1)
	//
	public static int f1(int x,int y) {
		if(x==1||y==1)
			return 1;
		return f1(x-1,y)+f1(x,y-1);
	}
	
	
	//递推迭代的方式求解问题
	
	/*
	 * 用二维数组来存每个位置的走法，但是这时候看成从右下方走到左上方来比较好计算
	 * 那么根据一开始的推论  只有1行与第1列的走法都是1
	 * 那么arr[i][j] = arr[i-1][j]+arr[i][j-1];
	 */
	public static int f2(int x,int y) {
		
		//从第一行第一列开始比较好，所以长度加1
		int[][] arr = new int[x+1][y+1];
		
		//把第一行第一列的走法都为1
		for(int i=1;i<arr.length;i++) {
			arr[i][1] = 1;
		}
		for(int j=1;j<arr[1].length;j++) {
			arr[1][j] = 1;
		}
		
		for(int i=2;i<arr.length;i++) {
			for(int j=2;j<arr[1].length;j++) {
				arr[i][j] = arr[i-1][j]+arr[i][j-1];
			}
		}
		return arr[x][y];
	}
}
