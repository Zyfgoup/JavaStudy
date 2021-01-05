package 常用类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1.模拟一个trim方法，去除字符串两端的空格。

   2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”

   3.获取一个字符串在另一个字符串中出现的次数。
            比如：获取“ab”在 “abkkcadkabkebfkabkskab”
            中出现的次数

	4.获取两个字符串中最大相同子串。比如：
   str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
   
   5.对字符串中字符进行自然顺序排序。

练习：I am a student!   写一个方法：实现输出 !student a am I
spilt(" ")变成字符串数组

 */
public class StringDemo {
	public static void main(String[] args) {
		//test题目一
		String s1 = "   abc deg  ";
		String s11 = myTrim(s1);
		System.out.println(s11);
		System.out.println();
		
		//Test题目二
		String st1 = "abcdefg";
		String st11 = reverseString(st1,2,5);
		System.out.println(st11);
		System.out.println();
		
		//题目三
		int i = getTime("kkcadkabkebfkabkskab","ab");
		System.out.println(i);
		//题目四
		List<String> strs5 = getMaxSubString("abcwerthelloyuiodef","abcwecvhellobnm");
		System.out.println(strs5);
		//题目五
		String str6 = "aediewfn";
		String str7 = sort(str6);
		System.out.println(str7);
	}
	
	//5.对字符串中字符进行自然顺序排序。
	public static String sort(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	/*4.获取两个字符串中最大相同子串。比如：
   	str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
	 */
	public static List<String> getMaxSubString(String st1,String st2) {
		String max = (st1.length()>st2.length())? st1:st2;
		String min = (st1.length()<st2.length())? st1:st2;
		int len = min.length();
		List<String> list = new ArrayList<>();
		for(int i = 0;i<min.length();i++) {
			for(int x = 0,y = len-i;y <= len;x++,y++ ) {
				String str1 = min.substring(x,y);
				if(max.indexOf(str1) != -1) {
					 list.add(str1);
				}
			}
			if(list.size() != 0){
				return list;
			}
		}
		return null;
	}
	
	//3.获取一个字符串在另一个字符串中出现的次数。
    //比如：获取“ab”在 “kkcadkabkebfkabkskab”
    //中出现的次数
	public static int getTime(String str1,String str2) {
		int count = 0;
		int len;
		while((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len+str2.length());
		}
		return count;
	}
	//2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
	public static String reverseString1(String str,int start,int end){
		String str1 = str.substring(0, start);
		for(int i = end;i >= start;i--){
			char c = str.charAt(i);
			str1 += c;
		}
		
		str1 += str.substring(end + 1);
		return str1;
	}
	
	public static String reverseString(String str,int start,int end) {
		char[] c = str.toCharArray();
		return reverseArray(c,start,end);
	}
	public static String reverseArray(char[] c,int start,int end) {
		for(int i = start,j = end;i<j;i++,j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}
	//模拟一个trim方法，去除字符串两端的空格
	public static String myTrim(String str) {
		int start = 0;
		int end = str.length()-1;
		while(start<end&&str.charAt(start) == ' ') {
			//要有个范围限制，不然当字符串为全空格时，再++就越界了
			start++;
		}
		while(start<end&&str.charAt(end) == ' ') {
			end--;
		}
		return str.substring(start, end+1);//substring()方法的范围是左闭又开
	}
}
