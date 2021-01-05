package º®¼ÙÁ·Ï°;

public class TestArrayUtil {
	public static void main(String[] args) {
		int arr[]=new int[]{25,48,-5,15,-85,99,250,-520};
		
		ArrayUtil au=new ArrayUtil();
		au.printArray(arr);
		System.out.println();
		int max=au.getMax(arr);
		System.out.println(max);
		int min=au.getMin(arr);
		System.out.println(min);
		int sum=au.getSum(arr);
		System.out.println(sum);
		int ave=au.getAverage(arr);
		System.out.println(ave);
		au.copy(arr);
		System.out.println();
		au.reverse(arr);
		System.out.println();
		au.sort(arr);
		
	}
}
