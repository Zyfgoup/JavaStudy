package Part4.Queue;
class Queue{
	private int maxSize;
	private long[] queArray;
	private int front;//队头
	private int rear;//队尾
	private int nItems;//计数数据项,因为是环绕队列，所以用队头队尾是无法判断队列是否为空、满，所以添加一个计数字段。
	
	public Queue(int n) {
		maxSize = n;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long value) {
		if(rear == maxSize -1)
			rear = -1;//回绕  队尾到了数组下标最大处，回到-1
		queArray[++rear] = value;
		nItems++;
	}
	
	public long remove() {
		long temp = queArray[front++];
		if(front == maxSize)
			front = 0;//环绕 当不断移除数据项时，front == maxSize  因为上一句语句计算了front++,回到为0
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
		
		theQueue.remove();//去掉 30
		theQueue.remove();//去掉450
		
		while(!theQueue.isEmpty()) {// 230,4560,20
			long n = theQueue.remove();
			System.out.print(n+" ");
		}
		System.out.println();
		
	}
}
