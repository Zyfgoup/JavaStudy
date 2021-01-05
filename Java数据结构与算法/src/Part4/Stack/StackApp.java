package Part4.Stack;
class StackX{
	private int maxSize;//数组的大小
	private long[] stackArray;//数组实现栈
	private int top;
	
	public StackX(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;//还没有插入有数据项，为-1
	}
	
	public void push(long value) {
		stackArray[++top] = value; //++top 先计算top 因为一开始top = -1
	}
	
	public long pop() {
		if(!isEmpty()) {
			return stackArray[top--];//先返回下标为top的数据元素，然后栈顶top-1;
		}else
			return 0;//返回0表示该栈没有插入有数据项，没有数据项可删除
	}
	public long peek() {
		if(!isEmpty())
			return stackArray[top];//查看栈顶的数据项
		else
			return 0;//返回0表示栈没有插入有数据项，无法查看
	}
	
	public  boolean isEmpty() {
		return (top == -1);//判断top是否为-1来判断栈是否为空
	}
	public boolean isFull() {
		return (top == maxSize-1);
	}
}
public class StackApp {
	public static void main(String[] args) {
		StackX theStack = new StackX(10);
		theStack.push(10);
		theStack.push(20);
		theStack.push(45);
		theStack.push(35);
		
		while(!theStack.isEmpty()) {
			long value = theStack.pop();
			System.out.print(value+" ");
		}
		System.out.println();
	}
}
