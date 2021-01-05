package dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/*
给定整数序列a1,a2,...,an,判断是否可以从中选出若干数,使它们的和恰好为k.
    1≤n≤20
    -10^8≤ai≤10^8
    -10^8≤k≤10^8
样例:
输入
    n=4
    a={1,2,4,7}
    k=13
输出:
    Yes (13 = 2 + 4 + 7)
*/


//非空子集的变形， 求出每个非空子集遍历每个子集如果结果为要求的k就返回那个set 然后把set变成Integer数组然后用Arrays.sort排序输出来
public class 部分和 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = cin.nextInt();
		}
		int k = cin.nextInt();
		
		Set<Integer> res = f2(arr,n,k);
		if(res.size()!=0) {
			Integer[] a = new Integer[res.size()];
			a = res.toArray(a);
			Arrays.sort(a, null);
			 System.out.print("Yes ("+k+" = ");
			 for(int i=0;i<a.length;i++) {
				 if(i!=a.length-1)
					 System.out.print(a[i]+" + ");
				 else
					 System.out.print(a[i]);
			 }
			 System.out.print(")\n");
		}
	}
	
	
	 public static Set<Integer> f2(int[] arr,int n,int k){
		 Set<Set<Integer>> res = new HashSet();
		 
//		 Set<Integer> nil = new HashSet<>();//空集
//		 res.add(nil);
		 
		 
		 //不含空子集
		 for(int i=0;i<arr.length;i++) {
			 Set<Integer> set = new HashSet();
			 set.add(arr[i]);
			 res.add(set);
		 }
		
		 int sum = 0;
		 for(int i=0;i<arr.length;i++) {
			 Set<Set<Integer>> newSet = new HashSet();
			 for(Set<Integer> set:res) {
				 newSet.add(set);//不添加arr[i]
				 for(int a:set) {
					 sum+=a;
				 }
				 if(sum==k) {
					return set;
				 }else
					 sum = 0;
				 
				 //克隆
				 Set<Integer> clone = (Set<Integer>) ((HashSet)set).clone();
				//这样就实现了该子集合添加arr[i]并添加进新的大集合中
				clone.add(arr[i]);
				newSet.add(clone);
				 for(int a:clone) {
					 sum+=a;
				 }
				 if(sum==k) {
					return clone;
				 }else
					 sum = 0;
				
			 }
			 res = newSet; //赋值回来
		 }
		 return new HashSet<Integer>();
	 }
}
