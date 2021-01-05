package OtherSort;
/*
 * 输入一个数组，使得数组中的奇数位于数组的前半部分，偶数位于后半部分 时间复杂度要求是O(n)
 * 
 * 使用快速排序的双向扫描的方法
 */
public class 使数组奇数在左偶数在右 {
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1,54,9,73,67,10};
		f(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void f(int[] arr) {
		int left = 0;
		int right = arr.length-1;
		while(left<=right) {
			//注意边界
			while(left<=right&&arr[left]%2!=0)//是奇数就往右走
				left++;
			while(left<=right&&arr[right]%2==0)//是偶数往左走
				right--;
			if(left<right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	}
}
