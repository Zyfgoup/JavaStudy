package OtherSort;

import java.util.Arrays;

/*
 * 输入两个字符串str1,str2，判断str1中的所有字符是否都在str2中
 * （不是连续包含）
 */
public class 字符串的包含 {
	public static void main(String[] args) {
		
	}
	
	//暴力解法 O(s1.length*s2.length)
	public static boolean f1(String s1,String s2) {
		for(int i=0;i<s1.length();i++) {
			char a = s1.charAt(i);
			if(s2.indexOf(a)==-1) {
				//如果有一个没有那就直接return false
				return false;
			}
		}
		return true;
	}
	
	//在暴力解法上优化一下(nlogn+m*logn)
	public static boolean f2(String s1,String s2) {
		//先对s2进行排序 然后再二分查找
		char[] ch = s2.toCharArray();
		Arrays.sort(ch);
		
		for(int i=0;i<s1.length();i++) {
			char c= s1.charAt(i);
			//二分查找
//			[1] 搜索值不是数组元素，且在数组范围内，从1开始计数，算键值在数组中的下标是多少是从1开始 得“ - 插入点索引值”；
//
//			[2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
//
//			[3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
//
//			[4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
	
			int index = Arrays.binarySearch(ch, c);
			if(index<0)
				return false;
		}
		return true;
	}
}
