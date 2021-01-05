package 深入递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*  
请编写一个方法，返回某集合的所有非空子集。

给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
保证A的元素个数小于等于20，且元素互异。

各子集内部从大到小排序,子集之间字典逆序排序

解决思路：用一个大集合包含所有的子集    一开始为空集  逐渐加每个字符  可以选择加与不加
假设集合为{1,2,3}
比如 一开始{{}}--》加1 {{},{1}}  --》  加2  每个子集合都要选择加与不加2 {{},{2},{1},{1,2}}...一直下去

保证不能有重复又用大集合包含小集合 所以用Set嵌套

核心都是逐步生成结果     
递归的话就是自下而上的从一般情况推广到复杂情况，然后再写成递归看起来是从自上而下的求解 但是底层还是自下而上一层一层往上返回结果
递推迭代 就是很能直观体现逐步生成结果的过程


*/
public class 非空子集 {
	 public static void main(String[] args) {
		    int[] A = {34,67,23};
		    Set<Set<Integer>> s1 = f2(A,3);
		    System.out.println(s1);
		  }

	 
	 //迭代的方法
	 public static Set<Set<Integer>> f2(int[] arr,int n){
		 Set<Set<Integer>> res = new HashSet();
		 Set<Integer> nil = new HashSet<>();//空集
		 res.add(nil);
		
		 for(int i=0;i<arr.length;i++) {
			 Set<Set<Integer>> newSet = new HashSet();
			 for(Set<Integer> set:res) {
				 newSet.add(set);//不添加arr[i]
				 
				 //克隆
				 Set<Integer> clone = (Set<Integer>) ((HashSet)set).clone();
				//这样就实现了该子集合添加arr[i]并添加进新的大集合中
				clone.add(arr[i]);
				newSet.add(clone);
				
			 }
			 res = newSet; //赋值回来
		 }
		 return res;

	 }
	 
	 
	 
	 
	 //增量构造法
	 public static Set<Set<Integer>> f1(int[] arr,int n){
		 Arrays.sort(arr);
		 return getF1Core(arr,n,n-1);
	 }

	 //递归增量构造法
	private static Set<Set<Integer>> getF1Core(int[] arr, int n, int cur) {
		Set<Set<Integer>> newSet = new HashSet();
		
		//输出会有空集合
/*		 if (cur == 0) {//处理第一个元素
		      Set<Integer> nil = new HashSet<>();//空集
		      Set<Integer> first = new HashSet<>();//包含第一个元素的集合
		      first.add(arr[0]);
		      newSet.add(nil);
		      newSet.add(first);
		      return newSet;
		    }*/
		
		//先把数组的每个元素作为初始化的所有子集合 就不会有子空集合
		if(cur==0) {
			for(int i=0;i<arr.length;i++) {
				Set<Integer> first = new HashSet();//包含第一个字符的子集
				first.add(arr[i]);
				newSet.add(first);
			}
			return newSet;			
		}
		
		Set<Set<Integer>> oldSet = getF1Core(arr,n,cur-1);//获取前一个已经处理好的包好所有子集合的一个大集合
	
		
		for(Set<Integer> set:oldSet) {
			newSet.add(set); //不添加 arr[cur]; 所以将这个子集合直接添加进新的大集合
		
			//那么要实现旧的该子集合set添加arr[cur] 则需重新创建一个Set克隆set
			//clone()方法是HashSet的  所以要先强制转换 然后返回的是Object类型的  又要强制转换成Set
			Set<Integer> clone = (Set<Integer>) ((HashSet)set).clone();
			
			//这样就实现了该子集合添加arr[cur]并添加进新的大集合中
			clone.add(arr[cur]);
			newSet.add(clone);
		}
		return newSet;
	}
	
	

}
