
/*
 * Thread�ĳ��÷�����
 * 1.start()�������̲߳�ִ����Ӧ��run()����
 * 2.run():���߳�Ҫִ�еĴ������run()������
 * 3.currentThread()����̬�ģ���ȡ��ǰ���߳�
 * 4.getName():��ȡ���̵߳�����
 * 5.setName():���ô��̵߳�����
 * 6.yield():���ô˷������߳��ͷŵ�ǰCPU��ִ��Ȩ
 * 7.join():��A�߳��е���B�̵߳�join()��������ʾ����ִ�е��˷�����A�߳�ִֹͣ�У�ֱ��B�߳�ִ����ϣ�
 * A�߳��ٽ���join()֮��Ĵ���ִ��
 * 8.isAlive():�жϵ�ǰ�߳��Ƿ񻹴��
 * 9.sleep(long l):��ʽ���õ�ǰ�߳�˯��l����
 * 10.�߳�ͨ�ţ�wait()   notify()  notifyAll()
 * 
 * �����̵߳����ȼ�
 * getPriority() �������߳�����ֵ 
   setPriority(int newPriority) ���ı��̵߳����ȼ�
   ���ȼ�Խ�ߣ���Խ���ܱ�cpu����ִ�и��̣߳����Ƕ���java�е����ȼ���˵��̫�ɿ���
   ϵͳ�Դ�һ���̵߳����ȼ���java�����ж��߳������õ����ȼ�ֻ�Ǹ�ϵͳһ����ʾһ�����飬
   ����ϵͳ���ɲ����ɾͲ�һ���� 

 */
class SubThread1 extends Thread {
	public void run() {
		for (int i = 1; i <= 100; i++) {
			// try {
			// Thread.currentThread().sleep(1000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			System.out.println(Thread.currentThread().getName() + ":"
					+ Thread.currentThread().getPriority() + ":" + i);
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {

		SubThread1 st1 = new SubThread1();
		st1.setName("���߳�1");
		st1.setPriority(Thread.MAX_PRIORITY);
		st1.start();
		Thread.currentThread().setName("========���߳�");
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":"
					+ Thread.currentThread().getPriority() + ":" + i);
			// if(i % 10 == 0){
			// Thread.currentThread().yield();
			// }
			// if(i == 20){
			// try {
			// st1.join();
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// }
		}
		System.out.println(st1.isAlive());
	}
}
