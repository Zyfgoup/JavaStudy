package 网易笔试;

import java.util.*;

/**
 * @Author Zyfgoup
 * @Date 2020/8/8 15:47
 * @Description
 *
 * 给定n m
 * 然后再给m长度的数组
 * 求出n长度的最小字典序  要求(n长度的数组通过删减元素能变成m长度的数组)
 *
 * 当时理解错了  以为给出的数组的值可以随便取  但是好像根据别人的ac代码 发现最大只能是n
 * 所以
 * 5 2
 * 11 6 这样是不可以的  11和6都大于5了
 * 只能小于等于5 的
 *
 * 例如
 * 5 2
 * 4 2
 * 答案：13425
 *
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        Set<Integer> set = new TreeSet<>();
        int[] arr = new int[m];
        int[] res = new int[n];
        for(int i=0;i<m;i++){
            arr[i] = cin.nextInt();
            set.add(arr[i]);
        }

        int index =0; //遍历原数组下标
        int j= 0; //结果数组的下标

        //从1到n  复杂度O(nm)
        for(int k=1;k<=n;k++){

            //存在则跳过
            if(set.contains(k)){
                  continue;
            }else{
                //遍历到不存在于原数组的值

                //把原数组中小于当前k的先放进数组
                while(index<arr.length && arr[index]<k){
                    res[j++] = arr[index++];
                }

                    res[j++] = k;
            }
        }


        for(int i =0;i<res.length-1;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println(res[res.length-1]);
    }
}
