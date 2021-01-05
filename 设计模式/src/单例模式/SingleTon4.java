package ����ģʽ;
/*
 * ��̬�ڲ�����ŵ��ǣ��ⲿ�����ʱ������Ҫ���������ڲ��࣬�ڲ��಻��������ȥ��ʼ��INSTANCE��
 * �ʶ���ռ�ڴ档����SingleTon��һ�α�����ʱ��������Ҫȥ����SingleTonHoler��ֻ�е�getInstance()������һ�α�����ʱ��
 * �Ż�ȥ��ʼ��INSTANCE,��һ�ε���getInstance()�����ᵼ�����������SingleTonHoler�࣬���ַ���������ȷ���̰߳�ȫ��
 * Ҳ�ܱ�֤������Ψһ�ԣ�ͬʱҲ�ӳ��˵�����ʵ������
 */

public class SingleTon4 {
	
	private SingleTon4() {}
	
	
	private static class SingleTon4Holder{
		static {
			System.out.println("��̬����ڲ���ʼ��");
		}
		
		private static SingleTon4 INSTANCE = new SingleTon4();
	}
	
	public static SingleTon4 getInstance() {
		return SingleTon4Holder.INSTANCE;
	}
	
	public static void main(String[] args) {
		System.out.println(SingleTon4.getInstance());
	}
}
