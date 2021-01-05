package OtherSort;

import java.util.Arrays;

/*
 * 1.因为数字超过一半，那么如果数组有序的话，可以左侧重复的数字占据一半多，也可以是右侧的
 * 那么中间位置的元素肯定是要求的数字 所以时间复杂度为O（nlogn）
 * 2.既然排好序后的第n/2+1个元素就是要求的值，那么就相当于找数组中的第n/2+1小的值；O(n)
 * 如果求第n/2小的值，如果长度为奇数，那么求得并不一定是答案，如果重复的值是在右侧的话，所以必须是第n/2+1个数，
 * 
 * 3.消除法，两两不同的数进行消除,用一个变量来计数一开始设置为1,将第一个数设置为候选，比较第二个数与其是否一样，不一样则计数--；相同++
 * 如果计数为0了，那么就表示前面两个或者多个数字已经消除完了，表示要么没有重复的，要么重复的值与不重复的值刚好相等
 * 所以设置新的候选，计数为1，继续前面的操作
 * 直到遍历完数组，返回候选
 * 重复的数超过一半，所以不管怎么最后候选都是为要求的值
 * 只遍历一遍数组 时间复杂度为O(n),且不需要改变原数组
 */
public class 超过一半的数字 {
	public static void main(String[] args) {
		int[] arr= {1,2,1,1,3};
		System.out.println(f1(arr));
		System.out.println(f2(arr));
		System.out.println(f3(arr));
		System.out.println(f4(arr));
	}
	
	public static int f1(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length/2];
	}
	public static int f2(int[] arr) {
		 int res = 求出乱序数组的第K小的数字.selectK(arr, 0, arr.length-1, arr.length/2+1);
		 return res;
	}
	
	//同类型题目 水王  
	public static int f3(int[] arr) {
		int condidate = arr[0];//先设置候选数
		int nTimes = 1;
	//遍历一遍数组 从下标为1 开始，因为0一开始作为候选
		for(int i=1;i<arr.length;i++) {
			//如果标记的数值为0时表示前面的都消除了
			if(nTimes==0) {
				//设置新的候选
				condidate = arr[i];
				//从0变成1
				nTimes = 1;
			}else if(arr[i]==condidate)
				nTimes++;
			else
				//与候选不同
				nTimes--;
		}
		return condidate;
	}
	
	//水王题目的变化  如果恰好为一半呢
	//刚好一半就没法用中间位置来求得了
	/*
	 * 分析：水王占一半，那么总数肯定为偶数
	 * 如果隔一个数就是水王的id,那么两两消减最后一定为0，
	 * 在这种情况下：（1a2a3a）(a1a2a3)
	 * 水王有可能是最后一个元素，那么每次扫描的时候，需要跟最后一个元素比较一下是否相等
	 * 如果水王不是最后一个元素，那么就去掉最后一个元素，那么就是留下的condidate
	 * 
	 * 如果不是隔一个就是水王，而是杂乱的话，那么互相之间已经消减了一些了，最后肯定是跟超过一半一样的结果最后的condidate是水王
	 */
	public static int f4(int[] arr) {
		int condidate = arr[0];//先设置候选数
		int nTimes = 1;
		int countOfLast = 0;
	//遍历一遍数组 从下标为1 开始，因为0一开始作为候选
		for(int i=1;i<arr.length;i++) {
			//与最后一个数比较一下，相同就++，如果最后计数的值为长度的一半，那么最后一个元素就是要求的值
			//最后一个数与自己本身也要对比所以也会++
			if(arr[i] == arr[arr.length-1])
				countOfLast++;
			
			//如果标记的数值为0时表示前面的都消除了
			if(nTimes==0) {
				//设置新的候选
				condidate = arr[i];
				//从0变成1
				nTimes = 1;
			}else if(arr[i]==condidate)
				nTimes++;
			else
				//与候选不同
				nTimes--;
		}
		if(countOfLast==arr.length/2)
			return arr[arr.length/2];
		else
		return condidate;
	}
}
