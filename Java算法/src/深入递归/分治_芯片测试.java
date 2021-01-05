package 深入递归;

import java.util.ArrayList;
import java.util.Random;

public class 分治_芯片测试 {
	public static void main(String[] args) {
		int num = 1;
		int[] state = {0,0,0,1,0,1,1,1,0,1,1};
		ArrayList<Xinpian> list = new ArrayList();
		Xinpian[] xx = new Xinpian[11];
		for(int i=0;i<xx.length;i++) {
			xx[i] = new Xinpian(num++,state[i]);
			list.add(xx[i]);
		}
		
		System.out.println(test(list));
	}
	
	
	public static int test(ArrayList<Xinpian> list) {
		int n = list.size();
		
		//有3个 随机拿两个测试
		if(n==3) {
			int result = judge(list.get(0),list.get(1));
			//不是都为好的结果则抛弃返回剩下的那一个
			if(result==1) {
				return list.get(2).num;
			}else//都为好的结果 那么只能是都是好的芯片 所以返回两个中的任意一个
				return list.get(0).num;
			
		}else if(n==2||n==1) {
			//剩下两个或者1个时肯定时都为好的芯片直接返回
			return list.get(0).num;
		}
		
		ArrayList<Xinpian> newList = new ArrayList();//存放剩余没淘汰的芯片进行递归测试
		if(n>3) {
			if(n%2==0) {
				newList = even(list); //为偶数时的淘汰方案
			}else
				newList = odd(list); //为奇数的淘汰
		}
		return test(newList);//递归调用
		
		
	}


	private static int judge(Xinpian x1, Xinpian x2) {
		int result = 0;
		Random random = new Random();
		if(x1.state==1) {
			result += x2.state; //x1为好的 那么测出来x2的结果时正确的 那么就是加上x2.state
		}else {
			result += random.nextInt(2); //[0,2)左闭又开 x1为假那么测x2的结果可能为1也可能为0
		}
		
		if(x2.state==1) {
			result += x1.state; //x2为好的 那么测出来x1的结果时正确的 那么就是加上x1.state
		}else {
			result += random.nextInt(2); //x2为假那么测x1的结果可能为1也可能为0
		}
		
		return result;
	}

	//奇数
	private static ArrayList<Xinpian> odd(ArrayList<Xinpian> list) {
		int size = list.size();
		ArrayList<Xinpian> newList = new ArrayList();
		Random random = new Random();
		int result = 0;
		//拿第一个跟其他剩余的测
		for(int i=1;i<size;i++) {
			if(list.get(i).state==1) {//为好
				result+=list.get(0).state;
			}else {
				result += random.nextInt(2);
			}
		}
		
		//如果list.get(0)为好，那么result的值肯定是大于等于size/2的，因为剩余n-1个芯片中好芯片大于等于坏芯片
	    //那么测这个芯片的结果肯定是1的多,那么result的值肯定大于等于size/2
		if(result>=size/2) {
			newList.add(list.get(0));
			return newList;
		}else {
			for(int i=1;i<size;i+=2) {
				int r = judge(list.get(i),list.get(i+1));
				if(r==2) {
					System.out.println(list.get(i).num);
					newList.add(list.get(i));//为(好，好)的结果 保留一个
				}
				//不为(好，好)则不添加进新list里
			}
			return newList;
		}
	}


	private static ArrayList<Xinpian> even(ArrayList<Xinpian> list) {
		int size = list.size();
		ArrayList<Xinpian> newList = new ArrayList();
		for(int i=0;i<size;i+=2) {
			int r = judge(list.get(i),list.get(i+1));
			if(r==2) {
				System.out.println(list.get(i).num);
				newList.add(list.get(i));//为(好，好)的结果 保留一个
			}
			//不为(好，好)则不添加进新list里
		}
		return newList;
	}
}

class Xinpian{
	public int num;//编号
	public int state;//1为好 0为坏
	
	public Xinpian(int num,int state) {
		this.num = num;
		this.state = state;
	}
}
