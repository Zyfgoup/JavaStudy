package A;

//关于懒汉式的线程安全问题：使用同步机制
//对于一般的方法内，使用同步代码块，可以考虑使用this。
//对于静态方法而言，使用当前类本身充当锁。
class Singleton {
	private Singleton() {

	}

	private static Singleton instance = null;

	public static Singleton getInstance() {
		
		if (instance == null) {
			synchronized (Singleton.class) {
				//静态方法 不能使用this作为锁
				//可以用类本身  Singleton.class
				if (instance == null) {

					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

public class TestSingleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
		// Class clazz = Singleton.class;
	}
}
