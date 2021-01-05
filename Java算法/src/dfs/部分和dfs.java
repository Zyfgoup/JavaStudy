package dfs;

public class 部分和dfs {
	public static void main(String[] args) {
		int[]arr = {1,2,4,7};
		dfs(arr,13,0);
	}
	
	
	//从下标0开始 取不取该数字进行递归深搜
	//简单的输出Yes 如果要输出哪些数字用一个ArrayList存 记得回溯要remove掉
	public static void dfs(int[] arr,int k,int cur) {
		if(k==0) {
			System.out.println("Yes");
			System.exit(0);//找到唯一结果了不用返回不然又要逐渐每层返回
		}
		if(cur==arr.length||k<0)//cur到了数组边界或者k<0了就返回
			return;
		
		dfs(arr,k,cur+1);//不取  k不变
		
		dfs(arr,k-arr[cur],cur+1);//取arr[cur] 那么剩下的k-arr[cur]
	}
}
