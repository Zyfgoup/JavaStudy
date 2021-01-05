package 深入递归;
/*
 * LeetCode60 n个数的排列组合找出字典序的第k个排列
 * The set[1,2,3,…,n]contains a total of n! unique permutations.
 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the k th permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.

 时间限制：1秒
 
 前提原字符数组按字典序是有序的 如果获取的输入的数据时无序的 得要先排序
 
 因为每次都从头扫描 (原字符数组有序的前提下)  所以获得的全排列是按字典序的  所以要求第K个 计算到count==k便可输出了
 
 */


public class 全排列三 {
	static int count =0;
	public static void main(String[] args) {
		char[] arr = new String("abbc").toCharArray();
		permutation("",arr,3);
	}
	
	public static void permutation(String prefix,char[] arr,int k) {
		if(prefix.length()==arr.length) {
			count++;
			if(count==k)
				System.out.println(k+":"+prefix);
			else
				System.out.println(prefix);
		}
		
		
		//每次从头扫描，只要该字符可用，就加到前缀里面，前缀就变长了  直到长度等于arr.length
		for(int i=0;i<arr.length;i++) {
			char c = arr[i];
			
			//如果前缀里c的个数少于原串那么就可以添加进去
			if(count(prefix,c)<count(arr,c)) {
				permutation(prefix+c,arr,k);
			}
		}
	}

	//计算c在原字符串一共有多少个
	private static int count(char[] arr, char c) {
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==c)
				cnt++;
		}
		return cnt;
	}

	//计算字符c在前缀里出现了多少次
	private static int count(String prefix, char c) {
		int cnt = 0;
		for(int i=0;i<prefix.length();i++) {
			if(prefix.charAt(i)==c)
				cnt++;
		}
		return cnt;
	}
	
}
