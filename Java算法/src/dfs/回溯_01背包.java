package dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 回溯_01背包 {
	static int n;//物品的数量
	static double c;//背包容量
	static double cw;//当前重量
	static double cp; //当前价值
	static double bestp;//当前最有价值
	
	static double cw1;//当前重量
	static double cp1; //当前价值
	static double bestp1;//当前最有价值
	
	public static void main(String[] args) {
		n=4;
		c=7;
		Scanner cin = new Scanner(System.in);
		goods[] goodss = new goods[n];
		for(int i=0;i<n;i++) {
			double w = cin.nextDouble();
			double p = cin.nextDouble();
			goodss[i] = new goods(i+1,w,p);
		}
		Arrays.sort(goodss);
		
		dfs(goodss,0); //先找出bestp
		System.out.println("最优价值为："+bestp);
		
		
		
		Backtrack(goodss,0,bestp);//根据已经找到的最优价值来找到最优解是哪些
		
	
	}

	private static void Backtrack(goods[] goodss, int i, double bestp) {
		if(i>=n) { //到达叶子节点
			bestp1 = cp1;
			if(bestp1 == bestp) {
				System.out.print("选择了：");
				for(int k=0;k<n;k++) {
					if(goodss[k].ischeck == true)
						System.out.print(goodss[k].num+" ");
				}
				System.exit(0);
			}
			return;
		}
		
		if(cw1+goodss[i].w<=c) {
			//当前重量加上第i个物品的重量小于等于背包容量就进入左子树
			cw1 += goodss[i].w;
			cp1 += goodss[i].p;
			goodss[i].ischeck = true;
			
			Backtrack(goodss,i+1,bestp);//深搜下一个
			
			//如果从下一层返回回来代表当前物品不选进背包
			cw1 -= goodss[i].w;
			cp1 -= goodss[i].p;
			goodss[i].ischeck = false;
			
		}
		
		//如果在不选当前物品 剩下从i+1到n个物品采用贪心选择策略装满背包的价值如果大于当前最优价值则进入右子树
		//进入右子树不代表bestp就一定是比之前的大
		if(Bound(goodss,i+1,cw1,cp1)>bestp1) {
			Backtrack(goodss,i+1,bestp);
		}
		
	}

	private static void dfs(goods[] goodss,int i) {
		if(i>=n) { //到达叶子节点
			bestp = cp;//将当前价值赋值给当前最优价值
			return;
		}
		
		if(cw+goodss[i].w<=c) {
			//当前重量加上第i个物品的重量小于等于背包容量就进入左子树
			cw += goodss[i].w;
			cp += goodss[i].p;

			dfs(goodss,i+1);//深搜下一个
			
			//如果从下一层返回回来代表当前物品不选进背包
			cw -= goodss[i].w;
			cp -= goodss[i].p;
			//goodss[i].ischeck = false; //如果这样标记的话 因为最后是return 还是会返回到最上层那么全部都是false了
			
		}
		
		//如果在不选当前物品 剩下从i+1到n个物品采用贪心选择策略装满背包的价值如果大于当前最优价值则进入右子树
		//进入右子树不代表bestp就一定是比之前的大
		if(Bound(goodss,i+1,cw,cp)>bestp) {
			dfs(goodss,i+1);
		}
	}

	private static double Bound(goods[] goodss, int i,double cw,double cp) {
		double cleft = c-cw;//背包剩余能装的容量
		
		double b = cp;
		
		while(i<=n-1&&goodss[i].w<=cleft) {
			cleft -= goodss[i].w;
			b += goodss[i].p;
			i++;
		}
		
		//最后一个装不进去  贪心则装一部分
		if(i==n-1) {
			b += goodss[i].p*cleft/goodss[i].w;
		}
		return b;
	}
}

class goods implements Comparable<goods>{
	 int num;//表示物品序号
	 double w;//物品重量数组
	 double p;//物品价值数组
	 double pw;//物品的单位价值
	 boolean ischeck = false;//是否被选
	
	
	public goods(int num,double w,double p) {
		this.num = num;
		this.w = w;
		this.p = p;
		pw = p/w;
	}

	@Override
	public int compareTo(goods o) {
		if(this.pw>o.pw)
			return 1;
		else if(this.pw<this.pw)
			return -1;
		else
			return 0;
	}
	
	
}
