package dfs;
/*
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个n*n的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。

 给定一个int n，请返回方法数，保证n小于等于15
 */
public class n皇后问题 {
	static int n;
	static int cnt;//计算有多少种放法
	static int[] rec;
	public static void main(String[] args) {
		  	n = 5;
		    rec = new int[n];
		    dfs(0);
		    System.out.println(cnt);
	}
	
	
	//传入行 因为每一行只能有一个   rec[row] = ？来表示这行的皇后放在第几列  比如 rec[0]=1 表示第1行的皇后放在第2列
	public static void dfs(int row) {
		if(row==n) {
			cnt++;//到了边界 就++
			return;//return 继续找其他可能
		}
		
		//依次尝试把皇后放在每一列
		for(int col=0;col<n;col++) {
			if(check(row,col)) {
				rec[row] = col; //表示row这行的皇后放在col列
				dfs(row+1);//放了之后就进行下一行
				
				rec[row] = 0; //如果放不下去 那么就要回溯为0 然后继续for循环或者返回上一层调用
				//这里其实不回溯也可以 初步想的是因为不用检查行  所以不设置为0也没有关系
				
			}
		}
	}

	//检查该列有没有皇后 和正反对角线有没有皇后
	//不需要检查行有没有皇后，因为是从第一行开始往下深搜放，那么新的一行肯定是没放的
	//检查正反对角线可以画出一个3X3的图可发现 正对角线如果有放皇后 那么其坐标行列相减肯定与本次要放的相等i-rec[i] = row-col
	//如果反对角线的某个位置放了皇后 那么行列相加肯定相等 i+rec[i] = row+col;
	private static boolean check(int row, int col) {
		//从第0检查到row-1  因为row和大于row的行数肯定都是还没有皇后的 所以只需要检查其前面的每一行有没放到同一个列的皇后
		for(int i=0;i<row;i++) {
			if(rec[i]==col||i+rec[i]==row+col||i-rec[i]==row-col)
				return false;
		}
		return true;
	}
}
