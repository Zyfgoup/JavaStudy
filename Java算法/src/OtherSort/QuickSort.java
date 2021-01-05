package OtherSort;

/*
 * 快速排序：
 * 1.分解：选取数组a中一个元素a[p]将数组a[n]分成两部分，使得左边a[0...p-1]的值都小于a[p],右边a[p+1...r]的值都大于a[p]
 * 而a[p]中的p也是由划分过程中求得的
 * 2.解决：通过递归调用快速排序，对子数组a[0..p-1]和a[p+1...r]进行排序
 * 3.合并：因为子数组都是在原址(原本数组中)是有序的了，所以不需要再进行合并排序了
 * 
 * 所以快速排序关键在于划分这个方法
 * partiton()：每次都将数组的（子数组）的左侧第一个元素作为枢纽，
 * 将其他元素划分好后，再将枢纽与划分结束时扫描指针(并不是C++里面的指针，只是表示指向的意思)指向元素进行交换
 * 如果是单向扫描：最后则是begin与bigger交换
 * 如果是双向扫描:最后是begin与right交换
 * 但是将左侧第一个元素作为枢纽有一定的不适用处，如果每次枢纽在划分完后交换到的位置都处于数组的某一侧，
 * 而不是数组中间一点的位置，则时间复杂度会增大
 * 所以可以用三点中值法来决定枢纽是哪个元素
 * 
 * 三点中值法：比较数组最左端 中间位置 与最右端 三个元素，求出三个元素中的中值，将中值与最左端的数据项进行交换
 * 那么还是相当于将数组最左端作为枢纽，只不过这时候的枢纽是三个元素中的中值
 * 
 * 在Java的类库中 Arrays.sort()方法采用的就是快速排序
 * 不过在数据项比较少的时候是采用插入排序的
 * 
 * 时间复杂度是O(nlogn)
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1,54,9,73,67,10};
		quickSort(arr,0,arr.length-1);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void quickSort(int[] arr,int begin,int end) {
		//递归方法 也要注意边界 当begin=end时只有一个元素没必要进行排序了 
		if(begin<end) {
//			int p = partition1(arr,begin,end);
			int p = partition2(arr,begin,end);
			quickSort(arr,begin,p-1);
			quickSort(arr,p+1,end);
		}
	}

	
	//划分：单向扫描 从左往右 直到扫描指针遇到右侧的bigger指针
	public static int partition1(int[] arr, int begin, int end ) {
		int privot = arr[begin];//将第一个元素设为枢纽
		int sp = begin+1;//扫描指针      begin为枢纽所以是+1
		int bigger = end;
		
		//由于交换sp与bigger指向的元素后 bigger会--，那么边界就是sp>bigger
		while(sp<=bigger) {
			if(arr[sp]<=privot)//sp指向的元素小于privot的话sp就向右移动
				sp++;
			else {//扫描遇到大于privot的元素
				swap(arr,sp,bigger);//交换扫描指针与bigger的值
				//交换了后bigger往左移
				bigger--;
				
				//这里不需要担心交换时bigger位置的元素是否大于privot
				//因为sp在这次中没有变化，
				//如果交换成sp指向的元素还是大于privot，那么下一次循环sp还是没变，
				//还是sp与bigger交换，直到bigger向左扫到比privot小的元素，交换完成后，sp才会继续向右移动
			}
		}
		swap(arr,begin,bigger);//将枢纽与bigger指向的元素交换，因为最后bigger指向的肯定是小于privot的
		return bigger;//返回bigger
	}
	
	//划分：双向扫描 两边同时扫描 遇到小于/大于就停下，交换两个指针指向的元素，然后继续 直到 left>right
	public static int partition2(int[] arr,int begin,int end) {
		//求出三个元素中的中值
		int mid = (begin+end)/2;
		if(arr[begin]<=arr[mid]&&arr[begin]>=arr[end])
			swap(arr,begin,begin);
		else if(arr[end]<=arr[mid]&&arr[end]>=arr[begin])
			swap(arr,end,begin);
		else
			swap(arr,mid,begin);
		
		int privot = arr[begin];
		int left = begin+1;
		int right = end;
		while(left<=right) {
			//注意边界问题，left不能一直扫下去，而且right右边的元素肯定是大于privot的，所以是小于等于
			//在等于的时候再加上小于或者大于privot时也是符合的 这样才能出现left>right才能跳出最外层循环
			while(left<=right&&arr[left]<=privot)//小于等于privot就往右移动
				left++;
			while(left<=right&&arr[right]>privot)//大于privot就往右移动
				right--;
			
			
			if(left<right) //如果是等于指向同一个没有必要交换，
				//如果left大于right就不能进行交换了，因为大于privot的要在右侧，小于的要在左侧，一交换的话就相反了
				swap(arr,left,right);
		}
		swap(arr,begin,right);//交换枢纽与right的位置
		return right;//返回最后枢纽所在的下标
	}
	
	public static void swap(int[] arr,int x,int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
}
