package 动态规划and贪心;

import java.util.Arrays;

public class 钢条切割 {
	
		  static int n = 10;
		  static int[] p = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30};

		  static int[] vs = new int[n + 1];

		  
		  public static void main(String[] args) {
			  Arrays.fill(vs, -1);
			    int ans = r(n);
			    System.out.println(ans);
		}
		  /**
		   * @param x 钢条的长度
		   */
		  static int r(int x) {
		    if (x == 0) {
		      return 0;
		    }
		    int ans = 0;

		    for (int i = 1; i <= x; i++) {
		      if (vs[x - i] == -1)
		        vs[x - i] = r(x - i);

		      int v = p[i - 1] + vs[x - i];
		      ans = Math.max(v, ans);
		    }
		    vs[x] = ans;
		    return ans;
		  }
		  
}
