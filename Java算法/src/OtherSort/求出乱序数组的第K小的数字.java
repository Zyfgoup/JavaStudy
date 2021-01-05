package OtherSort;

//��������Ļ��ַ�������� ��  ÿ����Ŧ������ڵ�λ�ü�Ϊ�������������λ�ã���ô�����ǵ�p-begin+1С��ֵ
//��ô�Ƚ����k�Ĵ�С���������ж�ʱ���һ������������
//ע����������ҵ�ʱ��beginΪp+1�ˣ���ôk��ʱӦ����k-(p-begin+1)
public class �����������ĵ�KС������ {
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1};
		System.out.println(selectK(arr,0,arr.length-1,3));
	}
	
	public static int selectK(int[] arr,int begin,int end,int k) {
		int p = partition2(arr,begin,end);
		//p-begin+1��ֵ��ʾa[p]�������еĵڼ��£���Ϊ�±��0��ʼ
		if(k==p-begin+1)
			return arr[p];
		else if(k>p-begin+1)
			return selectK(arr,p+1,end,k-(p-begin+1));
		else
			return selectK(arr,begin,p-1,k);
		
		
	}
	public static int partition2(int[] arr,int begin,int end) {
		//�������Ԫ���е���ֵ
		int mid = (begin+end)/2;
		if(arr[begin]<=arr[mid]&&arr[begin]>=arr[end])
			swap(arr,begin,begin);
		else if(arr[end]<=arr[mid]&&arr[end]>=arr[begin])
			swap(arr,end,begin);
		else
			swap(arr,mid,begin);
		
		int privot = arr[begin];
		int left = begin+1;
		int right = end;
		while(left<=right) {
			//ע��߽����⣬left����һֱɨ��ȥ������right�ұߵ�Ԫ�ؿ϶��Ǵ���privot�ģ�������С�ڵ���
			//�ڵ��ڵ�ʱ���ټ���С�ڻ��ߴ���privotʱҲ�Ƿ��ϵ� �������ܳ���left>right�������������ѭ��
			while(left<=right&&arr[left]<=privot)//С��privot�������ƶ�
				left++;
			while(left<=right&&arr[right]>privot)//����privot�������ƶ�
				right--;
			
			
			if(left<right) //����ǵ���ָ��ͬһ��û�б�Ҫ������
				//���left����right�Ͳ��ܽ��н����ˣ���Ϊ����privot��Ҫ���Ҳ࣬С�ڵ�Ҫ����࣬һ�����Ļ����෴��
				swap(arr,left,right);
		}
		swap(arr,begin,right);//������Ŧ��right��λ��
		return right;//���������Ŧ���ڵ��±�
	}
	
	public static void swap(int[] arr,int x,int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
