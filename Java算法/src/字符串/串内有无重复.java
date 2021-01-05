package 字符串;
/*
 * 判断一个字符串里有没有重复的字符
 * 假设都是ACSII码的话 那么最多就128个  那么就可以采取计数排序的思路
 */
public class 串内有无重复 {
	public static void main(String[] args) {
		String s = "asdf";
		System.out.println(f1(s));
	}
	
	public static boolean f1(String s) {
		int[] flag = new int[128];
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(flag[c]>0)
				return false;
			else
				flag[c]++;
		}
		return true;
	}
}
