package OtherSort;

import java.util.Arrays;

/*
 * �ڷǸ����飨�������ҵ���С�ɷ����ID ��1��ʼ��ţ�������Ϊ1000000
 * ˼·���������������� ��ô ��1 2 3 4 5 7....�����������£���С���õ�id��6�������Ե���������ʱ��Ԫ����==�±�+1�ģ�
 * ���ĳ��Ԫ�ز�����ˣ���ô��Ԫ�ص�ֵ-1�϶�������С���õ�ID��
 */

public class ��С����ID {
	public static void main(String[] args) {
		int[] arr= {101,1,5,3,4,6,8,9,};
		System.out.println(f2(arr));
	}
	
	//����һ���������ź���󣬱Ƚ�ֵ��ڼ��������Ƿ���������������ô��ֵ-1������С���õ�ID
	public static int f1(int[] arr) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1)
				return arr[i]-1;
		}
		return arr.length+1;
	}
	
	//������������һ�������ռ䣬��Ԫ�ص�ֵ��Ϊ����������±꣬Ȼ��ֵΪ1��Ȼ������������飬��һ����Ϊ1�������������±������С����ID
	//�����ռ�ĳ�����ԭ���鳤��+1,��ô�����±�Ϊ0�� �������
	public static int f2(int[] arr) {
		int[] helper = new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			//���arr[i]��ֵ��������ĳ��ȣ������Ե��ź������ֵǰ��϶�����С����ID�Ĵ��ڣ�
			//����û��Ҫ���������鸳ֵ�������ֵ����ôhelper�ĳ���ֻ��n+1,�ͻ����Խ��
			if(arr[i]>arr.length)
				continue;
			else
				helper[arr[i]] = 1;
		}
		for(int i=1;i<helper.length;i++) {
			if(helper[i]!=1)
				return i;
		}
		return helper.length;//��������n+1��ǰ�泤���Ѿ�+1��
	}
	
	//�������������ҵ�KСֵ�÷������ж�ֵ���м�Ӧ���е�ֵ�Ƿ�һ�£�Ȼ��ݹ�
	//���ڳ������⣬���ü򵥾ٸ���������ã�
	//��begin��end����ʱ��beginָ���ֵ�϶��ǵ�һ�����±�+1�����ģ���ô��С��ID����begin+1��
	public static int f3(int[] arr,int begin,int end) {
		if(begin>end)
			return begin+1;
		int mid = (begin+end)/2;
		
		//������ĵ�mid-begin+1С��ֵ Ҳ����λ���±�midλ�õ�ֵ
		int p = �����������ĵ�KС������.selectK(arr, begin, end, mid-begin+1);
		
		int q = mid+1;//��������������±�Ϊmid������ֵ
		
		//�ҵ���ֵ������ֵ��ȣ���ô��ζ��mid��߶��ǽ��ܵ� û����С���õ�id��
		if(q==p)
			return f3(arr,mid+1,end);
		else
			return f3(arr,begin,mid-1);
	}
}
