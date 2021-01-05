package JavaSE;

/**
 * 动态规划  完全背包
 * 第一行是预算 第二行是物品种类n个
 * 然后n个物品分别是价格和价值
 *
 * 求预算内最大价值（一种物品可以不限制个数）
 */

/**
 * 100
 * 5
 * 77 92
 * 22 22
 * 29 36
 * 50 46
 * 99 90
 *
 * 114
 *
 * 200
 * 8
 * 79 83
 * 58 81
 * 86 54
 * 110 150
 * 62 52
 * 45 48
 * 68 62
 * 30 22
 *
 * 253
 *
 */

import java.util.*;

/**
 * @Author Zyfgoup
 * @Date 2020/8/1 15:25
 * @Description
 */
public class TestBestValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        int n = sc.nextInt();
        int[] price = new int[n];
        int[] value = new int[n];
        int[][] dp = new int[n+1][budget+1];
        int result = 0;


        for(int i=0;i<n;i++) {
            price[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        dp(budget,price,value,dp);


        System.out.println(dp[n][budget]);




    }

    /**
     *  dp 打表的方法，  dp[i][j]表示 可以选前i个物品的情况下  总重量为j  不超过j能选的最大价值
     */
    private static void dp(int budget, int[] price, int[] value, int[][] dp) {

        //初始化表的第一行  第一行只能选第一个物品 所以j>=w[0]的情况下 就可以将w[0]赋值给dp[0][j]
        for(int j=1;j<budget+1;j++) {
            if(j>=price[0]) {
                //能拿该物品 d
                dp[1][j] = value[0]*(j/price[0]);
            }
        }

        //表的第一列  总重量为0  所以都为0

        //其他行
        for(int i=2;i<dp.length;i++) {

            //j表示列 就是总重量
            for(int j=1;j<budget+1;j++) {

                //要的起该物品的情况下 又要分要和不要
                //i-1为第2行 对应计算的是第二个物品 那就下标为1 所以要i-1
                if(j>=price[i-1]) {
                    int i1 = value[i-1]+dp[i][j-price[i-1]];//选择当前物品后 再加上 剩余重量的就变成同一行 预算减掉的情况
                    int i2 = dp[i-1][j];//不拿该物品 那么就等于在能拿i-1个 总重量为j的情况下的最大价值
                    dp[i][j] = Math.max(i1, i2);
                }else {
                    //重量不够拿该物品
                    dp[i][j] = dp[i-1][j]; //那么就看选前i-1个
                }

            }
        }

    }
}
