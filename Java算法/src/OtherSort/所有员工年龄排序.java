package OtherSort;

import java.util.Scanner;

/*
 * 公司对几万名员工的年龄进行排序，因为公司的人数非常多，所以要求算法的效率要高，
 * 第一行输入n表示有n个员工
 * 输入第二行包括n个整数 年龄的范围是1——99
 * 输出排好序后的n个员工的年龄，每个年龄后有一个空格
 * 
 * 计数排序
 * 
 * 
 * */
public class 所有员工年龄排序 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] arr = new int[n];
		int[] helper = new int[100];//辅助数组  1到99 忽略0
		for(int i=0;i<n;i++) {
			arr[i] = cin.nextInt();
			helper[arr[i]]++;
		}
		
		int current = 0;
		for(int i=1;i<helper.length;i++) {
			//有重复的情况下
			while(helper[i]>0) {
				arr[current++] = i;
				helper[i]--;
			}
			
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
