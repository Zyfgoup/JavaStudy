package Part3;

public class BubbleSortTest {
	public static void main(String[] args) {
		int[] a = {30,79,79,64,47,4359,347,2342,1234,3245,345785};
		BubbleSort(a);
		for(int i:a) {
			System.out.println(i);
		}
	}
	public  static int[] BubbleSort(int[] s) {
		for(int i=s.length-1;i>0;i--) {//n个数冒出n-1个
			for(int j=0;j<i;j++) {//每冒出一个 就减少一次比较 第一次比较n-1,第二次n-2
				if(s[j]>s[j+1]) {
					int temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
		return s;
	}
}
