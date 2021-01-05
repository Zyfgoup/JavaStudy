package OtherSort;

import java.util.Arrays;

/*
 * ���������ַ���str1,str2���ж�str1�е������ַ��Ƿ���str2��
 * ����������������
 */
public class �ַ����İ��� {
	public static void main(String[] args) {
		
	}
	
	//�����ⷨ O(s1.length*s2.length)
	public static boolean f1(String s1,String s2) {
		for(int i=0;i<s1.length();i++) {
			char a = s1.charAt(i);
			if(s2.indexOf(a)==-1) {
				//�����һ��û���Ǿ�ֱ��return false
				return false;
			}
		}
		return true;
	}
	
	//�ڱ����ⷨ���Ż�һ��(nlogn+m*logn)
	public static boolean f2(String s1,String s2) {
		//�ȶ�s2�������� Ȼ���ٶ��ֲ���
		char[] ch = s2.toCharArray();
		Arrays.sort(ch);
		
		for(int i=0;i<s1.length();i++) {
			char c= s1.charAt(i);
			//���ֲ���
//			[1] ����ֵ��������Ԫ�أ��������鷶Χ�ڣ���1��ʼ���������ֵ�������е��±��Ƕ����Ǵ�1��ʼ �á� - ���������ֵ����
//
//			[2] ����ֵ������Ԫ�أ���0��ʼ������������ֵ������ֵ��
//
//			[3] ����ֵ��������Ԫ�أ��Ҵ���������Ԫ�أ�����ֵΪ �C (length + 1);
//
//			[4] ����ֵ��������Ԫ�أ���С��������Ԫ�أ�����ֵΪ �C 1��
	
			int index = Arrays.binarySearch(ch, c);
			if(index<0)
				return false;
		}
		return true;
	}
}
