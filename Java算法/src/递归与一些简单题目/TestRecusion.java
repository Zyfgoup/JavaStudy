package 递归与一些简单题目;
/*
 * 找重复：把一个复杂的问题划分为稍微简单的子问题(子问题要与原问题是一样的类型才能当做一个新的问题调用自身解决)
 * 		可以划分为一个子问题加自身解决一部分(阶乘n*(n-1)!,类似于切蛋糕把问题切一刀 自己吃一小部分，剩下的大块给下一个人切一刀吃小部分，继续给下一个人.....)
		 也可以把问题划分为几个子问题（斐波那契数列 f(n)=f(n-1)+f(n-2)，这种问题不能用一刀切来解决，只能找递推公式或者等价转换)
		总的来说要么就是找划分要么就是找公式或者等价转换，目的都是为了将问题转化为求解子问题 
        找变化：把变化的量作为参数
         找边界：出口
         
         
      用一些简单的循环能实现的例子改成用递归来实现
*/
public class TestRecusion {
	public static void main(String[] args) {
//		System.out.println(f1(5));
//		print(1,10);
		//字符串加上字符会自动转化成字符串
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
	
	//递归实现n的阶乘
	public static int f1(int n) {
		if(n==1)
			return 1;
		return n*f1(n-1);
	}
	
	//递归实现打印i-j
	public static void print(int i,int j) {
		if(i>j)
			return;
		System.out.print(i);
		print(i+1,j);
	}
	
	//递归实现字符串翻转
//	找重复：例如abcd 可以在adc与d之间划一刀，那么就变成了d+上子串adc的翻转，不断继续...
//	找变化：从d开始往前不断缩小子串，那么就是下标不断往前，所以作为参数
//	找出口：当end=0时就一个字符时就不需要再继续了
	public static String reverseString(String s,int end) {
		if(end==0)
			return ""+s.charAt(end);
		
		return s.charAt(end)+reverseString(s,end-1);
	}
	
	//递归实现数组求和
	public static int sum(int[] arr,int index) {
		if(index == arr.length)
			return 0;
		
		return arr[index]+sum(arr,index+1);
	}
	
	//递归实现斐波那契数列： 1 1 2 3 5 8....每项的值等于其前一项+前二项的值
	public static int fib(int n) {
		if(n==1||n==2)
			return 1;
		
		return fib(n-1)+fib(n-2);
	}
	
	//递归实现求两个数的最大公约数  有个公式 如果m%n==0 那么n就为最大公约数 
	//如果m%n=k 再计算n%k是否等于0，循环下去直到为0的k值则为最大公约数
	//出口 如果磨完之后为0则返回m    因为子问题里传入的n是m%n m传入的是上一个问题的n值
		public static int getMaxGongyue(int m,int n) {
			//不用考虑大小 ，如果前小 后大 那么m%n=m 第一次递归调用自身就会互换位置
			if(n==0)
				return m;
			return getMaxGongyue(n,m%n);
		}
		
	//递归实现插入排序
		//对数组0-n-2进行部分排序
		//将索引为n-1的插入到前面排序好的
		//变化就是最右边的下标不断往左 不断变小 所以作为参数
		public static void RecInsertSort(int[] arr,int k) {
			if(k==0)
				return;
			
			RecInsertSort(arr,k-1);//对前k-1个值进行排序
			
			//将k的的位置插到前k-1个中
			int temp = arr[k];
			int index = k-1;
			//界限要注意 如果是逆序的情况下会一直循环下去到下标为-1则数组越界的异常
			//所以要加上一个限制条件
			while(index>-1&&temp<arr[index]) {
				arr[index+1] = arr[index];
				index--;
			}
			//这里因为循环里--了，下标已经到小于temp的值了 ，所以要+1
			arr[index+1] = temp;
		}
	
	//汉诺塔问题 
	//将n-1个从A移动到B
	//将最大的第n个从A移动C
	//将n-1个从B移动到C
	public static void hanoi(int n,String start,String temp,String end) {
		if(n==1) {
			System.out.println("把"+n+"从"+start+"移到"+end);
			return;
		}
		else {
			hanoi(n-1,start,end,temp);
			System.out.println("把"+n+"从"+start+"移到"+end);
			hanoi(n-1,temp,start,end);
		}
	}
	
	//递归实现二分查找
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
