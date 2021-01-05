package OtherSort;


/*
 * 归并排序:
 * 将数组平均分成两个子序列
 * 对两个子序列进行递归排序
 * 合并已经排序好的两个子元素
 * 重点是合并  比如左右两边分别是13579  246810  要怎么才能合成12345678910
 * 可以用一个辅助空间来解决
 * 用一个新的数组，分别对比左右两组数据，每组从左端开始有一个指针，小的元素就添加进辅助数组，然后向右移动，
 * 再比较两个指针指向元素的大小...一直继续下去直到两个子序列都拍合并好
 * 然后再将辅助数组的元素一一赋值给原本需要排序的数据
 * 
 *  也可以在合并的方法里面一开始将原数组拷贝到辅助数组，那么之后的操作都是将辅助中的两个子序列扫描复制给原数组
 *
 * 非原址排序
 * 稳定性：所有排序都是归并，在左的永远在左，在右的永远在右，稳定
 */
public class MergeSort {
	static int[] helper;
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1,54,9,73,67,10};
		mergeSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	private static void mergeSort(int[] arr) {
		helper = new int[arr.length];
		sort(arr,0,arr.length-1);
		
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
		int left = begin;//左边子序列的扫描指针
		int right = mid+1;//右边子序列的扫描指针
		
		//原数组的指针，指向需要填入数据的位置  
		//因为有可能 begin是传入的值是mid+1 ，那么填进辅助数组的开始的位置就是begin
		int current = begin;
		
		//那一边的数据项先扫到尾就跳出循环
		while(left<=mid&&right<=end) {
			if(arr[left]<=arr[right])
				//放进辅助数组之后 指针也要对应得移动
				helper[current++] = arr[left++];
			else
				helper[current++] = arr[right++];
		}
		
		//当右子序列的指针先扫到尾，防止左边子序列还有数据项没有入数组
		//不用考虑左边扫到尾，而右边还有没有入辅助数组的，即使右边还有，它在原数组中的位置也是正确的
		//因为很明显如果右边还有数据项，那么都是比左子序列都要大，所以它们本来就在正确的位置
		while(left<=mid)
			helper[current++] = arr[left++];
		
		//再将辅助数组拷贝到原数组中 要拷贝的数组长度为从begin到current-1
		//因为前面赋值一次current都会++,所以这里还是<current
		for(int i=begin;i<current;i++) {
			arr[i] = helper[i];
		}
		
	}
}
