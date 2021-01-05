package Part4.Queue;
class PriorityQ{
	private int maxSize;
	private long[] queArray;
//	private int front;
//	private int rear;
	private int nItems;
	
	public PriorityQ(int n) {
		maxSize = n;
		queArray = new long[maxSize];
//		front = -1;
//		rear = 0;
		nItems = 0;
	}
	
	public void insert(long value) {
		int j;
		
		if(nItems == 0)
			queArray[nItems++] = value;
		else {
			for(j=nItems-1;j>=0;j--) {
				if(value > queArray[j])
					queArray[j+1] = queArray[j];
				else
					break;
			}
		queArray[j+1] = value;
		nItems++;
		}	
	}
	
	public long remove() {
		return queArray[--nItems];
	}
	
	public long peekMin() {
		return queArray[nItems-1];//因为一开始nItems就是0
	}
	public boolean isEmpty() {
		return (nItems == 0);
	}
	public boolean isFull() {
		return (nItems == maxSize);
	}
}
public class PriorityQAPP {
	public static void main(String[] args) {
		PriorityQ thePQ = new PriorityQ(10);
		thePQ.insert(90);
		thePQ.insert(30);
		thePQ.insert(345);
		thePQ.insert(4);
		thePQ.insert(2345);
		
		while(!thePQ.isEmpty()) {
			long value = thePQ.remove();
			System.out.print(value+" ");//4 30 90 345 2345
		}
		System.out.println();
	}
}
