package 死锁;

/**
 * @Author Zyfgoup
 * @Date 2020/3/31 15:36
 * @description 死锁  线程之间争抢的锁成为了一个闭环
 */
public class DemoDeadLock {
    public static void main(String[] args) {
        MySource s1 = new MySource("纸巾");
        MySource s2 = new MySource("厕所");

        Thread t1 = new Thread1(s1,s2);
        Thread t2 = new Thread2(s1,s2);

        t1.start();
        t2.start();
        //Thread-0获取的资源MySource{info='纸巾'}
        //Thread-1获取的资源MySource{info='厕所'}  程序一直在运行 死锁了




    }


}


/**
 * 定义一个资源类型
 */
class MySource{
    private String info;

    public MySource(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MySource{" +
                "info='" + info + '\'' +
                '}';
    }
}


class Thread1 extends Thread{
    private MySource s1;
    private MySource s2;

    public Thread1(MySource s1, MySource s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        //先获取s1 再获取s2
               synchronized(s1){
            System.out.println(Thread.currentThread().getName()+"获取的资源"+s1);

            synchronized (s2){
                System.out.println(Thread.currentThread().getName()+"获取的资源"+s2);
            }
        }

    }
}

class Thread2 extends Thread{
    private MySource s1;
    private MySource s2;

    public Thread2(MySource s1, MySource s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        //先获取s2 再获取s1
        synchronized(s2){
            System.out.println(Thread.currentThread().getName()+"获取的资源"+s2);

            synchronized (s1){
                System.out.println(Thread.currentThread().getName()+"获取的资源"+s1);
            }
        }
    }
}

