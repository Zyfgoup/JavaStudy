package ����ģʽ;

/*
 * ����ʽ ��ʱ�任�ռ䣬�ڶ��̻߳����´��ڷ��ա�
 */
public class SingleTon2 {
	private static SingleTon2 INSTANCE = null;
	
	private SingleTon2() {}
	
	
	//�����ڶ��߳������ ���ܳ����������ж�Ϊnull ��ȥ����ʵ��
	public static SingleTon2 getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingleTon2();
		}
		return INSTANCE;
	}
}
