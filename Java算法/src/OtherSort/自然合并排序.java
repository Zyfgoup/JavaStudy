package OtherSort;

/*
 * 自然合并排序是合并排序算法的一种改进. 自然合并排序: 
 * 对于初始给定的数组,通常存在多个长度大于1的已自然排好序的子数组段. 
 * 例如,若数组a中元素为{4,8,3,7,1,5,6,2},则自然排好序的子数组段有{4,8},{3,7},{1,5,6},{2}. 
 * 构成更大的排好序的子数组段({3,4,7,8},{1,2,5,6}).继续合并相邻排好序的子数组段,直至整个数组已排好序.
 * 
 * 
 * 用一个数组t[n]来存储数组排好序的子数组段   下标表示第i段  值表示在原数组值下降的位置（在升序的情况下）
 * 例如 arr{4,8,3,7,1,5,6,2}  t[0] = 0  t[1] = 2 t[2]=4 t[3]=7 那么一共有4段子数组
 * 
 * 用t[n]代替之前的数组长度，从步长为1开始合并 表示相邻为步长的t[n]子数组段   t[n]来表示要合并的子数组的下标
 */
public class 自然合并排序 {
	static int part; //表示有多少段排好序的子数组
	static int[] t;
	public static void main(String[] args) {
		int[] arr = {4,8,3,7,1,5,6,2};
		System.out.println("排序前：");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n排序后：");
		t = new int[arr.length];
		t[0] = 0;//第一个赋值为0 第一个数字肯定是有序的
		getPart(arr);
		mergeSore(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void getPart(int[] arr) {
		int k = 1;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1])
				t[k++] = i+1; //记录第k+1段有序子数组开始的下标  
			//那么t[k]-1就为第k段的有序子数组的末尾下标
		}
		//相当于 一根绳子 切了三刀  分成了四条  的意思   第一个t[0]不算 只是表示起点
		part = k; // 因为前面是k++ 所以k表示数组分成了几段有序子数组段
		
		
	}

	private static void mergeSore(int[] arr,int n) {
		
		int s = 1; //表示步长
		
		//while(s<n) //从相邻长度为1的元素进行合并
		while(s<part) {
			
			mergePass(arr,s,n);
			s+=s;
			mergePass(arr,s,n);
			s+=s;
		}
		
	}

	private static void mergePass(int[] arr, int s, int n) {
		int i=0;//控制t数组的下标   从0开始
		
		//t数组已经赋值的长度以内进行循环合并数组  
		
		//while(i<=n-s*2)
		while(i<=part-s*2) {
			 //合并t数组下标相差s的两个子数组段 
			int r = ((i+2*s)<part)?t[i+2*s]:n;//判断第二段子数组段的边界取什么值 因为i+2*s 可能超过part了
			
			
			//注意 t[i+s]-1  才表示左子数组段的末尾下标
			//注意r-1才表示右子数组段的末尾
			merge(arr,t[i],t[i+s]-1,r-1);
			
			
			i=i+2*s;
		}
	
		
		//if(i+s<n) 
		if(i+s<part)
			merge(arr,t[i],t[i+s]-1,n-1);
		
		//这里我只用原数组 所以不需要变动
		/*else
			if(i<part)
			{
				for(int j=t[i];j<=n-1;j++)
					arr[j]
			}*/
		
	}

	private static void merge(int[] arr, int i, int j, int r) {
		int[] b = new int[arr.length];
		int left = i;
		int right = j+1;
		int k = 0;
		while(left<=j&&right<=r) {
			if(arr[left]<=arr[right])  //谁小就放进辅助数组 且指针++
				b[k++] = arr[left++];
			else
				b[k++] = arr[right++];
		}
		
		if(left>j) {
			for(int l = right;l<=r;l++) {
				b[k++] = arr[l];
			}
		}
		else {
			for(int l = left;l<=j;l++) {
				b[k++] = arr[l];
			}
		}
		
		//赋值回原数组
		for(int l=0;l<k;l++) {
			arr[i++] = b[l];
		}
		
	}
}
