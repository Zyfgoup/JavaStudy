package A;

//线程通信。如下的三个关键字使用的话，都得在同步代码块或同步方法中。
//wait():一旦一个线程执行到wait()，就释放当前的锁。
//notify()/notifyAll():唤醒wait的一个或所有的线程
//使用两个线程打印 1-100. 线程1, 线程2 交替打印

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
		
		t1.setName("甲");
		t2.setName("乙");
		
		t1.start();
		t2.start();
	}
}
