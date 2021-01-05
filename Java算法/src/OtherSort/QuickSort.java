package OtherSort;

/*
 * ��������
 * 1.�ֽ⣺ѡȡ����a��һ��Ԫ��a[p]������a[n]�ֳ������֣�ʹ�����a[0...p-1]��ֵ��С��a[p],�ұ�a[p+1...r]��ֵ������a[p]
 * ��a[p]�е�pҲ���ɻ��ֹ�������õ�
 * 2.�����ͨ���ݹ���ÿ������򣬶�������a[0..p-1]��a[p+1...r]��������
 * 3.�ϲ�����Ϊ�����鶼����ԭַ(ԭ��������)��������ˣ����Բ���Ҫ�ٽ��кϲ�������
 * 
 * ���Կ�������ؼ����ڻ����������
 * partiton()��ÿ�ζ�������ģ������飩������һ��Ԫ����Ϊ��Ŧ��
 * ������Ԫ�ػ��ֺú��ٽ���Ŧ�뻮�ֽ���ʱɨ��ָ��(������C++�����ָ�룬ֻ�Ǳ�ʾָ�����˼)ָ��Ԫ�ؽ��н���
 * ����ǵ���ɨ�裺�������begin��bigger����
 * �����˫��ɨ��:�����begin��right����
 * ���ǽ�����һ��Ԫ����Ϊ��Ŧ��һ���Ĳ����ô������ÿ����Ŧ�ڻ�����󽻻�����λ�ö����������ĳһ�࣬
 * �����������м�һ���λ�ã���ʱ�临�ӶȻ�����
 * ���Կ�����������ֵ����������Ŧ���ĸ�Ԫ��
 * 
 * ������ֵ�����Ƚ���������� �м�λ�� �����Ҷ� ����Ԫ�أ��������Ԫ���е���ֵ������ֵ������˵���������н���
 * ��ô�����൱�ڽ������������Ϊ��Ŧ��ֻ������ʱ�����Ŧ������Ԫ���е���ֵ
 * 
 * ��Java������� Arrays.sort()�������õľ��ǿ�������
 * ������������Ƚ��ٵ�ʱ���ǲ��ò��������
 * 
 * ʱ�临�Ӷ���O(nlogn)
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {54,34,2,5432,1,54,9,73,67,10};
		quickSort(arr,0,arr.length-1);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	public static void quickSort(int[] arr,int begin,int end) {
		//�ݹ鷽�� ҲҪע��߽� ��begin=endʱֻ��һ��Ԫ��û��Ҫ���������� 
		if(begin<end) {
//			int p = partition1(arr,begin,end);
			int p = partition2(arr,begin,end);
			quickSort(arr,begin,p-1);
			quickSort(arr,p+1,end);
		}
	}

	
	//���֣�����ɨ�� �������� ֱ��ɨ��ָ�������Ҳ��biggerָ��
	public static int partition1(int[] arr, int begin, int end ) {
		int privot = arr[begin];//����һ��Ԫ����Ϊ��Ŧ
		int sp = begin+1;//ɨ��ָ��      beginΪ��Ŧ������+1
		int bigger = end;
		
		//���ڽ���sp��biggerָ���Ԫ�غ� bigger��--����ô�߽����sp>bigger
		while(sp<=bigger) {
			if(arr[sp]<=privot)//spָ���Ԫ��С��privot�Ļ�sp�������ƶ�
				sp++;
			else {//ɨ����������privot��Ԫ��
				swap(arr,sp,bigger);//����ɨ��ָ����bigger��ֵ
				//�����˺�bigger������
				bigger--;
				
				//���ﲻ��Ҫ���Ľ���ʱbiggerλ�õ�Ԫ���Ƿ����privot
				//��Ϊsp�������û�б仯��
				//���������spָ���Ԫ�ػ��Ǵ���privot����ô��һ��ѭ��sp����û�䣬
				//����sp��bigger������ֱ��bigger����ɨ����privotС��Ԫ�أ�������ɺ�sp�Ż���������ƶ�
			}
		}
		swap(arr,begin,bigger);//����Ŧ��biggerָ���Ԫ�ؽ�������Ϊ���biggerָ��Ŀ϶���С��privot��
		return bigger;//����bigger
	}
	
	//���֣�˫��ɨ�� ����ͬʱɨ�� ����С��/���ھ�ͣ�£���������ָ��ָ���Ԫ�أ�Ȼ����� ֱ�� left>right
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
			while(left<=right&&arr[left]<=privot)//С�ڵ���privot�������ƶ�
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
