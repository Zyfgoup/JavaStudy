package Part2;
//��������
public class OrderArray {
	private long[] a;
	private int nElems;
	
	public OrderArray(int max) {
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
}
