package OtherSort;

//快速排序的划分方法来解决 ，  每次枢纽最后所在的位置即为其在有序数组的位置，那么它就是第p-begin+1小的值
//那么比较其跟k的大小，来继续判断时往右还是往左继续找
//注意的是往右找的时，begin为p+1了，那么k此时应该是k-(p-begin+1)
public class 求出乱序数组的第K小的数字 {
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1};
		System.out.println(selectK(arr,0,arr.length-1,3));
	}
	
	public static int selectK(int[] arr,int begin,int end,int k) {
		int p = partition2(arr,begin,end);
		//p-begin+1的值表示a[p]是数组中的第几下，因为下标从0开始
		if(k==p-begin+1)
			return arr[p];
		else if(k>p-begin+1)
			return selectK(arr,p+1,end,k-(p-begin+1));
		else
			return selectK(arr,begin,p-1,k);
		
		
	}
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
			while(left<=right&&arr[left]<=privot)//小于privot就往右移动
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
