package 网易笔试;

import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2020/8/8 16:21
 * @Description
 * 5个物品 分给两个人 要求两个人的物品价值一样 物品的个数不需要一致  剩下的丢掉 求最小的丢掉的物品价值和
 * 1
 * 5
 * 30 60 5 15 30
 *
 * 20
 * 第一个和第5个给其中一个人 第二个给第二个人
 * 剩下 三 四 丢了 所以 20
 *
 * 每个物品有三种情况  给第一个人 给第二个人 丢掉
 * 递归
 */
public class Main3 {
    static int sum = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            value[i] = cin.nextInt();
            sum += value[i];
        }

        dfs(value,0,0,0);

        System.out.println(min);
    }

    /**
     *
     * @param value 数组
     * @param i 下标
     * @param i1 第一个人的价值
     * @param i2 第二个人的价值
     */
    private static void dfs(int[] value, int i, int i1, int i2) {

        //分完了全部物品
        if(i==value.length) {
            if (i1 == i2) {
                //相等的情况可能有很多 要找出最小的丢弃价值
                min = Math.min(min, sum - i1 * 2);
            }
            return;
        }

        //第一个人拿
        dfs(value,i+1,i1+value[i],i2);

        //第二个人拿
        dfs(value,i+1,i1,i2+value[i]);

        //丢弃
        dfs(value,i+1,i1,i2);
    }
}
