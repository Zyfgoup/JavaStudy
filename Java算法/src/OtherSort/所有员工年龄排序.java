package OtherSort;

import java.util.Scanner;

/*
 * ��˾�Լ�����Ա�����������������Ϊ��˾�������ǳ��࣬����Ҫ���㷨��Ч��Ҫ�ߣ�
 * ��һ������n��ʾ��n��Ա��
 * ����ڶ��а���n������ ����ķ�Χ��1����99
 * ����ź�����n��Ա�������䣬ÿ���������һ���ո�
 * 
 * ��������
 * 
 * 
 * */
public class ����Ա���������� {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] arr = new int[n];
		int[] helper = new int[100];//��������  1��99 ����0
		for(int i=0;i<n;i++) {
			arr[i] = cin.nextInt();
			helper[arr[i]]++;
		}
		
		int current = 0;
		for(int i=1;i<helper.length;i++) {
			//���ظ��������
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
