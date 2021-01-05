package OtherSort;
/*
 * 给定数组arr和k,不重复打印arr中所有相加和为k的不降序二元组
 * arr = {-8,-4,-3,0,2,4,5,8,9,10} k=10
 * 输出(2,8)(0,10)
 * 
 * 关键：有序
 */
public class 排序数组中找和的因子 {
	public static void main(String[] args) {
		int[] arr = {-8,-4,-3,0,2,4,5,8,9,10};
		f(arr,10);
	}
	
	//O(n)
	public static void f(int[] arr,int k) {
		//两个指针
		int left = 0;
		int right = arr.length-1;
		
		//左右指针指向同一个元素就退出
		while(left!=right) {
			//左右相加小于k 那么左指针就向右移动
			if(arr[left]+arr[right]<k)
				left++;
			//相加相等就输出 并且左右指针都移动
			else if(arr[left]+arr[right]==k) {
				System.out.print(arr[left]+","+arr[right]+" ");
				left++;
				right--;
				
				//相加大于K 就右指针移动
			}else
				right--;
		}
	}
}
