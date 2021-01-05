package 字符串;

import java.util.Arrays;

/*
 * 给定两个字符串  确定其中一个字符重新排列后能变成另外一个字符
 * 例如 Here you are  Are you here  返回false
 * 变形词：两个串具有相同的字符及数量组成  adc adc  adc  cda 
 */
public class 变形词 {
	public static void main(String[] args) {
		String s1 = "Here you are";
		String s2 = "Are you here";
		
		//把两个字符串转为字符数组 进行排序 然后比较
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		/*
		 * 如果两个指定的 char 型数组彼此相等，则返回 true。如果两个数组包含相同数量的元素，
		 * 并且两个数组中的所有相应元素对都是相等的，则认为这两个数组是相等的。换句话说，如果两个数组以相同顺序包含相同的元素
		 * ，则两个数组是相等的。此外，如果两个数组引用都为 null，则认为它们是相等的。
		 */
		System.out.println(Arrays.equals(c1, c2));
	}
}
