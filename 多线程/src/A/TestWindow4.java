package A;

//ʹ��ʵ��Runnable�ӿڵķ�ʽ����Ʊ
/*
 * �˳�������̵߳İ�ȫ���⣺��ӡ��Ʊʱ���������Ʊ����Ʊ
 * 1.�̰߳�ȫ������ڵ�ԭ��
 *   ����һ���߳��ڲ����������ݹ����У�δִ����ϵ�����£�������̲߳�����������¹������ݴ����˰�ȫ���⡣
 *   
 * 2.���������̵߳İ�ȫ���⣿
 * 	 ������һ���̲߳���������������Ժ������̲߳��л�����빲�����ݵĲ�����
 * 
 * 3.java���ʵ���̵߳İ�ȫ���̵߳�ͬ������
 * 		
 * 		��ʽһ��ͬ�������
 * 		synchronized(ͬ��������){
 * 			//��Ҫ��ͬ���Ĵ���飨��Ϊ�����������ݵĴ��룩
 * 		}
 * 		1.�������ݣ�����̹߳�ͬ������ͬһ������(����)
 * 		2.ͬ������������һ����Ķ������䵱���ĸ��̻߳�ȡ�˼�������˭��ִ�д������ﱻͬ���Ĵ��롣�׳ƣ���
 * 		Ҫ�����е��̱߳��빲��ͬһ������
 * 		ע����ʵ�ֵķ�ʽ�У�����ͬ���Ļ�������ʹ��this���䵱���������ڼ̳еķ�ʽ�У�����this!
 * 
 * 		��ʽ����ͬ������
 * 		�������������ݵķ�������Ϊsynchronized�����˷���Ϊͬ���������ܹ���֤������һ���߳�ִ��
 * 		�˷���ʱ�������߳�����ȴ�ֱ�����߳�ִ����˷�����
 * 		>ͬ������������this
 * 
 * 4.�̵߳�ͬ���ı׶ˣ�����ͬһ��ʱ��ֻ����һ���̷߳��ʹ������ݣ�Ч�ʱ���ˡ�
 * 
 */

class Window4 implements Runnable {
	int ticket = 100;// ��������

	public void run() {
		while (true) {
			show();
		}
	}

	public synchronized void show() {
		
		if (ticket > 0) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "��Ʊ��Ʊ��Ϊ��"
					+ ticket--);
		}

	}
}

public class TestWindow4 {
	public static void main(String[] args) {
		Window4 w = new Window4();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");

		t1.start();
		t2.start();
		t3.start();
	}
}
