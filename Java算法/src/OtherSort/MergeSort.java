package OtherSort;


/*
 * �鲢����:
 * ������ƽ���ֳ�����������
 * �����������н��еݹ�����
 * �ϲ��Ѿ�����õ�������Ԫ��
 * �ص��Ǻϲ�  �����������߷ֱ���13579  246810  Ҫ��ô���ܺϳ�12345678910
 * ������һ�������ռ������
 * ��һ���µ����飬�ֱ�Ա������������ݣ�ÿ�����˿�ʼ��һ��ָ�룬С��Ԫ�ؾ���ӽ��������飬Ȼ�������ƶ���
 * �ٱȽ�����ָ��ָ��Ԫ�صĴ�С...һֱ������ȥֱ�����������ж��ĺϲ���
 * Ȼ���ٽ����������Ԫ��һһ��ֵ��ԭ����Ҫ���������
 * 
 *  Ҳ�����ںϲ��ķ�������һ��ʼ��ԭ���鿽�����������飬��ô֮��Ĳ������ǽ������е�����������ɨ�踴�Ƹ�ԭ����
 *
 * ��ԭַ����
 * �ȶ��ԣ����������ǹ鲢���������Զ�������ҵ���Զ���ң��ȶ�
 */
public class MergeSort {
	static int[] helper;
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1,54,9,73,67,10};
		mergeSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	private static void mergeSort(int[] arr) {
		helper = new int[arr.length];
		sort(arr,0,arr.length-1);
		
	}

	public static void  sort(int[] arr,int begin,int end) {
		
		if(begin<end) {
			int mid = (begin+end)/2;
			//�ݹ���ù鲢��������������н�������  ע�����ﲻ��mid-1��  midҲҪ������ȥ������
			sort(arr,begin,mid);
			sort(arr,mid+1,end);
			merge(arr,begin,mid,end);
		}
	}

	private static void merge(int[] arr, int begin, int mid, int end) {
		int left = begin;//��������е�ɨ��ָ��
		int right = mid+1;//�ұ������е�ɨ��ָ��
		
		//ԭ�����ָ�룬ָ����Ҫ�������ݵ�λ��  
		//��Ϊ�п��� begin�Ǵ����ֵ��mid+1 ����ô�����������Ŀ�ʼ��λ�þ���begin
		int current = begin;
		
		//��һ�ߵ���������ɨ��β������ѭ��
		while(left<=mid&&right<=end) {
			if(arr[left]<=arr[right])
				//�Ž���������֮�� ָ��ҲҪ��Ӧ���ƶ�
				helper[current++] = arr[left++];
			else
				helper[current++] = arr[right++];
		}
		
		//���������е�ָ����ɨ��β����ֹ��������л���������û��������
		//���ÿ������ɨ��β�����ұ߻���û���븨������ģ���ʹ�ұ߻��У�����ԭ�����е�λ��Ҳ����ȷ��
		//��Ϊ����������ұ߻����������ô���Ǳ��������ж�Ҫ���������Ǳ���������ȷ��λ��
		while(left<=mid)
			helper[current++] = arr[left++];
		
		//�ٽ��������鿽����ԭ������ Ҫ���������鳤��Ϊ��begin��current-1
		//��Ϊǰ�渳ֵһ��current����++,�������ﻹ��<current
		for(int i=begin;i<current;i++) {
			arr[i] = helper[i];
		}
		
	}
}
