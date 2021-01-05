package 递归与一些简单题目;
//把一个数组的若干个元素搬到数组的末尾，称之为数组的旋转，输入一个递增的数组的一个旋转，输出旋转数组的最小元素
//例如{1,2,3,4,5}旋转完后可以为{4,5,1,2,3}
//重要信息 递增有序的数组经过旋转，那么还是会有一部分是有序的
//所以要想到用二分查找法，效率较高
public class 旋转数组的最小数字 {
	public static void main(String[] args) {
		int[] arr= {3,3,3,1,1};
		System.out.println(f(arr));
	}
	//根据一些例子可以推测最小元素始终在二分查找无序的那一部分
	//比如54123-->541 -->41  51234-->51  34512-->512-->51
	public static int f(int[] arr) {
		int begin=0;
		int end=arr.length-1;
		if(arr[begin]<arr[end])return arr[begin];//考虑没有旋转的这种特殊旋转
		
		//只剩两个元素且是相邻情况下跳出循环 返回arr[end],
		while(begin+1<end) {
			int mid = (begin+end)/2;
			if(arr[mid]>=arr[begin]) //防止有重复
				begin=mid;//没有加1了
			else
				end = mid;
		}
		return arr[end];
	}
}
