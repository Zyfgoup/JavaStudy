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
		//其实就是插入排序 但是下标不是从1开始 从增量开始,只不过是根据增量分的组在组里进行插排
		//只是外面多了一层增量不断变小最后为1的循环插入排序
		//这里增量一开始为数组长度的一半，然后每次/2
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
