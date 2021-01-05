package OtherSort;

import java.util.Arrays;

/*�ø�������������г��ֵĵ����ּ�����Ԫ��ת�±꣬���±�תԪ��
 * ����Ԫ��ȫ��������0������ɨ��ԭ���飬��Ԫ��ֵk��¼�ڸ��������kλ���ϣ�
 * ����ɨ�踨�����飬���Ϊ1��������뵽Ŀ��������
 * ������ظ����飬��ô��kλ���ϼ���++
 * ����и�������ô�ͽ����������е���������һ������ʹ��ȫ������0������ټ�ȥ�Ϳ�����
 * 
 * 
 * �����ռ�ĳ�����ԭʼ�����е�����+1��+1��Ϊ�˷������
 * 
 * ʱ�临�Ӷ���O(n+k)  k�Ǹ�������ĳ���
 * ���ǿռ临�ӶȱȽϸ� O(k)
 */
public class CountSort {
	public static void main(String[] args) {
		 int[] arr = {3,6,3,7,1,9,12,475,34,65,24};
		 sort(arr);
		 System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int helper[] = new int[getMax(arr)+1];
		for(int i=0;i<arr.length;i++) {
			//ֵ��Ϊ����������±�
			helper[arr[i]]++;
		}
		
		int current = 0;
		for(int i=1;i<helper.length;i++) {
			//������ظ�������
			while(helper[i]>0) {
				arr[current++] = i;
				//--��֤���û���ظ��ͼ�����һ��
				helper[i]--;
			}
		}
		
	}
	public static int getMax(int[] arr) {
		int max = arr[0];
		for(int i =1;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
}
