import java.util.ArrayList;
import java.util.List;

public class Order<T> {
	private int age;
	private T t;
	List<T> list=new ArrayList<>();
	
	public void add() {
		list.add(t);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public T getT() {
		return t;
	}
	@Override
	public String toString() {
		return "Order [age=" + age + ", t=" + t + "]";
	}
	public void setT(T t) {
		this.t = t;
	}
}
	//��������static�ķ�����ʹ�÷��͵���������̬�ı��������������ȳ��ֵ�
	//��������try-catch��ʹ�÷��͵�����