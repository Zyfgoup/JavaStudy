package 深入递归;

import java.util.HashSet;
import java.util.Set;


/*首先明白子串是连续的 子序列或者子集才可以是不连续的
 * 假设串是 abcd 那么子串有 a b c d  ab bc cd  abc bcd abcd  那么就可以外层一个循环遍历子串长度
 * 内层一个循环遍历数组  用substring这个方法 
 */
public class 非空子串 {
	public static void main(String[] args) {
		String s = "0100110001010001";
		System.out.println(f1(s));
	}
	
	public static int f1(String s) {
		Set<String> set = new HashSet();
		for(int i=1;i<=s.length();i++) {
			for(int j=0;j<s.length();j++) {
				if(j+i<=s.length())
					set.add(s.substring(j, j+i));
			}
		}
		
		return set.size();
	}
}
