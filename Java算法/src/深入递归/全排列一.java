package ����ݹ�;

import java.util.ArrayList;

/*
 * ��дһ��������ȷ��ĳ�ַ���������������ϡ�

 ����һ��string A��һ��int n,�����ַ������䳤�ȣ��뷵�����и��ַ����ַ������У�
 ��֤�ַ�������С�ڵ���11���ַ������ַ���Ϊ��дӢ���ַ���
 
 
�����ڽ���Ϸ����ŵ�˼·�������ַ�����Ȼ���ÿ���ַ�����ǰһ���ַ����Ѿ��õ��ļ��ϵ�ÿ���ַ����ĵ�ǰ�� ���� ������
�������Ϊһ���µ��ַ�����ӽ�������


һ�����ַ��������Ľ׳˸�   ����abdc  һ����4��=24

 */
public class ȫ����һ {
	public static void main(String[] args) {
		ArrayList<String> list = f2("abcd",3);
		int count = 0;
		for(String s:list) {
			System.out.println(++count+","+s);
		}
	}
	
	
	//������ ����
	public static ArrayList<String> f1(String s){
		ArrayList<String> res = new ArrayList();
		
		res.add(s.charAt(0)+""); //�ѵ�һ���ַ�������Ϊ��ʼ
		
		for(int i=1;i<s.length();i++) {
			char c = s.charAt(i);
			ArrayList<String> res_new = new ArrayList();
			//������һ���ַ�֮ǰ�õ��ļ���  Ȼ���ÿһ���ַ�������ǰ �� ��Ĳ��� ����Ϊһ���µ��ַ�����ӽ�res_new�������
			for(String str:res) {
				res_new.add(c+str);//ǰ��
				res_new.add(str+c);//����
				
				//����str��������ַ������ÿ���ַ�֮��
				for(int j=1;j<str.length();j++) {
					res_new.add(str.substring(0, j)+c+str.substring(j));
				}
			}
			
			res = res_new;//��ֵ�ظ�res,Ȼ�������һ���ַ��Ĳ���
		}
		
		return res;//����res
	}
	
	
	//�ݹ����
	public static ArrayList<String> f2(String s,int cur){
		ArrayList<String> newList = new ArrayList();
		if(cur==0) {
			newList.add(s.charAt(0)+"");
			return newList;
		}
		
		ArrayList<String> oldList = f2(s,cur-1);
		char c = s.charAt(cur);
		for(String str:oldList) {
			newList.add(c+str);//ǰ��
			newList.add(str+c);//����
			
			//����str��������ַ������ÿ���ַ�֮��
			for(int j=1;j<str.length();j++) {
				newList.add(str.substring(0, j)+c+str.substring(j));
			}
		}
		return newList;
		
	}
}
