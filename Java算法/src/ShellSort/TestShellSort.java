package ShellSort;

public class TestShellSort {
	public static void main(String[] args) {
		int[] arr= {3,45,3246,7,1,5,8,1023,46,6547};
//		shellSort(arr);
		insertSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	public  static void shellSort(int[] arr) {
		//��ʵ���ǲ������� �����±겻�Ǵ�1��ʼ ��������ʼ,ֻ�����Ǹ��������ֵ�����������в���
		//ֻ���������һ���������ϱ�С���Ϊ1��ѭ����������
		//��������һ��ʼΪ���鳤�ȵ�һ�룬Ȼ��ÿ��/2
		for(int interval=arr.length/2;interval>0;interval/=2){
			for(int i=interval;i<arr.length;i++) {
				int temp = arr[i];
				int j = i-interval;
				while(j>-1&&temp<arr[j]) {
					arr[j+interval] = arr[j];
					j-=interval;
				}
				arr[j+interval] = temp;
			}
		}
	}
	
	public static void insertSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int temp = arr[i];
			int j = i-1;
			while(j>-1&&temp<arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
}
