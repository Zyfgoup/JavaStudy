package 字符串;

import java.util.HashMap;
import java.util.Map;

/*
 * 询问两个串是否由相同的字符集生成  :即两个字符串含有的字符是一样的  但有可能数量不一样
 * 
 * 还是用计数排序的思想 用一个辅助数组
 */
public class 相同字符集 {
	public static void main(String[] args) {
		 boolean res = check("abcde", "deabccadcd");
		    System.out.println(res);
	}
	
	public static boolean check(String s1,String s2) {
		int[] help = new int[256];
		
		for(int i=0;i<s1.length();i++) {
			if(help[s1.charAt(i)]==0)
				help[s1.charAt(i)]=1;
		}
		
		for(int i=0;i<s2.length();i++) {
			if(help[s2.charAt(i)]==0)
				return false;//有一个字符是s1没有的  直接false
		}
		
		return true;
	}
	
	public  static boolean check2(String s1,String s2) {
		Map<Character,Integer> map = new HashMap();
		
		for(int i=0;i<s1.length();i++) {
			if(map.get(s1.charAt(i))==null)
				map.put(s1.charAt(i), 1);
		}
		
		for(int i=0;i<s2.length();i++) {
			if(map.get(s2.charAt(i))==null)
				return false;
		}
		
		return true;
	}
}
