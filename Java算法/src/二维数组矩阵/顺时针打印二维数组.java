package ��ά�������;
/*
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * 12348121615141395671110
 * 
 * ��bug
 */

public class ˳ʱ���ӡ��ά���� {

	public static void main(String[] args) {
		 int[][] arr = {
			        {1, 2, 3, 4, 5,6},
			        {14,15, 16,17,18, 7},
			        {13,12, 11, 10, 9, 8},
			        
			    };
		 f1(arr);
	}
	
	
	//��һȦ�ֳ��Ĳ��� �ֱ��ӡ�Ĳ��� ��������   Ȼ��ѭ������һȦ      �����ϽǺ����½���Ϊ���ֱ��������˳�ѭ��
	public static void f1(int[][] arr) {
		//�����Ĳ��ֵı߽�
		int leftrow = 0;
		int leftcol = 0;
		int rightrow = arr.length-1;
		int rightcol = arr[0].length-1;
		while(leftrow<=rightrow&&leftcol<=rightcol) {
			//���ƴ�ӡ
			int r = leftrow;
			int c = leftcol;
			
			//��ӡ�� ��r���� ��c++ ֱ��==rightcol
			while(c<=rightcol) {
				System.out.print(arr[r][c++]+" ");
			}
			//ѭ������֮��c��>rightcol�� ����Ҫ�ָ�������rightcol
			c--;
			
			//��ӡ�� ��c���䣬��r++��ֱ����ӡ�����һ�е���rightrow
			//��Ϊ�ұ��еĵ�һ��Ԫ���Ѿ������д�ӡ�ˣ����������r++��ʼ
			r++;
			while(r<=rightrow) {
				System.out.print(arr[r++][c]+" ");
			}
			
			//�ָ�r
			r--;
			
			//��ӡ�� ��r���䣬��c--��leftcol;
			//ͬ���µ����һ��Ԫ�������д�ӡ�� ���Դ�c--��ʼ
			c--;
			while(c>=leftcol) {
				System.out.print(arr[r][c--]+" ");
			}
			
			//�ָ�c
			c++;
			
			//��ӡ�� ��c���䣬r++��leftrow
			//������ĵ�һ�������һ��Ԫ���Ѿ����Ϻ����д�ӡ�� ���Դ�r++��ʼ ��С��leftrow
			r--;
			while(r>leftrow) {
				System.out.print(arr[r--][c]+" ");
			}
			//�ָ�
			r++;
			
			//�߽�仯����һȦ
			leftrow++;
			 leftcol++;
			rightrow--;
			rightcol--;
		}
	}
}
