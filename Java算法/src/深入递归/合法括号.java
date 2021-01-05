package ����ݹ�;

import java.util.HashSet;
import java.util.Set;

/*
 * 1.����Ϸ����������
 * �������Ŷ���
 * ������кϷ����
 * ����:3
 * ���:()()(),((())),(()()),()(()),(())(),
 * 2.�ж�һ���ַ����Ƿ�Ϸ�
 * 
 * 
 * ���ֻ��һ������  ()
 * ����   ������һ�ԵĻ��������Һ���������λ�ú������������������� ��ô���� ()() ()() (()) (()) ���ظ���ȥ��
 * ����  �������ӵĻ�����ÿ�������Һ���������֮�� (��ʵ��������������)
 * 
 * ���ݲ������ظ� ��ô������set����
 * 
 * ���Ķ��������ɽ��     
�ݹ�Ļ��������¶��ϵĴ�һ������ƹ㵽���������Ȼ����д�ɵݹ鿴�����Ǵ����϶��µ���� ���ǵײ㻹�����¶���һ��һ�����Ϸ��ؽ��
���Ƶ��� ���Ǻ���ֱ�����������ɽ���Ĺ���
 */



public class �Ϸ����� {
	public static void main(String[] args) {
		Set<String> set = f2(4);
		int count = 0;
		for(String s:set) {
			System.out.println(++count+","+s);
		}
		System.out.println(check("()(())(())",10));
	}
	
	//��������Ƿ��ǺϷ�  nΪ�ַ�������
	public static boolean check(String s,int n) {
		if(n%2!=0)
			return false;//����ż�� �򲻿������
		
		int count = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(')
				count++;
			else if(s.charAt(i)==')')
				count--;
			else
				return false; //����б���ַ��ͷ���false
		}
		if(count!=0)//��Ϊ0�����������
			return false;
		
		
		return true;
		
		
	}
	
	//������֮�ݹ����
	public static Set<String> f1(int n) {
		Set<String> set = new HashSet();
		
		if(n==1) {
			set.add("()");
			return  set;
		}
		
		Set<String> newSet = f1(n-1);//��ȡn-1��������������ʽ
		
		//����n-1��������ÿ����ʽ Ȼ����set���水���� ��  �� ��������ʽ������� ���set���� 
		for(String s:newSet) {
			set.add("()"+s);//��߼�
			set.add(s+"()");//�ұ߼�
			set.add("("+s+")");//��������� ��ʵ��������������Ҳ���ڿ��Կ����ǲ�����������
			//( (())) )  ��(( () ))������һ����
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') {
					set.add(s.substring(0, i+1)+"()"+s.substring(i+1));
					
					//��һ����0��i���Ӵ�  +��()��+�� i+1��ĩβ���Ӵ�
				}
			}
		}
		return set;
	}
	
	//���Ƶ���ʵ��
	public static Set<String> f2(int n){
		Set<String> set = new HashSet();
		set.add("()");
		if(n==1) {
			return set;
		}
		
		for(int i=2;i<=n;i++) {
			Set<String> newSet = new HashSet();
			for(String s:set) {
				newSet.add("()"+s);//��߼�
				newSet.add(s+"()");//�ұ߼�
				newSet.add("("+s+")");//��������� ��ʵ��������������Ҳ���ڿ��Կ����ǲ�����������
				//( (())) )  ��(( () ))������һ����
				
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)=='(') {
						newSet.add(s.substring(0, j+1)+"()"+s.substring(j+1));
						//��һ����0��i���Ӵ�  +��()��+�� i+1��ĩβ���Ӵ�
					}
				}
			}
			set = newSet;
		}
		return set;
	}
}
