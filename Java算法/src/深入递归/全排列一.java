package 深入递归;

import java.util.ArrayList;

/*
 * 编写一个方法，确定某字符串的所有排列组合。

 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
 保证字符串长度小于等于11且字符串中字符均为大写英文字符，
 
 
类似于解决合法括号的思路，遍历字符串，然后把每个字符插在前一个字符里已经得到的集合的每个字符串的的前面 后面 和里面
插入后都作为一个新的字符串添加进集合里


一共有字符的数量的阶乘个   比如abdc  一共有4！=24

 */
public class 全排列一 {
	public static void main(String[] args) {
		ArrayList<String> list = f2("abcd",3);
		int count = 0;
		for(String s:list) {
			System.out.println(++count+","+s);
		}
	}
	
	
	//逐步生成 迭代
	public static ArrayList<String> f1(String s){
		ArrayList<String> res = new ArrayList();
		
		res.add(s.charAt(0)+""); //把第一个字符插入作为初始
		
		for(int i=1;i<s.length();i++) {
			char c = s.charAt(i);
			ArrayList<String> res_new = new ArrayList();
			//遍历上一个字符之前得到的集合  然后对每一个字符串进行前 后 里的插入 都作为一个新的字符串添加进res_new这个集合
			for(String str:res) {
				res_new.add(c+str);//前面
				res_new.add(str+c);//后面
				
				//遍历str插在这个字符串里的每两字符之间
				for(int j=1;j<str.length();j++) {
					res_new.add(str.substring(0, j)+c+str.substring(j));
				}
			}
			
			res = res_new;//赋值回给res,然后进行下一个字符的插入
		}
		
		return res;//返回res
	}
	
	
	//递归求解
	public static ArrayList<String> f2(String s,int cur){
		ArrayList<String> newList = new ArrayList();
		if(cur==0) {
			newList.add(s.charAt(0)+"");
			return newList;
		}
		
		ArrayList<String> oldList = f2(s,cur-1);
		char c = s.charAt(cur);
		for(String str:oldList) {
			newList.add(c+str);//前面
			newList.add(str+c);//后面
			
			//遍历str插在这个字符串里的每两字符之间
			for(int j=1;j<str.length();j++) {
				newList.add(str.substring(0, j)+c+str.substring(j));
			}
		}
		return newList;
		
	}
}
