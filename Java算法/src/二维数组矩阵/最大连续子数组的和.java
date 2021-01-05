package ��ά�������;
/*
 * ��һ�����������������ĺ����(һ����Ҳ���������)
 */
public class �������������ĺ� {

	public static void main(String[] args) {
		int[] arr = {1,-2,3,5,-2,6,-1,3};
		System.out.println(f2(arr));
	}
	
	//�������
	public static void f1(int[] arr) {
		int maxSum = arr[0];//��¼����
		
		for(int j=0;j<arr.length;j++) {
			int sum = arr[j];//�ӵ�j����ʼ����j�����Ԫ��  Ȼ����������һ��max����¼��һ��ѭ���е����ֵ
			int maxOfJ = sum;
			
			for(int i=j+1;i<arr.length;i++) {
				sum += arr[i];
				
				//���sum����maxOfJ�͸���maxOfJ
				if(sum>maxOfJ)
					maxOfJ = sum;
			}
			
			//ÿ��һ�˾ͱȽϸ��¼�¼���յĽ��
			if(maxOfJ>maxSum)
				maxSum = maxOfJ;
		}
		
		System.out.println(maxSum);
	}
	
	
	//���� O(n)
	//�������ҿ�ʼ�ӣ����������Ϊ��������Щ������������һ����������¼�ӵĹ����е����ֵ
	public static int f2(int[] arr) {
		
		if(arr.length==0)
			return 0;
		
		//��¼�Ĵ�������
		int left=0;
		int right = 0;
		
		int sum = arr[0];
		
		//��¼���ֵ
		int max = sum;
		
		
		for(int i=1;i<arr.length;i++) {
			if(sum>=0)
				sum+=arr[i];
			else {
				sum = arr[i];
				left = i;//������
			}
			
			if(sum>max) {
				max = sum;
				right = i;
			}
		}
		return max;
	}
}
