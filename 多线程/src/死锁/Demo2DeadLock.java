package 死锁;

/**
 * @Author Zyfgoup
 * @Date 2020/3/31 15:51
 * @description 死锁的解决方案 调整锁的顺序  当我们设置好固定的锁顺序后 有可能因为传入的参数的不同导致死锁
 * 这里的demo使用排序算法来解决  固定s1<s2 不然的话就交换
 */
public class Demo2DeadLock {
    public static void main(String[] args) {
        MySource1 s1 = new MySource1("纸巾",5);
        MySource1 s2 = new MySource1("厕所",3);



//传入资源相反  在内部会判断 按照s1<s2 如果大于会交换
        Thread t1 = new Thread11(s1,s2);
        Thread t2 = new Thread22(s2,s1);

        t1.start();
        t2.start();
        //Thread-0获取的资源MySource{info='纸巾'}
        //Thread-1获取的资源MySource{info='厕所'}  程序一直在运行 死锁了




    }


}


/**
 * 定义一个资源类型
 */
class MySource1 implements Comparable{
    private String info;
    private int order;

    public MySource1(String info,int order) {
        this.info = info;
        this.order = order;
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

    @Override
    public int compareTo(Object o) {
        if(o==null ||!(o instanceof MySource1)){
          throw new RuntimeException("出错");
        }
        MySource1 mySource1 = (MySource1) o;
        return this.order-mySource1.order;
    }
}


class Thread11 extends Thread{
    private MySource1 s1;
    private MySource1 s2;

    public Thread11(MySource1 s1, MySource1 s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        //锁资源之前先判断 这里设置s1都是要小于s2的 如果大于0 则表示s1>s2 则交换
        if(s1.compareTo(s2)>0){
            MySource1 temp = s1;
            s1 =s2;
            s2 = temp;
        }


//采用相同的锁顺序
        synchronized(s1){
            System.out.println(Thread.currentThread().getName()+"先获取的资源"+s1);

            synchronized (s2){
                System.out.println(Thread.currentThread().getName()+"再获取的资源"+s2);
            }
        }

    }
}

class Thread22 extends Thread{
    private MySource1 s1;
    private MySource1 s2;

    public Thread22(MySource1 s1, MySource1 s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        if(s1.compareTo(s2)>0){
            MySource1 temp = s1;
            s1 =s2;
            s2 = temp;
        }


        synchronized(s1){
            System.out.println(Thread.currentThread().getName()+"先获取的资源"+s1);

            synchronized (s2){
                System.out.println(Thread.currentThread().getName()+"再获取的资源"+s2);
            }
        }
    }
}

