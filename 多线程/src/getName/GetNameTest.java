package getName;

/**
 * @Author Zyfgoup
 * @Date 2020/3/27 17:20
 * @description 获取线程的名字 和获取当前线程
 */
public class GetNameTest {
    public static void main(String[] args) {

        // 主线程就叫做main
        System.out.println(Thread.currentThread().getName());

        new MyThread().start();

    }
}
class MyThread extends  Thread{




    @Override
    public void run() {

        //Thread-0 叫Thread-0 如果还有其他线程就是Thread-1 2 3...
        //Thread[Thread-0,5,main]
        System.out.println(getName());
        System.out.println(Thread.currentThread());
    }
}
