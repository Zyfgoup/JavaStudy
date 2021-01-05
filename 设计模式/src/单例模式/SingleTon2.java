package 单例模式;

/*
 * 懒汉式 以时间换空间，在多线程环境下存在风险。
 */
public class SingleTon2 {
	private static SingleTon2 INSTANCE = null;
	
	private SingleTon2() {}
	
	
	//但是在多线程情况下 可能出现两个都判断为null 都去创建实例
	public static SingleTon2 getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingleTon2();
		}
		return INSTANCE;
	}
}
