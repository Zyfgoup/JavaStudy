package �ַ���;

import java.util.HashMap;
import java.util.Map;

/*
 * ѯ���������Ƿ�����ͬ���ַ�������  :�������ַ������е��ַ���һ����  ���п���������һ��
 * 
 * �����ü��������˼�� ��һ����������
 */
public class ��ͬ�ַ��� {
	public static void main(String[] args) {
		 boolean res = check("abcde", "deabccadcd");
		    System.out.println(res);
	}
	
	public static boolean check(String s1,String s2) {
		int[] help = new int[256];
		
		for(int i=0;i<s1.length();i++) {
			if(help[s1.charAt(i)]==0)
				help[s1.charAt(i)]=1;
		}
		
		for(int i=0;i<s2.length();i++) {
			if(help[s2.charAt(i)]==0)
				return false;//��һ���ַ���s1û�е�  ֱ��false
		}
		
		return true;
	}
	
	public  static boolean check2(String s1,String s2) {
		Map<Character,Integer> map = new HashMap();
		
		for(int i=0;i<s1.length();i++) {
			if(map.get(s1.charAt(i))==null)
				map.put(s1.charAt(i), 1);
		}
		
		for(int i=0;i<s2.length();i++) {
			if(map.get(s2.charAt(i))==null)
				return false;
		}
		
		return true;
	}
}
