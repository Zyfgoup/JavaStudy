package 深入递归;

import java.util.HashSet;
import java.util.Set;

/*
 * 1.输出合法的括号组合
 * 输入括号对数
 * 输出所有合法组合
 * 输入:3
 * 输出:()()(),((())),(()()),()(()),(())(),
 * 2.判断一个字符串是否合法
 * 
 * 
 * 如果只有一对括号  ()
 * 两对   可以在一对的基础上左右和括弧里面位置和最外面用括弧包起来 那么就是 ()() ()() (()) (()) 把重复的去除
 * 三对  就在两队的基础上每个的左右和左右括弧之间 (其实就是在左括弧后)
 * 
 * 根据不允许重复 那么可以用set来存
 * 
 * 核心都是逐步生成结果     
递归的话就是自下而上的从一般情况推广到复杂情况，然后再写成递归看起来是从自上而下的求解 但是底层还是自下而上一层一层往上返回结果
递推迭代 就是很能直观体现逐步生成结果的过程
 */



public class 合法括号 {
	public static void main(String[] args) {
		Set<String> set = f2(4);
		int count = 0;
		for(String s:set) {
			System.out.println(++count+","+s);
		}
		System.out.println(check("()(())(())",10));
	}
	
	//检查括弧是否是合法  n为字符串长度
	public static boolean check(String s,int n) {
		if(n%2!=0)
			return false;//不是偶数 则不可能配对
		
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(')
				count++;
			else if(s.charAt(i)==')')
				count--;
			else
				return false; //如果有别的字符就返回false
		}
		if(count!=0)//不为0则括弧不配对
			return false;
		
		
		return true;
		
		
	}
	
	//逐步生成之递归求解
	public static Set<String> f1(int n) {
		Set<String> set = new HashSet();
		
		if(n==1) {
			set.add("()");
			return  set;
		}
		
		Set<String> newSet = f1(n-1);//获取n-1个括弧的所有形式
		
		//遍历n-1个括弧的每个形式 然后往set里面按照左 右  里 外四种形式添加括弧 存进set里面 
		for(String s:newSet) {
			set.add("()"+s);//左边加
			set.add(s+"()");//右边加
			set.add("("+s+")");//外面包起来 其实外面包起来的情况也是在可以看成是插在里面的情况
			//( (())) )  和(( () ))这样是一样的
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') {
					set.add(s.substring(0, i+1)+"()"+s.substring(i+1));
					
					//第一个是0到i的子串  +上()再+上 i+1到末尾的子串
				}
			}
		}
		return set;
	}
	
	//递推迭代实现
	public static Set<String> f2(int n){
		Set<String> set = new HashSet();
		set.add("()");
		if(n==1) {
			return set;
		}
		
		for(int i=2;i<=n;i++) {
			Set<String> newSet = new HashSet();
			for(String s:set) {
				newSet.add("()"+s);//左边加
				newSet.add(s+"()");//右边加
				newSet.add("("+s+")");//外面包起来 其实外面包起来的情况也是在可以看成是插在里面的情况
				//( (())) )  和(( () ))这样是一样的
				
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)=='(') {
						newSet.add(s.substring(0, j+1)+"()"+s.substring(j+1));
						//第一个是0到i的子串  +上()再+上 i+1到末尾的子串
					}
				}
			}
			set = newSet;
		}
		return set;
	}
}
