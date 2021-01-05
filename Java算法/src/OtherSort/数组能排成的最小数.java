package OtherSort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 把一个正整数数组里的所有整数拼接起来，打印能拼接出的所有数字中最小的
 * {3，32,321}  321323
 */
public class 数组能排成的最小数 {
	public static void main(String[] args) {
		Integer[] arr= {3,32,321};
		System.out.println(f(arr));//321323
	}
	
	public static int f(Integer[] arr) {
		//按照比较器来排序数组
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//比较两个数据项连接后  谁大谁小 
				//两个数据项按照小的连接顺序排序
				//比如 3 32  332>323 所以排序后是32 3
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);

			}
		});
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}
}
