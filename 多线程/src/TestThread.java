

/*
 * ����һ�����̣߳����1-100֮����Ȼ���������ͬ���أ����߳�ִ��ͬ���Ĳ���
 * �������̵߳ĵ�һ�ַ�ʽ���̳�java.lang.Thread��
 */
//1.����һ���̳���Thread������
class SubThread extends Thread{
	//2.��дThread���run()����.������ʵ�ִ����߳�Ҫ��ɵĹ���
	public void run(){
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName() +":" + i);
		}
	}
}

public class TestThread {
	public static void main(String[] args) {
		//3.��������Ķ���
		SubThread st1 = new SubThread();
		SubThread st2 = new SubThread();

		//4.�����̵߳�start()���������̣߳�������Ӧ��run()����
		//һ���߳�ֻ�ܹ�ִ��һ��start()
		//����ͨ��Threadʵ��������run()ȥ����һ���߳�
		st1.start();
		
		//st.start();
		//st.run();
		st2.start();
		
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName() +":" + i);
		}
	}
}
