package 字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 前缀周期 {
	 public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    List<String> list = new ArrayList<String>();

		    while (true) {
		      int n = sc.nextInt();
		      if (n == 0) {
		        break;
		      }
		      String s = sc.next();
		      list.add(s);

		    }
		    for (int j = 0; j < list.size(); j++) {
		      String s = list.get(j);

		      int[] next = next(s);
		      System.out.println("Test case #" + (j + 1));
		      boolean flag = false;
		      //要求得的周期是最多的
		      for (int i = 2; i < next.length; i++) {
		        int k = next[i];//获得该位置前的最长前缀
		        //如果有周期性，那么其中前后缀肯定会有重叠
		        //所以i-k是周期最大的子串的长度
		        int t = i - k;
		        
		        //i%t==0的话则是周期的 且i/t要大于1才算周期
		        if (i % t == 0 && i / t > 1) {
		        	//所以输出串的长度i和周期最多的次数
		          System.out.println(i + " " + i / t);
		        }
		      }
		      System.out.println();
		    }
		  }

		  private static int[] next(String s) {
		    if (s == null || s.length() == 0) return null;
		    int[] next = new int[s.length() + 1];//这里要长度要多一位，因为有可能整个串都是周期的
		    next[0] = -1;
		    if (s.length() == 1)
		      return next;
		    next[1] = 0;
		    int j = 1;
		    int k = next[j];
		    while (j < s.length()) {
		      if (k == -1 || s.charAt(j) == s.charAt(k)) {
		        next[++j] = ++k;
		      } else {
		        k = next[k];
		      }
		    }
		    return next;
		  }
}
