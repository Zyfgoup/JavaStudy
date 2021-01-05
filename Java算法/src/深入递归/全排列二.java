package ����ݹ�;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * abc
 * 1��a��a����  ����  �ݹ鵽b(k=1 i=1)  b��b��������  �ݹ���õ�c(k=2,i=2) c��c��������  �ٵݹ� ����k=3=arr.length ��ӽ�res  
 * Ȼ��ص� b  ��ʱi=2 k=1  c��b����  ��ʱ��(acb)��Ȼ��ݹ� k=2 b��b���� �����ݹ� k=3��ӽ�res  
 * Ȼ��ص� k=2 i=2  c��b������(����)  ����ԭ״̬(abc)
 * 
 * Ȼ��ص�һ��ʼ�������forѭ��  i=1 k=0 (b��a)���� Ȼ������ݹ���ȥ  
 * 
 * 
 * ÿ�εݹ���ý���forѭ����һ�ζ��������������� ��Ȼ���� ����Ҫȷ����ӽ�res���������б�Ҫ��
 * ��Ϊ�����ϲ�ĵݹ齻����λ�� ������ĵݹ��һ�ν���������������������ʹ����Ҳ��һ��ȫ����
 * 
 */
public class ȫ���ж� {
	
	
	public static void main(String[] args) {
		ArrayList<String> res = f2("abcd");
		for(String s:res) {
			System.out.println(s);
		}
	}
	
	
	public static ArrayList<String> f2(String s){
		ArrayList<String> res = new ArrayList<>();
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		getPermutationCore(arr,0,res);
		return res;
	}


	private static void getPermutationCore(char[] arr, int k, ArrayList<String> list) {
		if(k==arr.length) {
			list.add(new String(arr));
		}
		
		for(int i=k;i<arr.length;i++) {
			
			swap(arr,k,i);//�Ѵ�K��ʼ��ÿ���ַ���������Kλ�ã�
			
			//arr[i]������kλ�ú�  ������ַ��䶯λ��Ҳ��һ������ ���Եݹ��������Ѵ�K+1��ʼ���ÿ���ַ�����K+1λ��
			getPermutationCore(arr,k+1,list);//�ݹ������һ��
			
			swap(arr,k,i);//Ҫ������ ���ֳ�ʼ״̬һ��  ����л���
		}
		
	}


	private static void swap(char[] arr, int k, int i) {
		char temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
		
	}
}
