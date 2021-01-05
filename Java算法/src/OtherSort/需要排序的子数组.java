package OtherSort;
/*
 * 给出一个数组，输出需要排序的最短子数组长度
 * 要求O(n)
 * 如输入 arr={2,3,7,5,4,6} 那么要排序最短的是7546  就返回4
 */
public class 需要排序的子数组 {
	public static void main(String[] args) {
		int[] arr={2,3,7,5,4,6};
		System.out.println(f(arr));
	}
	
	//要求时间复杂度为O(n) 那么就只能扫描一遍数组
	public static int f(int[] arr) {
		int p1 = -1;//记录右端
		int p2 = -1;//记录左端
		int max = arr[0];//历史最高峰
		int min = arr[arr.length-1];//历史最低谷
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max)
				max = arr[i];//只要大于就更新max
			
			//只要小于历史最高峰，那么该值就应该排序在最高峰的左侧，那么就要记录需要排序的最短子序列的右端位置
			if(arr[i]<max)
				p1 = i;
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			//小于最低谷就更新
			if(arr[i]<min)
				min = arr[i];
			
			//大于历史最低谷，那么该值就应该排在最低谷的右边，那么就要记录需要排序的子序列的左端位置
			if(arr[i]>min)
				p2 = i;
		}
		
		if(p1==-1) {
			//全是相等的数据项时或者整体有序时
			return 0;
		}
		return p1-p2+1;
	}
}
