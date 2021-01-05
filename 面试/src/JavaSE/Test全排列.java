package JavaSE;

/**
 * 一个正整数能被7整除 为亲7数
 * 给出一组 个位数字 请找出使用所有数字排列后列出的数中的亲7个数
 * 例子 给出{1,1,2}
 *
 *
 * {112,112}两个
 * 允许重复
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/8/1 15:47
 * @Description
 */
public class Test全排列 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};

        char[] chars = new char[arr.length];
        List<String> lists = new ArrayList<>();
        int count = 0;
        for(int i=0;i<arr.length;i++){

            chars[i] = String.valueOf(arr[i]).charAt(0);
        }

        digui(chars,0,lists);

        for (String s:
             lists) {
           if(Integer.valueOf(s)%7==0){
               count++;
           }

        }
        System.out.println(count);
    }

    private static void digui(char[] chars, int k, List<String> lists) {
        if(k==chars.length){
            StringBuilder builder = new StringBuilder(String.valueOf(chars));

            lists.add(builder.toString());
        }
        
        for(int i=k;i<chars.length;i++) {

            //把 从k开始的每一个都交换到k位置
            swap(chars, i, k);

            digui(chars, k + 1, lists);


            swap(chars, i, k);
        }

    }

    private static void swap(char[] strings, int i, int k) {
        char temp = strings[k];
        strings[k] = strings[i];
        strings[i] = temp;
    }




}
