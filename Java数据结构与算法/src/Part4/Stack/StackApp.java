package Part4.Stack;
class StackX{
	private int maxSize;//����Ĵ�С
	private long[] stackArray;//����ʵ��ջ
	private int top;
	
	public StackX(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;//��û�в����������Ϊ-1
	}
	
	public void push(long value) {
		stackArray[++top] = value; //++top �ȼ���top ��Ϊһ��ʼtop = -1
	}
	
	public long pop() {
		if(!isEmpty()) {
			return stackArray[top--];//�ȷ����±�Ϊtop������Ԫ�أ�Ȼ��ջ��top-1;
		}else
			return 0;//����0��ʾ��ջû�в����������û���������ɾ��
	}
	public long peek() {
		if(!isEmpty())
			return stackArray[top];//�鿴ջ����������
		else
			return 0;//����0��ʾջû�в�����������޷��鿴
	}
	
	public  boolean isEmpty() {
		return (top == -1);//�ж�top�Ƿ�Ϊ-1���ж�ջ�Ƿ�Ϊ��
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
