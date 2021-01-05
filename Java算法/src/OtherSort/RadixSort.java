package OtherSort;
/*
 * 思路：是一种特殊的桶排序
 *      初始化0-9号十个桶
 *      一、按个位数字，将关键字入桶，入完后，依次遍历10个桶，按检出顺序回填到数组中，如
 *      321 322 331  500 423 476 926<br>
 *      0:500
 *      1:321 331
 *      2:322
 *      3:423
 *      4:无
 *      5:无
 *      6:476 926
 *      检出后数组序列为： 500 321 331 423 476 926，然后取十位数字重复过程一，得到
 *      0:500
 *      1:无
 *      2:321 423 926
 *      3:331
 *      4:无
 *      5:无
 *      7:476 
 *      检出后数组序列为： 500 321 423 926 331 476，然后取百位数字重复过程一，得到
 *      0:无
 *      1:无
 *      2:无
 *      3:321 331
 *      4:423 476
 *      5:500
 *      9:926 
 *      检出后数组序列为： 321 331 423 476 500 926，已然有序
 *        但是我们应该继续入桶，不过因为再高位全部是0了，这些元素会按顺序全部进入0号桶，这时0号桶的size==数组的size，这时结束标志<br>
 *      最后再回填到数组，数组就是升序排列的了
 *
 * 时间复杂度： 假设最大的数有k位，就要进行k次入桶和回填，每次入桶和回填是线性的，所以整体复杂度为kN,
 * 其中k为最大数的10进制位数
 * 空间复杂度：桶是10个，10个桶里面存n个元素，这些空间都是额外开辟的，所以额外的空间是N+k，k是进制
 * 肯定是非原址的了
 * 稳定性：假设有相等的元素，它们会次第入桶，次第回数组，不会交叉，所以是稳定的
 * 
 * 可以用队列来实现桶，先入先出， 且每次出桶是remove 也不用重新清空，但是用数组实现队列会存在一些没有使用到空间 增大空间复杂度
 * 用动态数组则不会
 */
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
	static ArrayList[] list = new ArrayList[10];//相当于动态的二维数组
	
	//静态块初始化每个桶
	static {
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList();
		}
	}
	public static void radixSort(int[] arr) {
		int d=1;
		int max = getMax(arr);
		
		//计算最大数是有几位
		int dNum = 1;
		while(max%10!=0) {
			dNum++;
			max/=10;
		}
		
		while(d<=dNum)
			//对什么位进行排序
			sort(arr,d++);
	}
	private static void sort(int[] arr, int d) {
		for(int i=0;i<arr.length;i++) {
				int k = (int)Math.pow(10, d-1);
				
				//取第几位上的数 插入桶里
				list[arr[i]/k%10].add(arr[i]);
		}
		
		//将按某位排好序后重新插入到数组中
		int current = 0;
		for(int j=0;j<list.length;j++) {
			for(int k=0;k<list[j].size();k++) {
				arr[current++] = (int) list[j].get(k);
			}
		}
		
		//清空
		for(int i=0;i<list.length;i++) {
			list[i].clear();
		}
		
	}
	public static int getMax(int[] arr) {
		int max = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		 int[] arr = {3,6,3,7,1,9,12,475,34,65,24};
		 radixSort(arr);
		 System.out.println(Arrays.toString(arr));
	}
}
