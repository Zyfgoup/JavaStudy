package 深入递归;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * abc
 * 1：a跟a交换  不变  递归到b(k=1 i=1)  b跟b交换不变  递归调用到c(k=2,i=2) c跟c交换不变  再递归 调用k=3=arr.length 添加进res  
 * 然后回到 b  这时i=2 k=1  c跟b交换  这时是(acb)，然后递归 k=2 b跟b交换 继续递归 k=3添加进res  
 * 然后回到 k=2 i=2  c跟b换回来(回溯)  保持原状态(abc)
 * 
 * 然后回到一开始的最外层for循环  i=1 k=0 (b跟a)交换 然后继续递归下去  
 * 
 * 
 * 每次递归调用进入for循环第一次都是自身与自身交换 虽然不变 但是要确保添加进res里所以是有必要的
 * 因为可能上册的递归交换了位置 但后面的递归第一次交换都是自身与自身交换即使不变也是一种全排列
 * 
 */
public class 全排列二 {
	
	
	public static void main(String[] args) {
		ArrayList<String> res = f2("abcd");
		for(String s:res) {
			System.out.println(s);
		}
	}
	
	
	public static ArrayList<String> f2(String s){
		ArrayList<String> res = new ArrayList<>();
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		getPermutationCore(arr,0,res);
		return res;
	}


	private static void getPermutationCore(char[] arr, int k, ArrayList<String> list) {
		if(k==arr.length) {
			list.add(new String(arr));
		}
		
		for(int i=k;i<arr.length;i++) {
			
			swap(arr,k,i);//把从K开始的每个字符都交换到K位置，
			
			//arr[i]交换到k位置后  后面的字符变动位置也是一种排列 所以递归调用自身把从K+1开始后的每个字符换到K+1位置
			getPermutationCore(arr,k+1,list);//递归调用下一个
			
			swap(arr,k,i);//要换回来 保持初始状态一样  这个叫回溯
		}
		
	}


	private static void swap(char[] arr, int k, int i) {
		char temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
		
	}
}
