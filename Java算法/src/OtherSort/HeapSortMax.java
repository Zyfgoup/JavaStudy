package OtherSort;

public class HeapSortMax {

		public static void makeMaxHeap(int[] A) {
		  int n = A.length;
		   for (int i = n / 2 - 1; i >= 0; i--) {
		      MaxHeapFixDown(A, i, n);
		    }
		  }

		 public  static void MaxHeapFixDown(int[] A, int i, int n) {
		    // 找到左右孩子
		    int left = 2 * i + 1;
		    int right = 2 * i + 2;
		    //左孩子已经越界，i就是叶子节点
		    if (left >= n) {
		      return;
		    }
		    int max = left;
		    if (right >= n) {
		      max = left;
		    } else {
		      if (A[right] > A[left]) {
		        max = right;
		      }
		    }
		    //max指向了左右孩子中较大的那个

		    // 如果A[i]比两个孩子都要大，不用调整
		    if (A[i] >= A[max]) {
		      return;
		    }
		    //否则，找到两个孩子中大的，和i交换
		    int temp = A[i];
		    A[i] = A[max];
		    A[max] = temp;
		    //小孩子那个位置的值发生了变化，i变更为小孩子那个位置，递归调整
		    MaxHeapFixDown(A, max, n);
		  }

		public  static void heapSort(int[] A) {
		    //先对A进行堆化
		    makeMaxHeap(A);
		    for (int x = A.length - 1; x >= 0; x--) {
		      //把堆顶，0号元素和最后一个元素对调
		    	int temp = A[0];
		    	A[0] = A[x];
		    	A[x] = temp;
		      //缩小堆的范围，对堆顶元素进行向下调整
		      MaxHeapFixDown(A, 0, x);
		    }
		  }
		  public static void main(String[] args) {
		    int[] arr = {3,6,3,7,1,9,12,475,34,65,24};
			heapSort(arr);
			for(int i:arr) {
				System.out.print(i+" ");
			}
		  }
}
