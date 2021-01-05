package 一些数学问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。
如果只有5个砝码，重量分别是1，3，9，27，81
则它们可以组合称出1到121之间任意整数重量（砝码允许放在左右两个盘中）。

本题目要求编程实现：对用户给定的重量，给出砝码组合方案。
例如：
用户输入：
5
程序输出：
9-3-1
用户输入：
19
程序输出：
27-9+1

要求程序输出的组合总是大数在前小数在后。
可以假设用户的输入的数字符合范围1~121。
* */

/*
 用天平称重时，我们希望用尽可能少的砝码组合称出尽可能多的重量。
 如果有无限个砝码，但它们的重量分别是1，3，9，27，81，……等3的指数幂
 神奇之处在于用它们的组合可以称出任意整数重量（砝码允许放在左右两个盘中）。

 本题目要求编程实现：对用户给定的重量，给出砝码组合方案，重量<1000000。
 例如：
 用户输入：
 5
 程序输出：
 9-3-1
 用户输入：
 19
 程序输出：
 27-9+1

 要求程序输出的组合总是大数在前小数在后。
 可以假设用户的输入一定是一个大于0的整数。
 */

public class 天平称重 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		
		String s = Integer.toString(n, 3);//把n转换成3进制然后转换成三进制
		
		//把三进制的翻过来方便计算
		char[] c = new StringBuilder(s).reverse().toString().toCharArray();
		
		List<Integer> list = new ArrayList();//存放最终结果的三进制数字  只能是1 0 -1 因为砝码不能重复 所以不能有
		//1代表正的  -1则代表减     
		for(int i=0;i<c.length;i++) {
			//为2 那么就+1 下一位就+1 身变为0本，然后再-1保持值不变  本身就变成了-1
			if(c[i]=='2') {
				//最新的都插在开头  前面插入的就会往后推
				//便于后面输出，因为一开始是翻转过来的
				list.add(0, -1);
				if(i==c.length-1) {
					list.add(0, 1);
				}else
					++c[i+1];//否则下一个数加1
				
			}else if(c[i]=='3') {
				list.add(0, 0);
				if(i==c.length-1)
					list.add(0, 1);
				else
					++c[i+1];
			}else
				list.add(0, c[i]-'0');
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==1)
				sb.append("+").append((int)Math.pow(3, list.size()-1-i));
			if(list.get(i)==-1)
				sb.append("-").append((int)Math.pow(3, list.size()-1-i));
		}
		
		System.out.println(sb.substring(1));
	}
}
