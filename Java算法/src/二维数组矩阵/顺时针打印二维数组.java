package 二维数组矩阵;
/*
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * 12348121615141395671110
 * 
 * 有bug
 */

public class 顺时针打印二维数组 {

	public static void main(String[] args) {
		 int[][] arr = {
			        {1, 2, 3, 4, 5,6},
			        {14,15, 16,17,18, 7},
			        {13,12, 11, 10, 9, 8},
			        
			    };
		 f1(arr);
	}
	
	
	//把一圈分成四部分 分别打印四部分 上右下左   然后循环至下一圈      用左上角和右下角作为标记直到交错就退出循环
	public static void f1(int[][] arr) {
		//控制四部分的边界
		int leftrow = 0;
		int leftcol = 0;
		int rightrow = arr.length-1;
		int rightcol = arr[0].length-1;
		while(leftrow<=rightrow&&leftcol<=rightcol) {
			//控制打印
			int r = leftrow;
			int c = leftcol;
			
			//打印上 行r不变 列c++ 直到==rightcol
			while(c<=rightcol) {
				System.out.print(arr[r][c++]+" ");
			}
			//循环出来之后c是>rightcol的 所以要恢复到等于rightcol
			c--;
			
			//打印右 列c不变，行r++，直到打印到最后一行等于rightrow
			//因为右边列的第一个元素已经在上中打印了，所以这里从r++开始
			r++;
			while(r<=rightrow) {
				System.out.print(arr[r++][c]+" ");
			}
			
			//恢复r
			r--;
			
			//打印下 行r不变，列c--到leftcol;
			//同样下的最后一个元素在右中打印了 所以从c--开始
			c--;
			while(c>=leftcol) {
				System.out.print(arr[r][c--]+" ");
			}
			
			//恢复c
			c++;
			
			//打印左 列c不变，r++到leftrow
			//由于左的第一个和最后一个元素已经在上和下中打印了 所以从r++开始 到小于leftrow
			r--;
			while(r>leftrow) {
				System.out.print(arr[r--][c]+" ");
			}
			//恢复
			r++;
			
			//边界变化到下一圈
			leftrow++;
			 leftcol++;
			rightrow--;
			rightcol--;
		}
	}
}
