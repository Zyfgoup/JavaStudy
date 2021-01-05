package OtherSort;

import java.util.Arrays;

/*用辅助数组把数组中出现的的数字计数，元素转下标，再下标转元素
 * 假设元素全部都大于0，依次扫描原数组，将元素值k记录在辅助数组的k位置上，
 * 依次扫描辅助数组，如果为1，将其插入到目标数组上
 * 如果有重复数组，那么就k位置上继续++
 * 如果有负数，那么就将数组中所有的数都加上一个数，使其全部大于0，最后再减去就可以了
 * 
 * 
 * 辅助空间的长度是原始数组中的最大的+1，+1是为了方便计算
 * 
 * 时间复杂度是O(n+k)  k是辅助数组的长度
 * 但是空间复杂度比较高 O(k)
 */
public class CountSort {
	public static void main(String[] args) {
		 int[] arr = {3,6,3,7,1,9,12,475,34,65,24};
		 sort(arr);
		 System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int helper[] = new int[getMax(arr)+1];
		for(int i=0;i<arr.length;i++) {
			//值作为辅助数组的下标
			helper[arr[i]]++;
		}
		
		int current = 0;
		for(int i=1;i<helper.length;i++) {
			//解决有重复的问题
			while(helper[i]>0) {
				arr[current++] = i;
				//--保证如果没有重复就继续下一个
				helper[i]--;
			}
		}
		
	}
	public static int getMax(int[] arr) {
		int max = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
}
