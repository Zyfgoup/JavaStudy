package ����ģʽ;

/*
 *����ʽ ��
 */
public class SingleTon {
	private static SingleTon INSTANCE = new SingleTon();
	
	private SingleTon() {}
	
	public static SingleTon getInstance() {
		return INSTANCE;
	}
}
