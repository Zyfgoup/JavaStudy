package 单例模式;

/*
 *饿汉式 。
 */
public class SingleTon {
	private static SingleTon INSTANCE = new SingleTon();
	
	private SingleTon() {}
	
	public static SingleTon getInstance() {
		return INSTANCE;
	}
}
