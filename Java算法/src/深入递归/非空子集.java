package ����ݹ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*  
���дһ������������ĳ���ϵ����зǿ��Ӽ���

����һ��int����A������Ĵ�Сint n���뷵��A�����зǿ��Ӽ���
��֤A��Ԫ�ظ���С�ڵ���20����Ԫ�ػ��졣

���Ӽ��ڲ��Ӵ�С����,�Ӽ�֮���ֵ���������

���˼·����һ���󼯺ϰ������е��Ӽ�    һ��ʼΪ�ռ�  �𽥼�ÿ���ַ�  ����ѡ����벻��
���輯��Ϊ{1,2,3}
���� һ��ʼ{{}}--����1 {{},{1}}  --��  ��2  ÿ���Ӽ��϶�Ҫѡ����벻��2 {{},{2},{1},{1,2}}...һֱ��ȥ

��֤�������ظ����ô󼯺ϰ���С���� ������SetǶ��

���Ķ��������ɽ��     
�ݹ�Ļ��������¶��ϵĴ�һ������ƹ㵽���������Ȼ����д�ɵݹ鿴�����Ǵ����϶��µ���� ���ǵײ㻹�����¶���һ��һ�����Ϸ��ؽ��
���Ƶ��� ���Ǻ���ֱ�����������ɽ���Ĺ���


*/
public class �ǿ��Ӽ� {
	 public static void main(String[] args) {
		    int[] A = {34,67,23};
		    Set<Set<Integer>> s1 = f2(A,3);
		    System.out.println(s1);
		  }

	 
	 //�����ķ���
	 public static Set<Set<Integer>> f2(int[] arr,int n){
		 Set<Set<Integer>> res = new HashSet();
		 Set<Integer> nil = new HashSet<>();//�ռ�
		 res.add(nil);
		
		 for(int i=0;i<arr.length;i++) {
			 Set<Set<Integer>> newSet = new HashSet();
			 for(Set<Integer> set:res) {
				 newSet.add(set);//�����arr[i]
				 
				 //��¡
				 Set<Integer> clone = (Set<Integer>) ((HashSet)set).clone();
				//������ʵ���˸��Ӽ������arr[i]����ӽ��µĴ󼯺���
				clone.add(arr[i]);
				newSet.add(clone);
				
			 }
			 res = newSet; //��ֵ����
		 }
		 return res;

	 }
	 
	 
	 
	 
	 //�������취
	 public static Set<Set<Integer>> f1(int[] arr,int n){
		 Arrays.sort(arr);
		 return getF1Core(arr,n,n-1);
	 }

	 //�ݹ��������취
	private static Set<Set<Integer>> getF1Core(int[] arr, int n, int cur) {
		Set<Set<Integer>> newSet = new HashSet();
		
		//������пռ���
/*		 if (cur == 0) {//�����һ��Ԫ��
		      Set<Integer> nil = new HashSet<>();//�ռ�
		      Set<Integer> first = new HashSet<>();//������һ��Ԫ�صļ���
		      first.add(arr[0]);
		      newSet.add(nil);
		      newSet.add(first);
		      return newSet;
		    }*/
		
		//�Ȱ������ÿ��Ԫ����Ϊ��ʼ���������Ӽ��� �Ͳ������ӿռ���
		if(cur==0) {
			for(int i=0;i<arr.length;i++) {
				Set<Integer> first = new HashSet();//������һ���ַ����Ӽ�
				first.add(arr[i]);
				newSet.add(first);
			}
			return newSet;			
		}
		
		Set<Set<Integer>> oldSet = getF1Core(arr,n,cur-1);//��ȡǰһ���Ѿ�����õİ��������Ӽ��ϵ�һ���󼯺�
	
		
		for(Set<Integer> set:oldSet) {
			newSet.add(set); //����� arr[cur]; ���Խ�����Ӽ���ֱ����ӽ��µĴ󼯺�
		
			//��ôҪʵ�־ɵĸ��Ӽ���set���arr[cur] �������´���һ��Set��¡set
			//clone()������HashSet��  ����Ҫ��ǿ��ת�� Ȼ�󷵻ص���Object���͵�  ��Ҫǿ��ת����Set
			Set<Integer> clone = (Set<Integer>) ((HashSet)set).clone();
			
			//������ʵ���˸��Ӽ������arr[cur]����ӽ��µĴ󼯺���
			clone.add(arr[cur]);
			newSet.add(clone);
		}
		return newSet;
	}
	
	

}
