package Part2;

public class OrdArrayTest3 {
	public static void main(String[] args) {
		OrderArray3 or = new OrderArray3(10);
		long[] a1 = getRandArray(5);
		long[] a2 = getRandArray(10);
		System.out.println("�������������������Ϣ");
		 for(int t=0;t<a1.length;t++) {
			   System.out.print(a1[t]+" ");
		 }
		 System.out.println();
		 for(int t=0;t<a2.length;t++) {
			   System.out.print(a2[t]+" ");
		   }
		 
		 System.out.println("\n����merge������");
		 or.merge(a1, a2);
		
		
	}
	public static long[] getRandArray(int maxSize) {
		long upperBound = 1000; // �����������Ϊ 1000��������ȡ������
		long[] result = new long[maxSize]; // �������飬�ڲ�װ���������������
		for(int j=0; j<maxSize; j++) // fill array with
		{ // random numbers
			long n = (long)( java.lang.Math.random()*(upperBound-1) );
			result[j] = n;
		}
			return result;
		}
}
