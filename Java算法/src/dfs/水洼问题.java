 package dfs;

import java.util.Scanner;

/*
有一个大小为 N*M 的园子，雨后积起了水。八连通的积水被认为是连接在一起的。请求出
园子里总共有多少水洼？（八连通指的是下图中相对 W 的*的部分）

    ***
    *W*
    ***

限制条件

 N, M ≤ 100

 样例:

 输入
    N=10, M=12

园子如下图（'W'表示积水， '.'表示没有积水）

W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.

输出

    3

 */

//单个的W的是一个水洼,但是一个水洼可以往8个方向连通 连通之间的水洼要看成一个 所以上图有三个
public class 水洼问题 {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    char[][] a = new char[n][];
	    for (int i = 0; i < n; i++) {
	      a[i] = sc.next().toCharArray();
	    }
	    f1(a);
	}
	
	public static void f1(char[][] arr) {
		int cnt = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]=='W') {
					//重点在于消除法 把深搜到的W设成. 直到一个连通的水洼都被隔绝了找不到了W 就一直返回然后 cnt++
					//再继续遍历数组 找到下一个W继续深搜下去
					dfs(arr,i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	//这个dfs不用回溯因为找到一个水洼就本来要它消除 只是说可以连通的水洼都要看成一个水洼
	private static void dfs(char[][] arr, int i, int j) {
		
		arr[i][j] = '.';//消除法 既能把一个水洼全变成. 又能防止下一个连通的水洼往回寻找下一个水洼造成死循环
		
		
		//往八个方向去深搜是否有水洼,所以可以用8个if语句判断 但要注意边界
		//因为i,j都是最多-1或者+1或者其中一个不变 所以用for循环控制也可以
		for(int n=-1;n<2;n++) {
			for(int m=-1;m<2;m++) {
				
				//就原本位置 所以continue
				if(n==0&&m==0)
					continue;
				
				if(i+n>=0&&i+n<=arr.length-1&&j+m>=0&&j+m<=arr[0].length-1) {
					if(arr[i+n][j+m]=='W')//如果某个方向也是为水洼 那么就深搜下去
						dfs(arr,i+n,j+m);
				}
			}
		}
	}
}
