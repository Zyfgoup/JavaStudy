package �ַ���;

import java.util.Arrays;

/*
 * ���������ַ���  ȷ������һ���ַ��������к��ܱ������һ���ַ�
 * ���� Here you are  Are you here  ����false
 * ���δʣ�������������ͬ���ַ����������  adc adc  adc  cda 
 */
public class ���δ� {
	public static void main(String[] args) {
		String s1 = "Here you are";
		String s2 = "Are you here";
		
		//�������ַ���תΪ�ַ����� �������� Ȼ��Ƚ�
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		/*
		 * �������ָ���� char ������˴���ȣ��򷵻� true������������������ͬ������Ԫ�أ�
		 * �������������е�������ӦԪ�ضԶ�����ȵģ�����Ϊ��������������ȵġ����仰˵�����������������ͬ˳�������ͬ��Ԫ��
		 * ����������������ȵġ����⣬��������������ö�Ϊ null������Ϊ��������ȵġ�
		 */
		System.out.println(Arrays.equals(c1, c2));
	}
}
