package OtherSort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * ��һ�����������������������ƴ����������ӡ��ƴ�ӳ���������������С��
 * {3��32,321}  321323
 */
public class �������ųɵ���С�� {
	public static void main(String[] args) {
		Integer[] arr= {3,32,321};
		System.out.println(f(arr));//321323
	}
	
	public static int f(Integer[] arr) {
		//���ձȽ�������������
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//�Ƚ��������������Ӻ�  ˭��˭С 
				//�����������С������˳������
				//���� 3 32  332>323 �����������32 3
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);

			}
		});
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]);
		}
		return Integer.parseInt(sb.toString());
	}
}
