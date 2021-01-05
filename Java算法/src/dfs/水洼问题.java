 package dfs;

import java.util.Scanner;

/*
��һ����СΪ N*M ��԰�ӣ���������ˮ������ͨ�Ļ�ˮ����Ϊ��������һ��ġ������
԰�����ܹ��ж���ˮ�ݣ�������ָͨ������ͼ����� W ��*�Ĳ��֣�

    ***
    *W*
    ***

��������

 N, M �� 100

 ����:

 ����
    N=10, M=12

԰������ͼ��'W'��ʾ��ˮ�� '.'��ʾû�л�ˮ��

W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.

���

    3

 */

//������W����һ��ˮ��,����һ��ˮ�ݿ�����8��������ͨ ��֮ͨ���ˮ��Ҫ����һ�� ������ͼ������
public class ˮ������ {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    char[][] a = new char[n][];
	    for (int i = 0; i < n; i++) {
	      a[i] = sc.next().toCharArray();
	    }
	    f1(a);
	}
	
	public static void f1(char[][] arr) {
		int cnt = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]=='W') {
					//�ص����������� �����ѵ���W���. ֱ��һ����ͨ��ˮ�ݶ����������Ҳ�����W ��һֱ����Ȼ�� cnt++
					//�ټ����������� �ҵ���һ��W����������ȥ
					dfs(arr,i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	//���dfs���û�����Ϊ�ҵ�һ��ˮ�ݾͱ���Ҫ������ ֻ��˵������ͨ��ˮ�ݶ�Ҫ����һ��ˮ��
	private static void dfs(char[][] arr, int i, int j) {
		
		arr[i][j] = '.';//������ ���ܰ�һ��ˮ��ȫ���. ���ܷ�ֹ��һ����ͨ��ˮ������Ѱ����һ��ˮ�������ѭ��
		
		
		//���˸�����ȥ�����Ƿ���ˮ��,���Կ�����8��if����ж� ��Ҫע��߽�
		//��Ϊi,j�������-1����+1��������һ������ ������forѭ������Ҳ����
		for(int n=-1;n<2;n++) {
			for(int m=-1;m<2;m++) {
				
				//��ԭ��λ�� ����continue
				if(n==0&&m==0)
					continue;
				
				if(i+n>=0&&i+n<=arr.length-1&&j+m>=0&&j+m<=arr[0].length-1) {
					if(arr[i+n][j+m]=='W')//���ĳ������Ҳ��Ϊˮ�� ��ô��������ȥ
						dfs(arr,i+n,j+m);
				}
			}
		}
	}
}
