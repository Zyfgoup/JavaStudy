package 递归与一些简单题目;

public class 整数划分 {
	public static void main(String[] args) {
		System.out.println(f1(7,7,new StringBuffer("{")));
	}
	
	
	public static int f1(int n,int m,StringBuffer sb) {
		
		if(n<1||m<1) { //当n或者m小于1时  不满足为正整数的条件了 返回0
			//m=0了 那么就加个"}"输出
			System.out.println(sb.append("}").toString());
			
			return 0;
		}
		
		if(n==1||m==1) {//n==1时  不能再划分了   m==1时 划分方案只能为n个1相加
			
			// 有 1 的打印方案
			for(int i=0;i<n;i++) {
				sb.append(1+"+");
			}
			System.out.println(sb.deleteCharAt(sb.length()-1).append("}").toString());
			return 1;
			}
			
		
		if(n<m) { // m为划分方案的最大加数，所以m肯定要小于等于n的 当m大于n时  则变成求f1(n,n)的值
			
			return f1(n,n,sb);
		}
		
		if(n==m) {//当n==m时，有一种划分方案为 只有n本身，那么问题f1(n,m) = 1+f1(n,m-1); 
			
			//无1的方案打印   没有1的划分情况下   最后一个加数时 n,m 肯定是相等的 
			StringBuffer sb1 = new StringBuffer(sb); //不能直接写sb1 = sb 这样是地址的引用 得新new一个对象
			System.out.println(sb.append(n+"}").toString());
			
			
			return 1+f1(n,m-1,sb1);
		}
		
		
		//如果不是以上的四种情况 则问题变成求解f1(n,m-1)和f(n-m,m)
		//实际意义是要不要m这个最大加数 两种情况的和就为f1(n,m)的的值
		//f1(n-m,m) 可能会疑惑为什么取了m之后 最大加数仍为m, 因为最大加数比较小的时候可以取重复
		//就算比较大 m>n-m 那么递归调用也会满足上面的四种情况的其中一种 n<m 变成求解 f1(n-m,n-m);
		return f1(n,m-1,new StringBuffer(sb))+f1(n-m,m,new StringBuffer(sb.append(m+"+")));
	}
}
