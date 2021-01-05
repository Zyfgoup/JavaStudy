package A;

//�߳�ͨ�š����µ������ؼ���ʹ�õĻ���������ͬ��������ͬ�������С�
//wait():һ��һ���߳�ִ�е�wait()�����ͷŵ�ǰ������
//notify()/notifyAll():����wait��һ�������е��߳�
//ʹ�������̴߳�ӡ 1-100. �߳�1, �߳�2 �����ӡ

class PrintNum2 implements Runnable {
	int num = 1;
	Object obj = new Object();
	public void run() {
		while (true) {
			synchronized (obj) {
				obj.notify();
				if (num <= 100) {
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":"
							+ num);
					num++;
				} else {
					break;
				}
				
				try {
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

public class TestCommunication {
	public static void main(String[] args) {
		PrintNum2 p = new PrintNum2();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		
		t1.setName("��");
		t2.setName("��");
		
		t1.start();
		t2.start();
	}
}
