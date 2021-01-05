package OtherSort;
/*
 * ��������arr��k,���ظ���ӡarr��������Ӻ�Ϊk�Ĳ������Ԫ��
 * arr = {-8,-4,-3,0,2,4,5,8,9,10} k=10
 * ���(2,8)(0,10)
 * 
 * �ؼ�������
 */
public class �����������Һ͵����� {
	public static void main(String[] args) {
		int[] arr = {-8,-4,-3,0,2,4,5,8,9,10};
		f(arr,10);
	}
	
	//O(n)
	public static void f(int[] arr,int k) {
		//����ָ��
		int left = 0;
		int right = arr.length-1;
		
		//����ָ��ָ��ͬһ��Ԫ�ؾ��˳�
		while(left!=right) {
			//�������С��k ��ô��ָ��������ƶ�
			if(arr[left]+arr[right]<k)
				left++;
			//�����Ⱦ���� ��������ָ�붼�ƶ�
			else if(arr[left]+arr[right]==k) {
				System.out.print(arr[left]+","+arr[right]+" ");
				left++;
				right--;
				
				//��Ӵ���K ����ָ���ƶ�
			}else
				right--;
		}
	}
}
