package A;

class A {
	public synchronized void foo(B b) {//����A�Ķ���a
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.last();
	}

	public synchronized void last() {//����A�Ķ���a
	}
}

class B {
	public synchronized void bar(A a) {//����B�Ķ��� b
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.last();
	}

	public synchronized void last() {//����B�Ķ��� b
		
	}
}

public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();

	public void init() {
		a.foo(b);
	}

	public void run() {
		b.bar(a);
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		new Thread(dl).start();
		dl.init();
	}
}
