package ����ݹ�;
/*
 * LeetCode60 n��������������ҳ��ֵ���ĵ�k������
 * The set[1,2,3,��,n]contains a total of n! unique permutations.
 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the k th permutation sequence.
 Note: Given n will be between 1 and 9 inclusive.

 ʱ�����ƣ�1��
 
 ǰ��ԭ�ַ����鰴�ֵ���������� �����ȡ�����������ʱ����� ��Ҫ������
 
 ��Ϊÿ�ζ���ͷɨ�� (ԭ�ַ����������ǰ����)  ���Ի�õ�ȫ�����ǰ��ֵ����  ����Ҫ���K�� ���㵽count==k��������
 
 */


public class ȫ������ {
	static int count =0;
	public static void main(String[] args) {
		char[] arr = new String("abbc").toCharArray();
		permutation("",arr,3);
	}
	
	public static void permutation(String prefix,char[] arr,int k) {
		if(prefix.length()==arr.length) {
			count++;
			if(count==k)
				System.out.println(k+":"+prefix);
			else
				System.out.println(prefix);
		}
		
		
		//ÿ�δ�ͷɨ�裬ֻҪ���ַ����ã��ͼӵ�ǰ׺���棬ǰ׺�ͱ䳤��  ֱ�����ȵ���arr.length
		for(int i=0;i<arr.length;i++) {
			char c = arr[i];
			
			//���ǰ׺��c�ĸ�������ԭ����ô�Ϳ�����ӽ�ȥ
			if(count(prefix,c)<count(arr,c)) {
				permutation(prefix+c,arr,k);
			}
		}
	}

	//����c��ԭ�ַ���һ���ж��ٸ�
	private static int count(char[] arr, char c) {
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==c)
				cnt++;
		}
		return cnt;
	}

	//�����ַ�c��ǰ׺������˶��ٴ�
	private static int count(String prefix, char c) {
		int cnt = 0;
		for(int i=0;i<prefix.length();i++) {
			if(prefix.charAt(i)==c)
				cnt++;
		}
		return cnt;
	}
	
}
