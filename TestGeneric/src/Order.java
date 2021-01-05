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
	//不可以在static的方法中使用泛型的声明，静态的变量方法都是最先出现的
	//不可以在try-catch中使用泛型的声明