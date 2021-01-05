package Part2;
//有序数组
public class OrderArray3 {
	private long[] a;
	private int nElems;
	
	public OrderArray3(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems-1;
		int midBound;
		
		while(true) {
			midBound = (lowerBound + upperBound)/2;
			if(a[midBound] == searchKey) {
				return midBound;//返回下标
			}else if(lowerBound > upperBound) {
				return nElems;//返回数组的长度>下标最大，意味着没有这个找到
			}else {
				if(a[midBound] < searchKey) {
					lowerBound = midBound + 1;
				}else {
					upperBound = midBound - 1;
				}
			}
		}//while end
	}//find() end
	
//	public void insert(long value) {
//		a[nElems] = value;
//		nElems++;
//	}
//	将添加的元素有序的放入数组中
	public void insert(long value) {
		int i;//方便后面使用，如果定义在for循环中，只能for循环中使用了
		for(i=0;i<nElems;i++) {
			if(a[i] > value) {
				break;//找到大于value的那个下标
			}
		}
		
		for(int j=nElems;j>i;j--) {
			a[j] = a[j-1];//将上面的找到的下标到下标为nElems-1的元素都往后移动
			
		}
		
		a[i] = value;//找的下标的i的位置放value  从小到大的有序数组
		nElems++;
	}
	
	public boolean delete(long value) {
		int i = find(value);
		if(i == nElems) {
			return false;//数组元素中没有这个值
		}else {
			for(int j=i;j<nElems;j++) {
				a[j] = a[j+1];
			}
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for(int i=0;i<nElems;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public void merge(long[] a1,long[] a2) {
		sort(a1);
		sort(a2);
		//将无序数组变为有序
		for(int t=0;t<a1.length;t++) {
			   System.out.print(a1[t]+" ");
		 }
		 System.out.println();
		 for(int t=0;t<a2.length;t++) {
			   System.out.print(a2[t]+" ");
		   }
		 System.out.println();
		
		long[] a3 = new long[a1.length+a2.length];
		
		int i = 0,j = 0,k = 0;//i表示a1，表示a2,k表示a3
		while(i<a1.length&&j<a2.length) {
			if(a1[i]<=a2[j]) {
				a3[k] = a1[i];
				k++;
				i++;
			}else {
				a3[k] = a2[j];
				k++;
				j++;
			}
		}
		//比较完两个数组后，剩下一个数组的剩下元素
	    while(i < a1.length) {
	    	a3[k] = a1[i];
	    	k++;
	    	i++;
	    }
	    	
	   while(j < a2.length) {
		   a3[k] = a2[j];
		   k++;
		   j++;
	   }
	   
	   for(int t=0;t<a3.length;t++) {
		   System.out.print(a3[t]+" ");
	   }
	
	}
	public void sort(long[] a) {
		//插入排序法
		int out,in;
		for(out=1;out<a.length;out++) {
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]>=temp) {
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
	
}
