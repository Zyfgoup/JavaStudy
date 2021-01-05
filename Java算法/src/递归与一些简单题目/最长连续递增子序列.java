package 递归与一些简单题目;
//(1,9,2,5,7,3,4,6,8,0)中最长的递增子串为3468
//这题不是递归的应用，返回最长的长读，学了动态规划之后来输出最长
public class 最长连续递增子序列 {
	public static void main(String[] args) {
		int[] arr = {1,9,2,5,7,3,4,6,8,9};
		System.out.println(f(arr));
	}
	
	public static int f(int[] arr) {
		int start=0,end=0;
		int max=1;//记录递增序列的长度
		
		while(end<arr.length-1) {
			int temp = arr[end];
			if(temp<=arr[end+1]) {
				end++;
				
				//end到末尾了 要判断是不是长度比max是否要长
				if(end==arr.length-1) {
					if(end-start+1>max)
						max=end-start+1;
				}
			}
			else {
				if(end-start+1>max)
					max = end-start+1;
				start = end+1;
				end=start;
			}
				
		}
		return max;
	}
}
