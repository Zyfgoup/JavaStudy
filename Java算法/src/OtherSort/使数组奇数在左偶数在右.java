package OtherSort;
/*
 * ����һ�����飬ʹ�������е�����λ�������ǰ�벿�֣�ż��λ�ں�벿�� ʱ�临�Ӷ�Ҫ����O(n)
 * 
 * ʹ�ÿ��������˫��ɨ��ķ���
 */
public class ʹ������������ż������ {
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1,54,9,73,67,10};
		f(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void f(int[] arr) {
		int left = 0;
		int right = arr.length-1;
		while(left<=right) {
			//ע��߽�
			while(left<=right&&arr[left]%2!=0)//��������������
				left++;
			while(left<=right&&arr[right]%2==0)//��ż��������
				right--;
			if(left<right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
	}
}
