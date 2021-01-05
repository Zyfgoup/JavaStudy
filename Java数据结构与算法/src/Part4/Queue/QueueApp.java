package Part4.Queue;
class Queue{
	private int maxSize;
	private long[] queArray;
	private int front;//��ͷ
	private int rear;//��β
	private int nItems;//����������,��Ϊ�ǻ��ƶ��У������ö�ͷ��β���޷��ж϶����Ƿ�Ϊ�ա������������һ�������ֶΡ�
	
	public Queue(int n) {
		maxSize = n;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long value) {
		if(rear == maxSize -1)
			rear = -1;//����  ��β���������±���󴦣��ص�-1
		queArray[++rear] = value;
		nItems++;
	}
	
	public long remove() {
		long temp = queArray[front++];
		if(front == maxSize)
			front = 0;//���� �������Ƴ�������ʱ��front == maxSize  ��Ϊ��һ����������front++,�ص�Ϊ0
		nItems--;
		return temp;
	}
	
	public long peek() {
		return queArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	public boolean isFull() {
		return (nItems == maxSize);
	}
	public int size() {
		return nItems;
	}
}
public class QueueApp {
	public static void main(String[] args) {
		Queue theQueue = new Queue(10);
		
		theQueue.insert(30);
		theQueue.insert(450);
		theQueue.insert(230);
		theQueue.insert(4560);
		theQueue.insert(20);
		
		theQueue.remove();//ȥ�� 30
		theQueue.remove();//ȥ��450
		
		while(!theQueue.isEmpty()) {// 230,4560,20
			long n = theQueue.remove();
			System.out.print(n+" ");
		}
		System.out.println();
		
	}
}
