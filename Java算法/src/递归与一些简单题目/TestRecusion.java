package �ݹ���һЩ����Ŀ;
/*
 * ���ظ�����һ�����ӵ����⻮��Ϊ��΢�򵥵�������(������Ҫ��ԭ������һ�������Ͳ��ܵ���һ���µ��������������)
 * 		���Ի���Ϊһ���������������һ����(�׳�n*(n-1)!,�������е����������һ�� �Լ���һС���֣�ʣ�µĴ�����һ������һ����С���֣���������һ����.....)
		 Ҳ���԰����⻮��Ϊ���������⣨쳲��������� f(n)=f(n-1)+f(n-2)���������ⲻ����һ�����������ֻ���ҵ��ƹ�ʽ���ߵȼ�ת��)
		�ܵ���˵Ҫô�����һ���Ҫô�����ҹ�ʽ���ߵȼ�ת����Ŀ�Ķ���Ϊ�˽�����ת��Ϊ��������� 
        �ұ仯���ѱ仯������Ϊ����
         �ұ߽磺����
         
         
      ��һЩ�򵥵�ѭ����ʵ�ֵ����Ӹĳ��õݹ���ʵ��
*/
public class TestRecusion {
	public static void main(String[] args) {
//		System.out.println(f1(5));
//		print(1,10);
		//�ַ��������ַ����Զ�ת�����ַ���
//		String s = "acv"+'a';
//		System.out.println(reverseString("abcd",3));
//		int[] arr= {1,2,3,4,5,6,7,8,9,10};
//		int i=sum(arr,0);
//		System.out.println(i);
//		System.out.println(fib(5));
//		System.out.println(getMaxGongyue(12,24));
//		int[] arr= {10,9,8,7,6,5,4,3,2,1};
//		RecInsertSort(arr, arr.length-1);
//		System.out.println(arr[0]);
//		hanoi(3,"A","B","C");
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		System.out.println(arr[binarySearch(arr,0,arr.length-1,1)]);
	}
	
	//�ݹ�ʵ��n�Ľ׳�
	public static int f1(int n) {
		if(n==1)
			return 1;
		return n*f1(n-1);
	}
	
	//�ݹ�ʵ�ִ�ӡi-j
	public static void print(int i,int j) {
		if(i>j)
			return;
		System.out.print(i);
		print(i+1,j);
	}
	
	//�ݹ�ʵ���ַ�����ת
//	���ظ�������abcd ������adc��d֮�仮һ������ô�ͱ����d+���Ӵ�adc�ķ�ת�����ϼ���...
//	�ұ仯����d��ʼ��ǰ������С�Ӵ�����ô�����±겻����ǰ��������Ϊ����
//	�ҳ��ڣ���end=0ʱ��һ���ַ�ʱ�Ͳ���Ҫ�ټ�����
	public static String reverseString(String s,int end) {
		if(end==0)
			return ""+s.charAt(end);
		
		return s.charAt(end)+reverseString(s,end-1);
	}
	
	//�ݹ�ʵ���������
	public static int sum(int[] arr,int index) {
		if(index == arr.length)
			return 0;
		
		return arr[index]+sum(arr,index+1);
	}
	
	//�ݹ�ʵ��쳲��������У� 1 1 2 3 5 8....ÿ���ֵ������ǰһ��+ǰ�����ֵ
	public static int fib(int n) {
		if(n==1||n==2)
			return 1;
		
		return fib(n-1)+fib(n-2);
	}
	
	//�ݹ�ʵ���������������Լ��  �и���ʽ ���m%n==0 ��ôn��Ϊ���Լ�� 
	//���m%n=k �ټ���n%k�Ƿ����0��ѭ����ȥֱ��Ϊ0��kֵ��Ϊ���Լ��
	//���� ���ĥ��֮��Ϊ0�򷵻�m    ��Ϊ�������ﴫ���n��m%n m���������һ�������nֵ
		public static int getMaxGongyue(int m,int n) {
			//���ÿ��Ǵ�С �����ǰС ��� ��ôm%n=m ��һ�εݹ��������ͻụ��λ��
			if(n==0)
				return m;
			return getMaxGongyue(n,m%n);
		}
		
	//�ݹ�ʵ�ֲ�������
		//������0-n-2���в�������
		//������Ϊn-1�Ĳ��뵽ǰ������õ�
		//�仯�������ұߵ��±겻������ ���ϱ�С ������Ϊ����
		public static void RecInsertSort(int[] arr,int k) {
			if(k==0)
				return;
			
			RecInsertSort(arr,k-1);//��ǰk-1��ֵ��������
			
			//��k�ĵ�λ�ò嵽ǰk-1����
			int temp = arr[k];
			int index = k-1;
			//����Ҫע�� ��������������»�һֱѭ����ȥ���±�Ϊ-1������Խ����쳣
			//����Ҫ����һ����������
			while(index>-1&&temp<arr[index]) {
				arr[index+1] = arr[index];
				index--;
			}
			//������Ϊѭ����--�ˣ��±��Ѿ���С��temp��ֵ�� ������Ҫ+1
			arr[index+1] = temp;
		}
	
	//��ŵ������ 
	//��n-1����A�ƶ���B
	//�����ĵ�n����A�ƶ�C
	//��n-1����B�ƶ���C
	public static void hanoi(int n,String start,String temp,String end) {
		if(n==1) {
			System.out.println("��"+n+"��"+start+"�Ƶ�"+end);
			return;
		}
		else {
			hanoi(n-1,start,end,temp);
			System.out.println("��"+n+"��"+start+"�Ƶ�"+end);
			hanoi(n-1,temp,start,end);
		}
	}
	
	//�ݹ�ʵ�ֶ��ֲ���
	public static int binarySearch(int[] arr,int begin,int end,int key) {
		if(begin>end)
			return -1;
		
		int mid = (begin+end)/2;
		if(arr[mid] == key )
			return mid;
		else if(arr[mid]<key) {
			return binarySearch(arr,mid+1,end,key);
		}else
			return binarySearch(arr,begin,mid-1,key);
	}
		
}
