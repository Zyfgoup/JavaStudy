package 递归与一些简单题目;
//有个排序好后的字符串数组，其中散布着一些空的字符串，编写一个方法，找到给定字符串的的索引


public class 在有空字符串中查找 {
	public static void main(String[] args) {
		String[] ss= {"a","","ab","","","cde","","jj","er",""};
		System.out.println(f(ss,"c"));
	}
	
	//重点排好序的，所以可以利用二分查找 降低时间复杂度
	public static int f(String[] ss,String s) {
		int begin = 0;
		int end = ss.length-1;
		
		while(true) {
			int mid = (begin+end)/2;
			
			while(ss[mid].equals("")){//如果为空字串就右移动，直到不是空的跳出循环
				mid++;
				//查找不到子串时 可以跳出循环
				if(mid>end)
					return -1;
			}
			
			if(ss[mid].compareTo(s)==0)
				return mid;
			else if(ss[mid].compareTo(s)>0)
				end = mid-1;
			else
				begin = mid+1;
		}
	}
}
