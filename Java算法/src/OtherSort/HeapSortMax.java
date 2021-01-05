package OtherSort;

public class HeapSortMax {

		public static void makeMaxHeap(int[] A) {
		  int n = A.length;
		   for (int i = n / 2 - 1; i >= 0; i--) {
		      MaxHeapFixDown(A, i, n);
		    }
		  }

		 public  static void MaxHeapFixDown(int[] A, int i, int n) {
		    // �ҵ����Һ���
		    int left = 2 * i + 1;
		    int right = 2 * i + 2;
		    //�����Ѿ�Խ�磬i����Ҷ�ӽڵ�
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
		    //maxָ�������Һ����нϴ���Ǹ�

		    // ���A[i]���������Ӷ�Ҫ�󣬲��õ���
		    if (A[i] >= A[max]) {
		      return;
		    }
		    //�����ҵ����������д�ģ���i����
		    int temp = A[i];
		    A[i] = A[max];
		    A[max] = temp;
		    //С�����Ǹ�λ�õ�ֵ�����˱仯��i���ΪС�����Ǹ�λ�ã��ݹ����
		    MaxHeapFixDown(A, max, n);
		  }

		public  static void heapSort(int[] A) {
		    //�ȶ�A���жѻ�
		    makeMaxHeap(A);
		    for (int x = A.length - 1; x >= 0; x--) {
		      //�ѶѶ���0��Ԫ�غ����һ��Ԫ�ضԵ�
		    	int temp = A[0];
		    	A[0] = A[x];
		    	A[x] = temp;
		      //��С�ѵķ�Χ���ԶѶ�Ԫ�ؽ������µ���
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
