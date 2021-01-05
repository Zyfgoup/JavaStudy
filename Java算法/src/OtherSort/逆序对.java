package OtherSort;
/*
 * 一个数列，如果左边的数大 右边的数小，则为一个逆序队，这道题求出给定数组有多少逆序对
 * 归并排序中的merge方法，当抓右侧子序列时，那么左侧子序列剩余所有的与right指向的元素都是逆序对
 * 虽然对数组排序了，但是计算逆序对是在排序之前计算好的，且小部排好序计算好了并不影响整体逆序对的计算
 * 因为当左右要计算逆序对时，左边又再分左右计算的逆序对也只是在左子序列范围的
 * 不太好用语言描述 看代码体会一下吧
 */
public class 逆序对 {
	static int[] helper ;
	static int count;
	public static void main(String[] args) {
		
	}
	
	//直接将归并排序的代码拷过来用
	//merge方法中辅助数组没有像第一次写的归并排序那样先按顺序插进辅助空间再拷贝到原数组
	public static int f1(int[] arr) {
		helper = new int[arr.length];
		sort(arr,0,arr.length-1);
		return count;
	}
public static void  sort(int[] arr,int begin,int end) {
		
		if(begin<end) {
			int mid = (begin+end)/2;
			//递归调用归并排序对两个子序列进行排序  注意这里不是mid-1了  mid也要包含进去排序了
			sort(arr,begin,mid);
			sort(arr,mid+1,end);
			merge(arr,begin,mid,end);
		}
	}

	private static void merge(int[] arr, int begin, int mid, int end) {
		
		//先将数组拷贝到辅助数组
		System.arraycopy(arr, begin, helper, begin, end-begin+1);
		//那么后面就是直接将辅助数组的左右子序列按比较插到原数组中
		//最后就不用再拷贝一次了
		
		
		int left = begin;//左边子序列的扫描指针
		int right = mid+1;//右边子序列的扫描指针
		
		//原数组的指针，指向需要填入数据的位置  
		//因为有可能 begin是传入的值是mid+1 ，那么填进辅助数组的开始的位置就是begin
		int current = begin;
		
		//那一边的数据项先扫到尾就跳出循环
		while(left<=mid&&right<=end) {
			if(arr[left]<=arr[right])
				//放进辅助数组之后 指针也要对应得移动
				arr[current++] = helper[left++];
			else{//抓右侧
				arr[current++] = helper[right++];
				count+=mid-left+1;//加上左子序列剩余的数据项
			}
		}
		
		//当右子序列的指针先扫到尾，防止左边子序列还有数据项没有入数组
		//不用考虑左边扫到尾，而右边还有没有入辅助数组的，即使右边还有，它在原数组中的位置也是正确的
		//因为很明显如果右边还有数据项，那么都是比左子序列都要大，所以它们本来就在正确的位置
		while(left<=mid)
			helper[current++] = arr[left++];	
	}
}
