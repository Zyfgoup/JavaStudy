
public class MyArray {
	private long[] arr;
	//表示有效数据的长度
	private int elements;
	
	public MyArray() {
		arr = new long[50]; //固定50
	}
	
	public MyArray(int maxSize) {
		arr = new long[maxSize];
	}
	
	//添加数据
	public void insert(long value) {
		arr[elements++] = value; //记住elements也要++
	}
	
	//显示数据
	public void display() {
		System.out.print("{");
		for(int i=0;i<elements;i++) {
			System.out.print(arr[i]);
		}
		System.out.print("}");
		System.out.println();
	}
	
	//查找数据 根据值 返回的是索引值
	
	public int search(long value) {
		int i;//i的声明放在外面，才能返回索引
		for(i=0;i<elements;i++) {
			if(arr[i] == value)
				break;
		}
		if(i == elements) //等于长度则未找到
			return -1;
		else
			return 1;
	}
	
	//查找数据 根据索引 返回的是值
	public long get(int index) {
		if(index>=elements||index<0)
			throw  new ArrayIndexOutOfBoundsException();
		else
			return arr[index];
	}
	
	//删除数据 根据值
	public void delete(long value) {
		int i;
		for(i=0;i<elements;i++) {
			if(arr[i] == value)
				break;
		}
		//从i开始 后面的元素往后移  所以下标只要到elements-1
		//不减一也行 因为长度比较长 后面都是0没有影响
		for(int j=i;j<elements-1;j++) {
			arr[j] = arr[j+1];
		}
		elements--; //关键记得也要--
	} 
	
	//更新数据
	 public void change(int index,long value) {
		 if(index>=elements || index<0) {
			 throw new ArrayIndexOutOfBoundsException();
			 
		 }else {
			 arr[index] = value;
		 }
	 }
}
