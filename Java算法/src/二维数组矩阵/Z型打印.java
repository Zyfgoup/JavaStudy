package 二维数组矩阵;
/*
 * 1   2   3   4
 * 5   6   7   8
 * 9   10  11  12
 * 
 * 1 2 5 9 6 3 4 7 10 12 8 12
 * 
 * 上坡或者下坡打印 
 * 上坡就是r--c++
 * 下坡就是r++c--
 * 
 * 上坡打印到了第0行 那么就只能往右走然后改为下坡打印
 * 上坡打印到了最后一列 那么只能向下走然后下坡打印
 * 下坡打印到了第0列，那么只能向下走 然后变为上坡打印
 * 下坡打印到了最后一行，那么只能向右走，然后变为上坡打印
 * 
 */
public class Z型打印 {
	public static void main(String[] args) {
		int[][] matrix = {
		        {1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
//		        {13, 14, 15, 16},
		    };
		f1(matrix);
	}
	
	public static void f1(int[][] arr) {
		int r = 0;
		int c = 0;
		int n = arr.length;
		int m = arr[0].length;
		
		boolean l2r  = true; //从左向右 上坡
		
		while(r<n&&c<m) {
			//上坡打印
			if(l2r) {
				System.out.print(arr[r][c]+" ");
				
				//上坡打印到了第0行，但是还没到最后一列
				if(r==0) {
					c++;//向右走
					l2r = false;//改为下坡打印
					continue;
					
					//上坡打印到了最后一列 向下走 改为下坡打印
				}else if(r>0&&c==m-1) {
					r++;//向下走
					l2r = false;//改为下坡打印
					continue;
					
					//还没到边界继续上坡
				}else {
					r--;
					c++;
				}
				
				//下坡打印
			}else {
				System.out.print(arr[r][c]+" ");
				
				//下坡到了第一列，还没到最后一行 想下走 变上坡
				if(r<n-1&&c==0) {
					r++;//向下走
					l2r = true;//改变方向
					continue;
					
					//下坡到了最后一行
				}else if(r==n-1) {
					c++;//向右走
					l2r = true;
					continue;
				}else {
					r++;
					c--;
				}
			}
		}
	}
}
