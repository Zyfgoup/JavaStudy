package Part2;
//有序数组
public class OrderArray2 {
	private long[] a;
	private int nElems;
	
	public OrderArray2(int max) {
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
	
	public int find1(long value) {
		int low = 0;
		int high = nElems-1;
		int mid = 0;
		
		while(low <= high) {
			mid = (low + high)/2;
			
			if(a[mid]>value) {
				high = mid-1;
			}else if(a[mid]<value){
				low = mid+1;
			}else {
				System.out.println("该数组中已经有这个数了");//还有待改进
				break;
			}
		}
		return mid;
		
	}
//	将添加的元素有序的放入数组中 用二分查找法
	public void insert(long value) {
		int i=find1(value);
		
		if(i==0&&a[i]==0) {
			a[i] = value;//解决插入第一个数的特殊情况
			nElems++;	 //若插入第一个数时，a[0]<value;且nElems==0,如果不单独解决则插入不进去,那么a[0]一直为0
		}else {
			if(a[i]<value) {
				for(int j = nElems;j>i;j--) {
					a[j] = a[j-1];
				}
				a[i+1] = value;
				nElems++;
			}else {
				for(int k=nElems;k>i;k--) {
					a[k] = a[k-1];
				}
				a[i] = value;
				nElems++;
			}
		}
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
}
