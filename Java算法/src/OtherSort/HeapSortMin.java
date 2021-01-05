package OtherSort;
/*用数组来表示二叉树，根的下标为0，假设节点下标为i,那么该节点的左子节点下标为2*i+1,右子节点为2*i+2
 * 
 * 二叉堆是完全二叉树或者近似完全二叉树
 * 二叉堆满足：
 * 1.父节点的键值总是大于或者等于其任何一个子节点的键值
 * 2.每个节点的左子树和右子树 都是一个二叉堆
 * 
 * 任意节点的值都大于其子节点的值 --大顶堆  //大顶堆可用来堆排序中排小--->大
 * 任意节点的值都小于其子节点的值 -- 小顶堆 //排逆序
 * 
 * 
 * 堆排序：
 * 1.将数组按照大顶堆或者小顶堆进行堆化
 * 2.按序输出元素：把堆顶的位置与最末元素交换，然后调整堆顶元素
 * 
 * 
 * 时间复杂度：堆化：n/2次向下调整 每次向下调整时logn  所以是nlgn
 * 			排序：n次交换 每次向下调整也是logn  也是nlog
 *   因为是分开的 所以总的是  nlogn+nlogn 
 *   所以是O(nlogn)
 */
public class HeapSortMin {
	public static void main(String[] args) {
		int[] arr= {3,6,3,7,1,9,12,475,34,65,24};
		heapSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void heapSort(int[] arr) {
		//先对A进行堆化
		makeMinHeap(arr);
		//此时数组已经是小顶堆了
		
		//把堆顶与最后一个置元素交换位
		//交换之后缩小范围也就是每次都忽略掉与堆顶交换的元素，然后对堆进行向下调整保持堆化
		//然后重复进行 也就是遍历一般数组
		//注意x>=0
		for(int x=arr.length-1;x>=0;x--) {
			int temp = arr[0];
			arr[0] = arr[x];
			arr[x] = temp;
			//交换之后对堆顶进行向下调整
			//这里传入的n是数组的长度，因为x一开始就是arr.length-1
			//就算忽略掉最后那个元素 但是此时数组长度为x
			
			//这里长度是x-1 向下调整不能调整到交换的位置  且之后的都要把已经交换过的排除在外
			minHeapFixDown(arr, 0, x-1);
		}
	}
	
	
	//将数组堆化变成小顶堆
	public static void makeMinHeap(int[] arr) {
		//从最右边含有子节点的节点开始，然后不断往左 上一层继续
		//注意i>=0
		for(int i=arr.length/2-1;i>=0;i--) {
			minHeapFixDown(arr,i,arr.length);
		}
	}

	//向下调整使得数组成小顶堆
	//当i比较大时，调整节点键值大于子节点比较容易，但是当i比较小时，调整完i后i的子节点与其的子节点之间也要重新调整
	//就是不管怎杨从下往上调整成小顶堆时，当调整到i比较小时，一旦改变，那么下面的子节点孙节点也一样要调整
	//所以递归来解决向下调整
	public static void minHeapFixDown(int[] arr, int i, int n) {
		
		//找到左右孩子
		int left = 2*i+1;
		int right = 2*i+2;
		
		//左孩子下标越界那么就不需要比较了直接可以return了
		if(left>=n)
			return;
		
		//先将较小的孩子设为左孩子
		int min = left;
		
		//右孩子越界 那么较小孩子就直接是left
		if(right>=n)
			min = left;
		//否则就是左右孩子都不越界，那么就比较出较小的是哪个孩子
		else {
			if(arr[right]<arr[left])
				min = right;
		}
		
		//比较arr[i]与左右孩子中较小的，如果比min还小或者等于，那么不用调整，否则就交换
		if(arr[i]<=arr[min])
			return;
		else {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			//交换后那么还要递归进行向下调整
			minHeapFixDown(arr,min,n);
		}
	}
}
