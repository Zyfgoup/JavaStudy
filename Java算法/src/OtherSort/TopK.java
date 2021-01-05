package OtherSort;

import java.util.Arrays;
import java.util.Scanner;

/*
 求海量数据（正整数）按逆序排列的前k个数（topK），因为数据量太大，不能全部存储在内存中，只能一个一个地从磁盘或者网络上读取数据，
  请设计一个高效的算法来解决这个问题
 第一行：用户输入K，代表要求得topK
 随后的N（不限制）行，每一行是一个整数代表用户输入的数据
 用户输入-1代表输入终止
 请输出topK，从小到大，空格分割
 
 1.维持一个长度为k的数组先存入k个数据，然后继续读 当读到k+1时，就跟数组中最小的数比较，如果比min大就交换，小就不变
 当读到第k+2时，那么就跟新的数组中的最小值，那么时间复杂度就是先扫描K个数组  然后就是（n-k）*k算出最小值
 所以就是k +(n-k)*k
 
 2.就是当插入了k个数后，将这k个数构造成小顶堆， 因为后面继续输入的数要跟最小比较 所以为小顶堆
 如果改变了堆顶则向下调整
 那么时间复杂度就是 堆化：k/2*logk + 后面(n-k)次向下调整 就是（n-k）log(n-k)
 所以总体还是O(nlogn)
 */
public class TopK {
	static int k;
	static int[] heap ;
	static int index=0;//作为前k个输入插进heap里
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		k = cin.nextInt();
		heap = new int[k];
		int x = cin.nextInt();
		while(x!=-1) {
			deal(x);
			x = cin.nextInt();
		}
		System.out.println(Arrays.toString(heap));
	}
	
	private static void deal(int x) {
		if(index<k) {
			heap[index++] = x;
			if(index==k) {
				HeapSortMin.makeMinHeap(heap);
				index++;
			}
		}
		
		
		//不是当插入k个数后的下一次才进行堆化，如果代码如下则第k+1次进行了堆化，但没有进行比较操作
//		else if(index==k) {
//			HeapSortMin.makeMinHeap(heap);
//			index++;//防止再次堆化
//		}
		
		//当输入k+1个输后比较与堆顶的大小，把x的值代替堆顶的值  然后向下调整保持小顶堆
		else if(heap[0]<x){
				heap[0] = x;
				//对堆顶进行向下调整，且长度始终为k
				HeapSortMin.minHeapFixDown(heap, 0, k);
			}

	}
}
