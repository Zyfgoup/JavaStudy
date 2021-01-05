package Part3;

public class SelectSortTest {
	public static void main(String[] args) {
		int[] a = {30,79,79,64,47,4359,347,2342,1234,3245,345785};
		SelectSort(a);
		for(int i:a) {
			System.out.println(i);
		}
	}
	public static int[] SelectSort(int[] a) {
		int min,out;
		for(out=0;out<a.length-1;out++) {
			min = out;
			for(int in=out+1;in<a.length;in++) {
				if(a[in]<a[min]) {
					min = in;
				}
			}
			int temp = a[out];
			a[out] =a[min];
			a[min] = temp;
		}
		return a;
	}
}
