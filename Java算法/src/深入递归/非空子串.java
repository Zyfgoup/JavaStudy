package ����ݹ�;

import java.util.HashSet;
import java.util.Set;


/*���������Ӵ��������� �����л����Ӽ��ſ����ǲ�������
 * ���贮�� abcd ��ô�Ӵ��� a b c d  ab bc cd  abc bcd abcd  ��ô�Ϳ������һ��ѭ�������Ӵ�����
 * �ڲ�һ��ѭ����������  ��substring������� 
 */
public class �ǿ��Ӵ� {
	public static void main(String[] args) {
		String s = "0100110001010001";
		System.out.println(f1(s));
	}
	
	public static int f1(String s) {
		Set<String> set = new HashSet();
		for(int i=1;i<=s.length();i++) {
			for(int j=0;j<s.length();j++) {
				if(j+i<=s.length())
					set.add(s.substring(j, j+i));
			}
		}
		
		return set.size();
	}
}
