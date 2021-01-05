package Part2;
//��������
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
				return midBound;//�����±�
			}else if(lowerBound > upperBound) {
				return nElems;//��������ĳ���>�±������ζ��û������ҵ�
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
//	����ӵ�Ԫ������ķ���������
	public void insert(long value) {
		int i;//�������ʹ�ã����������forѭ���У�ֻ��forѭ����ʹ����
		for(i=0;i<nElems;i++) {
			if(a[i] > value) {
				break;//�ҵ�����value���Ǹ��±�
			}
		}
		
		for(int j=nElems;j>i;j--) {
			a[j] = a[j-1];//��������ҵ����±굽�±�ΪnElems-1��Ԫ�ض������ƶ�
			
		}
		
		a[i] = value;//�ҵ��±��i��λ�÷�value  ��С�������������
		nElems++;
	}
	
	public boolean delete(long value) {
		int i = find(value);
		if(i == nElems) {
			return false;//����Ԫ����û�����ֵ
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
		//�����������Ϊ����
		for(int t=0;t<a1.length;t++) {
			   System.out.print(a1[t]+" ");
		 }
		 System.out.println();
		 for(int t=0;t<a2.length;t++) {
			   System.out.print(a2[t]+" ");
		   }
		 System.out.println();
		
		long[] a3 = new long[a1.length+a2.length];
		
		int i = 0,j = 0,k = 0;//i��ʾa1����ʾa2,k��ʾa3
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
		//�Ƚ������������ʣ��һ�������ʣ��Ԫ��
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
		//��������
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
