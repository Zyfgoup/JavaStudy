package A;

//ģ���վ��Ʊ���ڣ���������������Ʊ����Ʊ��Ϊ100��
//�����̵߳İ�ȫ����--->ʹ��ͬ������鴦��
class Window3 extends Thread {
	static int ticket = 100;
	static Object obj = new Object();

	public void run() {
		while (true) {
			// synchronized (this) {//�ڱ������У�this��ʾ��w1,w2,w3
			synchronized (obj) {
				// show();
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "��Ʊ��Ʊ��Ϊ��" + ticket--);
				}
			}
		}
	}

	public synchronized void show() {// this�䵱����
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

public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();

		w1.setName("����1");
		w2.setName("����2");
		w3.setName("����3");

		w1.start();
		w2.start();
		w3.start();

	}

}
