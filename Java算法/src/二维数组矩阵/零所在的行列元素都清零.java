package 二维数组矩阵;
/*
 * 如果矩阵中某个元素为0，则其所在行列都清0
 * 
 * 注意不能每找到一个0就把所在行列所有元素清0，那样可能会把还没遍历到的0排除了
 * 
 * 应该先遍历一遍，把为0的行列先记录下来再清0
 */
public class 零所在的行列元素都清零 {
	public static void main(String[] args) {
	    int[][] arr = {
	            {1, 2, 3, 4, 100},
	            {5, 6, 7, 0, 101},
	            {9, 0, 11, 12, 102},
	            {13, 14, 15, 16, 103},
	            {104, 105, 106, 107, 103},
	        };
	    
	    f1(arr);
	    for(int i=0;i<arr.length;i++) {
	    	for(int j:arr[i]) {
	    		System.out.print(j+" ");
	    	}
	    	System.out.println();
	    }
	}
	
	public static void f1(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		
		//记录那些行列有元素为0
		int[] recZerorow = new int[n];
		int[] recZerocol = new int[m];
		
		//遍历数组
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					recZerorow[i] = 1;
					recZerocol[j] = 1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				//当前行或者列是被标记的那么该元素就赋值0	
				if(recZerorow[i]==1||recZerocol[j]==1)
					arr[i][j]=0;
			}
		}
	}
}
