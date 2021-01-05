package dfs;
/*
 * 问题描述:如果一个字符串包含两个相邻的重复子串，则称它为容易的串，其他串称为困难的串,
 * 如:BB，ABCDACABCAB,ABCDABCD都是容易的，A,AB,ABA,D,DC,ABDAB,CBABCBA都是困难的。

 输入正整数n,L，输出由前L个字符(大写英文字母)组成的，字典序第n小的困难的串。
 例如，当L=3时，前7个困难的串分别为:
 A,AB,ABA,ABAC,ABACA,ABACAB,ABACABA
 n指定为4的话,输出ABAC
 */
public class 困难的串 {
	static int count = 0;
	public static void main(String[] args) {
		 int n = 10;
		 int l = 4;
		 dfs(l, n, "");
	}
	
	//前缀法
	private static void dfs(int l, int n, String prefix) {
		for(char i='A';i<'A'+l;i++) {
			if(isHard(prefix,i)) {
				String s = prefix+i;
				System.out.println(s);
				count++;
				if(count==n) {
					System.exit(0);
				}
				//要保持字典序 一条路走到黑
				dfs(l,n,s);
			}
		}
		
	}

	//检查prefix + i会不会是简单串
	// ABACA i  第一次截取0长度prefix的后缀+i 与最后一个字母相比 相同就是简单串
	//第二次 截取1长度的prefix的后缀+i 与prefix除去前面截取的1长度的那个字符后的前2个字符  就是A+i  与AC比较
	//第三次截取2长度+i.....
	private static boolean isHard(String prefix, char i) {
		int count = 0;//表示截取的长度
		
		//a串每次要从prefix中拿多一个字符 从0开始  
		//这里注意j-=2
		//因为a串每次要从prefix多拿一个字符 那么长度+1了
		//拿走了的那个字符原本是在上一次的b串里
		//所以要j-2才能保证新的b串长度与a串相同
		for(int j=prefix.length()-1;j>=0;j-=2) {
			String a = prefix.substring(j+count+1)+i;
			String b = prefix.substring(j, j+count+1);
			if(a.equals(b))
				return false;
			
			//长度+1
			count++;
		}
		return true;
	}
}
