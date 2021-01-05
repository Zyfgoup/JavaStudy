package 动态规划and贪心;

public class 电路布线 {
	public static void main(String[] args) {
		int[] c = {0,8,7,4,2,5,1,9,3,10,6};//长度为11  
		int n = 10;
		int[][] size = new int[n+1][n+1];//size[i][j]表示上端1-i下端1-j中按照题目给的连线方式 一共有多少条不相交的
		MNS(c,n,size);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(size[i][j]+" ");
			}
			System.out.println();
		}
		
		int[] net = new int[size[n][n]];
		traceBack(c,n,net,size);	
		for(int i=0;i<net.length;i++) {
			System.out.print(net[i]+" ");// 9 7 5 3
		}
	}
	
	public static void MNS(int[] c,int n,int[][] size) {
		for(int j=0;j<c[1];j++)
			size[1][j] = 0;
		for(int j=c[1];j<=n;j++) {
			size[1][j] =1;
		}
		
		for(int i=2;i<n;i++) {//不等于n  最后一行省去一些不必要的计算了
			for(int j=0;j<c[i];j++)
				size[i][j]=size[i-1][j]; //j<c[i]时 表示当前i,c[i]还没连上 所以赋值size[i-1][j]的值
			for(int j=c[i];j<=n;j++) {
				//当能连上时  
				//则判断当连上当前这条线再加上前1:i-1和1：c[i]-1的最大不相交线
				//和不要当前这条线 前1:i-1和1：j的最大不相交前
				//谁的值比较大
				size[i][j] = Math.max(size[i-1][j], size[i-1][c[i]-1]+1);
			}
		}
		size[n][n] = Math.max(size[n-1][n], size[n-1][c[n]-1]+1);
	}
	
	public static void traceBack(int[] c,int n,int[] net,int[][] size) {
		int j=n;
		int m=0;
		for(int i=n;i>1;i--) {
			if(size[i][j]!=size[i-1][j]) {//不等于舍弃当前这条(n,c[n])的情况下 那么就表示该条是属于最大不相交子集里的一个元素
				net[m++] = i;
				j=c[i]-1; // 因为不等于size[i-1][j]  那么size[i][j]肯定等于 size[i-1][c[i]-1]+1  这个+1就代表本条是最大不相交里的一条连线
			}
			
		}
		//前面只构造到第i=2 如果继续i=1那么当i=0时全为0 
		//所以单独判断 如果j大于等于c[1] 那么1 c[1]也是解的一个元素
		if(j>=c[1])
			net[m++]=1;
	}
}
