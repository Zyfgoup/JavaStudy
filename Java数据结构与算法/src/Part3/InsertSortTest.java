package Part3;

public class InsertSortTest {
	public static void main(String[] args) {
		int[] a = {30,0,64,64,47,4359,347,2342,1234,3245,345785};
		insertSort(a);
		for(int i:a) {
			System.out.println(i);
		}
	}

	public static int[] insertSort(int[] a) {
		int out,in;
		for(out=1;out<a.length;out++) {
			int temp = a[out];
			in = out;
			while(in>0 && a[in-1]>=temp) {//��������ڣ����������������ȵ�������һ������ߵ�������������
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
		return a;
	}
}
