package 字符串;
/*
 * 滚动hash法  O(n+m)
 * 对目标字符串按d进制求值,mod h 取余作为其hash
 * 对源串,依次求出m个字符的hash,保存在数组中(滚动计算)
 * 匹配时,只需比对目标串的hash值和预存的源串的hash值表
 */
public class RabinKarp {
	final static int seed = 31; 
	public static void main(String[] args) {
		 String s = "ABABABA";
		    String p = "ABA";
		    match(s, p);
	}
	
	public static void match(String s1,String s2) {
		long hash_s2 = hash(s2);
		
		//朴素法 但是时间复杂度高O(n*m)  因为每次要重复计算一些长串中字符的hash值
	    // int p_len = p.length();
	    // for (int i = 0; i+ p_len <= s.length(); i++) {
	    //   long hash_i = hash(s.substring(i,i+ p_len));//i起点,长度为plen的子串的hash值
	    //   if (hash_i==hash_p){
	    //     System.out.println("match:"+i);
	    //   }
	    // }
		
		long[] hash_s1 = hash(s1,s2.length());
		
		match(hash_s1,hash_s2);
	}

	private static void match(long[] hash_s1, long hash_s2) {
		for(int i=0;i<hash_s1.length;i++) {
			if(hash_s1[i]==hash_s2) {
				System.out.println("match:"+i);
			}
		}
		
	}

	
	//将短串求出hash值
	// 使用100000个不同字符串产生的冲突数，大概在0~3波动，使用100百万不同的字符串，冲突数大概110+范围波动。
	
	//求hash值 可以用：(((a*31)+b)*31)+c
	private static long hash(String s2) {
		long h=0;
		for(int i=0;i<s2.length();i++) {
			h = seed*h+s2.charAt(i);
		}
		return h%Long.MAX_VALUE;
	}
	
	//求出长串每n个字符hash值存入数组中
	private static long[] hash(String s2,int n) {
		long[] res = new long[s2.length()-n+1];//存放长串每n个字符哈希  长度注意
		
		res[0] = hash(s2.substring(0, n));//第一个位置存放前n个字符的哈希值
		
		//从第n个字符开始算后面每n个字符的哈希值
		for(int i=n;i<s2.length();i++) {
			
			//原理就是res[k] = res[k-1]*seed+newChar-前一个n长度串的首字符*seed的n次方 然后再取模Long.MAXVALUE
			char newChar = s2.charAt(i);
			char ochar = s2.charAt(i-n);
			long k = (long)(Math.pow(seed, n)*ochar);
			long v = (res[i-n]*seed+newChar-k)%Long.MAX_VALUE;
			res[i-n+1] = v;
			
		}
		
		return res;
		
	}
}
