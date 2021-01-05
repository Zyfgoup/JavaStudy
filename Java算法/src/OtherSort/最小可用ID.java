package OtherSort;

import java.util.Arrays;

/*
 * 在非负数组（乱序）中找到最小可分配的ID 从1开始编号，数据量为1000000
 * 思路：假设数组有序了 那么 在1 2 3 4 5 7....这样的数组下，最小可用的id是6，很明显当数组有序时，元素是==下标+1的，
 * 如果某个元素不相等了，那么该元素的值-1肯定就是最小可用的ID了
 */

public class 最小可用ID {
	public static void main(String[] args) {
		int[] arr= {101,1,5,3,4,6,8,9,};
		System.out.println(f2(arr));
	}
	
	//方法一：将数组排好序后，比较值与第几个数组是否相符，如果不符那么其值-1就是最小可用的ID
	public static int f1(int[] arr) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1)
				return arr[i]-1;
		}
		return arr.length+1;
	}
	
	//方法二：利用一个辅助空间，将元素的值作为辅助数组的下标，然后赋值为1，然后遍历辅助数组，第一个不为1的数据项则其下标就是最小可用ID
	//辅助空间的长度是原数组长度+1,那么抛弃下标为0的 方便计算
	public static int f2(int[] arr) {
		int[] helper = new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			//如果arr[i]的值大于数组的长度，很明显当排好序后，其值前面肯定有最小可用ID的存在，
			//所以没必要给辅助数组赋值，如果赋值会那么helper的长度只是n+1,就会产生越界
			if(arr[i]>arr.length)
				continue;
			else
				helper[arr[i]] = 1;
		}
		for(int i=1;i<helper.length;i++) {
			if(helper[i]!=1)
				return i;
		}
		return helper.length;//本来返回n+1，前面长度已经+1了
	}
	
	//方法三：利用找第K小值得方法来判断值与中间应该有的值是否一致，然后递归
	//至于出口问题，可用简单举个例子来获得，
	//当begin与end交错时，begin指向的值肯定是第一个与下标+1不符的，那么最小的ID就是begin+1了
	public static int f3(int[] arr,int begin,int end) {
		if(begin>end)
			return begin+1;
		int mid = (begin+end)/2;
		
		//找数组的第mid-begin+1小的值 也就是位于下标mid位置的值
		int p = 求出乱序数组的第K小的数字.selectK(arr, begin, end, mid-begin+1);
		
		int q = mid+1;//正常紧密情况下下标为mid的理想值
		
		//找到的值与理想值相等，那么意味着mid左边都是紧密的 没有最小可用的id了
		if(q==p)
			return f3(arr,mid+1,end);
		else
			return f3(arr,begin,mid-1);
	}
}
