package 动态规划and贪心;

import java.util.Scanner;

/*
字典序最小问题

给一个定长为N的字符串S,构造一个字符串T,长度也为N。

起初，T是一个空串，随后反复进行下列任意操作

1. 从S的头部删除一个字符，加到T的尾部
2. 从S的尾部删除一个字符，加到T的尾部

目标是最后生成的字符串T的字典序尽可能小

1≤N≤2000
字符串S只包含大写英文字母

输入：字符串S
输出：字符串T

POJ - 3617 要求每80个字符换行输出
 */

//假如输入是ACDBCB    输出时ABCBCD
//很明显，每次只能取头或者尾，那么谁小就取谁，如果相同就看下一个

//得到一个输入串的反串，用两个串比较大小 compareTo()方法，谁小取谁的首字母，直到长度到了n
public class 字典序最小 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			sb.append(cin.next());
		}
		f(sb.toString());
	}

	private static void f(String s) {
		String s1 = new StringBuffer(s).reverse().toString();
		StringBuffer sb1 = new StringBuffer();
		int N = s.length();
		int cnt = 0;
		while(sb1.length()<N ) {  //这里一开始用sb1.length()<s.length()来判断是错误的，因为s的长度是会随着取走字符而变的
			if(s.compareTo(s1)<=0) {
				sb1.append(s.charAt(0)); 
				s = s.substring(1);//更新 去掉首字符
			}else {
				sb1.append(s1.charAt(0));
				s1 = s1.substring(1);//更新
			}
			
			if(sb1.length()%80==0) {
				System.out.println(sb1.substring(cnt*80, (cnt+1)*80));
				cnt++;
			}
			
		}
		
		//剩余部分
		if(sb1.length()>cnt*80) {
			System.out.println(sb1.substring(cnt*80));
		}
		
	}
}
