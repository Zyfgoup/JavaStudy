package 网易笔试;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Zyfgoup
 * @Date 2020/8/8 14:58
 * @Description 求给定数组中 每个数拆分成的素数和为a[i]  最多的素数 本事数素数可以不拆
 * 3
 * 5 3 9
 * 6
 *
 * 1不是素数 返回0
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        long[] arr = new long[n];
        long count=0;
        for(int i=0;i<n;i++){
            arr[i] = cin.nextInt();
            count = arr[i]/2;

        }



        System.out.println(count);


    }




}
