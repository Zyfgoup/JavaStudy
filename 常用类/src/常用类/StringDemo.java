package ������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1.ģ��һ��trim������ȥ���ַ������˵Ŀո�

   2.��һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת�����罫��abcdefg����תΪ��abfedcg��

   3.��ȡһ���ַ�������һ���ַ����г��ֵĴ�����
            ���磺��ȡ��ab���� ��abkkcadkabkebfkabkskab��
            �г��ֵĴ���

	4.��ȡ�����ַ����������ͬ�Ӵ������磺
   str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
   
   5.���ַ������ַ�������Ȼ˳������

��ϰ��I am a student!   дһ��������ʵ����� !student a am I
spilt(" ")����ַ�������

 */
public class StringDemo {
	public static void main(String[] args) {
		//test��Ŀһ
		String s1 = "   abc deg  ";
		String s11 = myTrim(s1);
		System.out.println(s11);
		System.out.println();
		
		//Test��Ŀ��
		String st1 = "abcdefg";
		String st11 = reverseString(st1,2,5);
		System.out.println(st11);
		System.out.println();
		
		//��Ŀ��
		int i = getTime("kkcadkabkebfkabkskab","ab");
		System.out.println(i);
		//��Ŀ��
		List<String> strs5 = getMaxSubString("abcwerthelloyuiodef","abcwecvhellobnm");
		System.out.println(strs5);
		//��Ŀ��
		String str6 = "aediewfn";
		String str7 = sort(str6);
		System.out.println(str7);
	}
	
	//5.���ַ������ַ�������Ȼ˳������
	public static String sort(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	/*4.��ȡ�����ַ����������ͬ�Ӵ������磺
   	str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
	 */
	public static List<String> getMaxSubString(String st1,String st2) {
		String max = (st1.length()>st2.length())? st1:st2;
		String min = (st1.length()<st2.length())? st1:st2;
		int len = min.length();
		List<String> list = new ArrayList<>();
		for(int i = 0;i<min.length();i++) {
			for(int x = 0,y = len-i;y <= len;x++,y++ ) {
				String str1 = min.substring(x,y);
				if(max.indexOf(str1) != -1) {
					 list.add(str1);
				}
			}
			if(list.size() != 0){
				return list;
			}
		}
		return null;
	}
	
	//3.��ȡһ���ַ�������һ���ַ����г��ֵĴ�����
    //���磺��ȡ��ab���� ��kkcadkabkebfkabkskab��
    //�г��ֵĴ���
	public static int getTime(String str1,String str2) {
		int count = 0;
		int len;
		while((len = str1.indexOf(str2)) != -1) {
			count++;
			str1 = str1.substring(len+str2.length());
		}
		return count;
	}
	//2.��һ���ַ������з�ת�����ַ�����ָ�����ֽ��з�ת�����罫��abcdefg����תΪ��abfedcg��
	public static String reverseString1(String str,int start,int end){
		String str1 = str.substring(0, start);
		for(int i = end;i >= start;i--){
			char c = str.charAt(i);
			str1 += c;
		}
		
		str1 += str.substring(end + 1);
		return str1;
	}
	
	public static String reverseString(String str,int start,int end) {
		char[] c = str.toCharArray();
		return reverseArray(c,start,end);
	}
	public static String reverseArray(char[] c,int start,int end) {
		for(int i = start,j = end;i<j;i++,j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}
	//ģ��һ��trim������ȥ���ַ������˵Ŀո�
	public static String myTrim(String str) {
		int start = 0;
		int end = str.length()-1;
		while(start<end&&str.charAt(start) == ' ') {
			//Ҫ�и���Χ���ƣ���Ȼ���ַ���Ϊȫ�ո�ʱ����++��Խ����
			start++;
		}
		while(start<end&&str.charAt(end) == ' ') {
			end--;
		}
		return str.substring(start, end+1);//substring()�����ķ�Χ������ֿ�
	}
}
