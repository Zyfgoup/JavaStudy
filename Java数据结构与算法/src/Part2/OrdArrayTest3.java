package Part2;

public class OrdArrayTest3 {
	public static void main(String[] args) {
		OrderArray3 or = new OrderArray3(10);
		long[] a1 = getRandArray(5);
		long[] a2 = getRandArray(10);
		System.out.println("输出无序的两个数组的信息");
		 for(int t=0;t<a1.length;t++) {
			   System.out.print(a1[t]+" ");
		 }
		 System.out.println();
		 for(int t=0;t<a2.length;t++) {
			   System.out.print(a2[t]+" ");
		   }
		 
		 System.out.println("\n调用merge方法后");
		 or.merge(a1, a2);
		
		
	}
	public static long[] getRandArray(int maxSize) {
		long upperBound = 1000; // 随机数的上限为 1000，可以任取其他数
		long[] result = new long[maxSize]; // 返回数组，内部装满随机产生的整数
		for(int j=0; j<maxSize; j++) // fill array with
		{ // random numbers
			long n = (long)( java.lang.Math.random()*(upperBound-1) );
			result[j] = n;
		}
			return result;
		}
}
