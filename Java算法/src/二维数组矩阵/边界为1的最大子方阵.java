package 二维数组矩阵;
/*
 * 给定一个N*N的矩阵，在这个矩阵中只有0和1，返回边框全是1的最大正方形的的边长长度
 *   {0, 1, 1, 1, 1},
	 {0, 1, 0, 0, 1},
	 {0, 1, 0, 0, 1},
	 {0, 1, 1, 1, 1},
	 {0, 1, 0, 1, 1}　
 　　其中，边框全是1的最大正方形的大小是4*4，返回4
 */
public class 边界为1的最大子方阵 {
	static int[][][] rec;
	public static void main(String[] args) {
	    int[][] A = {
	            {0, 1, 1, 1, 1},
	            {0, 1, 0, 1, 0},
	            {0, 1, 1, 1, 1},
	            {0, 1, 1, 1, 1},
	            {0, 1, 0, 1, 1}
	        };
	    //处理矩阵记录右和下
		helpRec(A);
		
		//打印测试
		print(rec,A.length);
		
		System.out.println(solve(A));
	}
	
	//暴力遍历解法
	//从最大阶开始遍历，遍历每个元素的为正方形左上角顶点的n阶矩阵是否边框全为1
	//当i+n>N就是行已经遍历到不存在有n阶的边框为1 的矩阵了
	//当j+n>N同理也是遍历到的某列到最后已经不存在有为n阶边框为1的矩阵了
	public static int f1(int[][] matrix) {
		int N = matrix.length;
		int n = N;
		while(n>0) {
			for(int i=0;i<N;i++) {
				if(i+n>N)
					break;
				l3:for(int j=0;j<N;j++) {
					if(j+n>N)
						break;
					
					//检查四个边
					int r = i;
					int c = j;
					
					//检查上
					while(c<j+n) {
						if(matrix[r][c++]==0)
							continue l3;//调到指定循环中继续循环
					}
					c--;//c出循环是=j+n恢复
					
					//检查右
					while(r<i+n) {
						if(matrix[r++][c]==0)
							continue l3;
					}
					r--;
					
					//下
					while(c>=j) {
						if(matrix[r][c--]==0)
							continue l3;
					}
					c++;
					
					//左
					while(r>=i) {
						if(matrix[r--][c]==0)
							continue l3;
					}
					r++;
					
					return n;
				}
				
			}
			n--;
		}
		return n;
	}
	
	//优化方法  预处理   类似于动态规划打表
	//用一个辅助三维数组来记录每个元素位置其右边和下边1的个数  包括自身 如果元素为0，就都为0
	
	
	//仍然是遍历数组每个元素，只是这时候每个元素只需要判断4个顶点的右和下的1是否满足边框全为1的矩阵即可
	public static int solve(int[][] matrix) {
		int N = matrix.length;
		int n = N;
		while(n>0) {
			for(int i=0;i<N;i++) {
				if(i+n>N)
					break;
				for(int j=0;j<N;j++) {
					if(j+n>N)
						break;
					
					if(check(i,j,n))
						return n;
				}
			}
			n--;
		}
		return n;
	}
	
	private static boolean check(int i, int j, int n) {
		//左上角的右边1的数量要>=n
		//左上角的下边1的数量要>=n
		//左下角的右边的1的数量要>=n
		//右上角的下边的1的数量要>=n
		
		if(rec[i][j][0]>=n&&rec[i][j][1]>=n&&rec[i+n-1][j][0]>=n&&rec[i][j+n-1][1]>=n)
			return true;
		
		return false;
	}

	//打印记录的元素的右和下的1的个数
	public static void print(int[][][] rec,int N) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(rec[i][j][0]+","+rec[i][j][1]+"\t");
			}
			System.out.println();
		}
	}
	
	//记录矩阵每个元素的右和下的连续1的个数 包括自身
	public static void helpRec(int[][] arr) {
		int n = arr.length;
		rec = new int[n][n][2];//记录每个元素的右和下连续的1 所以是2
		
		//从最后一行开始记录
		int row = n-1;
		
		//先记录最后一行
		for(int i=n-1;i>=0;i--) {
			int value = arr[row][i];
			if(value==1) {
				//因为要i+1来计算 会下标越界 所以最后一行最后一个元素单独处理
				if(i==n-1)
					rec[row][i][0] = 1;
				
				//根据右边元素的右边1的数量来记录目前的
				else 
					rec[row][i][0] = rec[row][i+1][0]+1;
				
				//记录完最后一行每个元素右边连续的1后也要记录下的
				//因为是最后一行所以如果自身是1的话就都是1了
				rec[row][i][1]=1;
			}	
		}
		
		
		//往上记录可以用for循环  所以row--
		row--;
		for(int i=row;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				int value = arr[i][j];
				if(value==1) {
					//因为要j+1来计算 会下标越界 所以最后一行最后一个元素单独处理
					if(j==n-1)
						rec[i][j][0] = 1;
					//根据右边元素的右边1的数量来记录目前的
					else 
						rec[i][j][0] = rec[i][j+1][0]+1;
					
					//下方的1
					rec[i][j][1] = rec[i+1][j][1]+1;
				}	
			}
		}
	}
}
