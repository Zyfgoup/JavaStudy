package OtherSort;
/*
 * һ�����У������ߵ����� �ұߵ���С����Ϊһ������ӣ������������������ж��������
 * �鲢�����е�merge��������ץ�Ҳ�������ʱ����ô���������ʣ�����е���rightָ���Ԫ�ض��������
 * ��Ȼ�����������ˣ����Ǽ����������������֮ǰ����õģ���С���ź��������˲���Ӱ����������Եļ���
 * ��Ϊ������Ҫ���������ʱ��������ٷ����Ҽ���������Ҳֻ�����������з�Χ��
 * ��̫������������ ���������һ�°�
 */
public class ����� {
	static int[] helper ;
	static int count;
	public static void main(String[] args) {
		
	}
	
	//ֱ�ӽ��鲢����Ĵ��뿽������
	//merge�����и�������û�����һ��д�Ĺ鲢���������Ȱ�˳���������ռ��ٿ�����ԭ����
	public static int f1(int[] arr) {
		helper = new int[arr.length];
		sort(arr,0,arr.length-1);
		return count;
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
		
		//�Ƚ����鿽������������
		System.arraycopy(arr, begin, helper, begin, end-begin+1);
		//��ô�������ֱ�ӽ�������������������а��Ƚϲ嵽ԭ������
		//���Ͳ����ٿ���һ����
		
		
		int left = begin;//��������е�ɨ��ָ��
		int right = mid+1;//�ұ������е�ɨ��ָ��
		
		//ԭ�����ָ�룬ָ����Ҫ�������ݵ�λ��  
		//��Ϊ�п��� begin�Ǵ����ֵ��mid+1 ����ô�����������Ŀ�ʼ��λ�þ���begin
		int current = begin;
		
		//��һ�ߵ���������ɨ��β������ѭ��
		while(left<=mid&&right<=end) {
			if(arr[left]<=arr[right])
				//�Ž���������֮�� ָ��ҲҪ��Ӧ���ƶ�
				arr[current++] = helper[left++];
			else{//ץ�Ҳ�
				arr[current++] = helper[right++];
				count+=mid-left+1;//������������ʣ���������
			}
		}
		
		//���������е�ָ����ɨ��β����ֹ��������л���������û��������
		//���ÿ������ɨ��β�����ұ߻���û���븨������ģ���ʹ�ұ߻��У�����ԭ�����е�λ��Ҳ����ȷ��
		//��Ϊ����������ұ߻����������ô���Ǳ��������ж�Ҫ���������Ǳ���������ȷ��λ��
		while(left<=mid)
			helper[current++] = arr[left++];	
	}
}
