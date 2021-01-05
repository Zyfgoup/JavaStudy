package dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/*
������������a1,a2,...,an,�ж��Ƿ���Դ���ѡ��������,ʹ���ǵĺ�ǡ��Ϊk.
    1��n��20
    -10^8��ai��10^8
    -10^8��k��10^8
����:
����
    n=4
    a={1,2,4,7}
    k=13
���:
    Yes (13 = 2 + 4 + 7)
*/


//�ǿ��Ӽ��ı��Σ� ���ÿ���ǿ��Ӽ�����ÿ���Ӽ�������ΪҪ���k�ͷ����Ǹ�set Ȼ���set���Integer����Ȼ����Arrays.sort���������
public class ���ֺ� {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = cin.nextInt();
		}
		int k = cin.nextInt();
		
		Set<Integer> res = f2(arr,n,k);
		if(res.size()!=0) {
			Integer[] a = new Integer[res.size()];
			a = res.toArray(a);
			Arrays.sort(a, null);
			 System.out.print("Yes ("+k+" = ");
			 for(int i=0;i<a.length;i++) {
				 if(i!=a.length-1)
					 System.out.print(a[i]+" + ");
				 else
					 System.out.print(a[i]);
			 }
			 System.out.print(")\n");
		}
	}
	
	
	 public static Set<Integer> f2(int[] arr,int n,int k){
		 Set<Set<Integer>> res = new HashSet();
		 
//		 Set<Integer> nil = new HashSet<>();//�ռ�
//		 res.add(nil);
		 
		 
		 //�������Ӽ�
		 for(int i=0;i<arr.length;i++) {
			 Set<Integer> set = new HashSet();
			 set.add(arr[i]);
			 res.add(set);
		 }
		
		 int sum = 0;
		 for(int i=0;i<arr.length;i++) {
			 Set<Set<Integer>> newSet = new HashSet();
			 for(Set<Integer> set:res) {
				 newSet.add(set);//�����arr[i]
				 for(int a:set) {
					 sum+=a;
				 }
				 if(sum==k) {
					return set;
				 }else
					 sum = 0;
				 
				 //��¡
				 Set<Integer> clone = (Set<Integer>) ((HashSet)set).clone();
				//������ʵ���˸��Ӽ������arr[i]����ӽ��µĴ󼯺���
				clone.add(arr[i]);
				newSet.add(clone);
				 for(int a:clone) {
					 sum+=a;
				 }
				 if(sum==k) {
					return clone;
				 }else
					 sum = 0;
				
			 }
			 res = newSet; //��ֵ����
		 }
		 return new HashSet<Integer>();
	 }
}
