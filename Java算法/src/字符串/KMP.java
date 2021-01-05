package 字符串;
//判断字符串s1是否含有s2 的算法
public class KMP {
	public static void main(String[] args) {
		 String src = "babababcbabababb";
		    int count = indexOf1(src, "bababa");
		    System.out.println(count);
	}
	//KMP算法 O(m+n)
	//长串的扫描不用回到接下来的一个子串，而是根据短串的next数组来看失配位置前的最长匹配前缀为多少  则调到该下标再跟长串继续配对扫描
	//重点是理解next数组
	public static int indexOf1(String s1,String s2) {
		if(s1.length()==0||s2.length()==0)return -1;
		if(s2.length()>s1.length())return -1;
		
		int count = 0;
		int[] next = next(s2);

		for(int c=0;c<next.length;c++) {
			System.out.print(next[c]+" ");
		}
		System.out.println();
		int i =0;
		int j = 0;
		
		while(i<s1.length()) {
			//①如果j = -1，或者当前字符匹配成功（即s1[i] == s2[j]），都令i++，j++
			
		    //j=-1，因为next[0]=-1,说明p的第一位和i这个位置无法匹配，这时i，j都增加1，i移位，j从0开始
			if(j==-1||s1.charAt(i)==s2.charAt(j)) {
				i++;
				j++;
			}else {
				//②如果j != -1，且当前字符匹配失败（即s1[i] != s2[j]），则令 i 不变，j = next[j]
		        //next[j]即为j应该回到当前最长前缀的下标出 然后继续匹配
				j = next[j];
			}
			
			if(j==s2.length()) {
				//计算一共匹配了多少次 就是含有多少个
				count++;
				i--;
				j = next[j-1];
				
				//是否包含
				//return(i-j); //返回第一个字符的下标那么就是i-当前扫描了j个字符
			}
		}
		return count;
	}
	
	
	
	
	
	
	private static int[] next(String s2) {
		int[] next = new int[s2.length()];//后面是++i 不然数组越界
		char[] p = s2.toCharArray();
		
		//next[0]和next[1]是固定的-1 和0
		next[0] = -1;
		if(s2.length()==1)
			return next;
		next[1] = 0;
		
		//k肯定是小于j的 所以最长前缀不可以是整个子串
		int i = 1;
		int k = next[i];//i的最长匹配前缀为多少
		
		//如果i的字符与next[i]应该回到下标处即k处的下标相同 则next[i+1]=k+1
		//如果不相等就继续求next[k]应该回到何处的下标与i的字符相比
		//一直不相同就知道到k<0
		//只需要算到最后一个字符不匹配情况下的next  不用计算整个串的next 所以前面的next数组长度没有+1
		while(i<s2.length()-1) {
			//推出next[i+1] 根据i与k(next[i])
			if(k<0||p[i]==p[k]) {
				next[++i] = ++k;
			}else {
				k = next[k];
			}
		}
		return next;
	}
	
	
	
	
	//暴力法 两个指针分别指向s1 s2 返回在长串中第一个字符的下标
	//如果字符相同就同时遇动
	//如果不懂长串就回到下一个要扫描的串，短串回到0处
	public static int indexOf(String s1,String s2) {
		int i=0;//控制长串的子串
		int sc=i;//长串的扫描
		int j=0;//短串的扫描
		
		while(sc<s1.length()) {
			if(s1.charAt(sc)==s2.charAt(j)) {
				sc++;
				j++;
				//如果j等于s2.length那么就意味着全部配对了
				if(j==s2.length())
					return i;
			}else {
				i++;
				sc = i;
				j=0;
			}
		}
		return -1;
	}
}
