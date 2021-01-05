package dfs;

public class n皇后对称优化 {
	 static int n;
	static int cnt;//计算有多少种放法
	static int[] rec;
	public static void main(String[] args) {
		  	n = 5;
		    rec = new int[n];
		    dfs(0,(n+1)/2); //注意下标是从0开始
		    System.out.println(cnt*2);
	}
	
	
	//传入行 因为每一行只能有一个   rec[row] = ？来表示这行的皇后放在第几列  比如 rec[0]=1 表示第1行的皇后放在第2列
	//y表示放置行数的边界的 只能放第1列到第y-1列 因为for循环是小于 <y
	public static void dfs(int row,int y) {
		if(row==n) {
			cnt++;//到了边界 就++
			return;//return 继续找其他可能
		}
		
		//依次尝试把皇后放在边界的每一列
		for(int col=0;col<y;col++) { //<y  一开始写成<=y 那么当传入n时就会出现 col = n的情况了
			if(check(row,col)) {
				rec[row] = col; //表示row这行的皇后放在col列
				
				//当棋盘为奇数时，第一行的皇后放在中间位置时 第二行的皇后必须放在左半边区域 
				if(n%2!=0 && row==0 && col==(n+1)/2-1)  //要-1是因为下标从0开始
					dfs(row+1,(n+1)/2-1); 
				else
					dfs(row+1,n); //否则第二行开始可以放在任何一列
				
				
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
