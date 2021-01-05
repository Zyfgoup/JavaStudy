package A;

//使用实现Runnable接口的方式，售票
/*
 * 此程序存在线程的安全问题：打印车票时，会出现重票、错票
 * 1.线程安全问题存在的原因？
 *   由于一个线程在操作共享数据过程中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题。
 *   
 * 2.如何来解决线程的安全问题？
 * 	 必须让一个线程操作共享数据完毕以后，其它线程才有机会参与共享数据的操作。
 * 
 * 3.java如何实现线程的安全：线程的同步机制
 * 		
 * 		方式一：同步代码块
 * 		synchronized(同步监视器){
 * 			//需要被同步的代码块（即为操作共享数据的代码）
 * 		}
 * 		1.共享数据：多个线程共同操作的同一个数据(变量)
 * 		2.同步监视器：由一个类的对象来充当。哪个线程获取此监视器，谁就执行大括号里被同步的代码。俗称：锁
 * 		要求：所有的线程必须共用同一把锁！
 * 		注：在实现的方式中，考虑同步的话，可以使用this来充当锁。但是在继承的方式中，慎用this!
 * 
 * 		方式二：同步方法
 * 		
 * 
 */

class Window2 implements Runnable {
	int ticket = 100;// 共享数据
//	Object obj = new Object();
	public void run() {
//		Animal a = new Animal();//局部变量
		while (true) {
			synchronized (this) {//this表示当前对象，本题中即为w
				if (ticket > 0) {
					try {
						Thread.currentThread().sleep(10);//sleep()不会释放锁
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "售票，票号为：" + ticket--);
				}
			}
		}
	}
}

public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}
class Animal{
	
}
