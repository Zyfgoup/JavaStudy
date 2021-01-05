package synchronize;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author Zyfgoup
 * @Date 2020/3/30 14:27
 *@description 解决线程安全问题的两个方法 synchronized 同步代码块 同步方法
 * synchronized修饰方法时  将访问共享资源的代码集合成一个方法 给该方法使用synchronized
 * 在这个demo中 访问共享资源的方法就是add()
 *
 * 同步代码块仍然是在add()方法 但是是在方法里
 *
 * 需要注意的是使用的都是要同一个对象锁
 * 同步方法的对象锁是this 就是new出来的Storage1的实例
 * 同步代码块这里我使用的是类的class属性 其实就是编译后的字节码class文件对象
 * 当静态同步方法时  也是使用类的class的属性作为对象锁的
 *
 * 当有两个方法都是同步方法，两个线程分别调用两个方法 那么只有当一个线程调用完才能轮到另外一个线程 因为使用的是同一个对象锁 this
 * 如果一个是静态同步 一个是同步 两个线程分别调用 那么是可以交叉执行的 也就是并发 因为对象锁不同
 */
public class DemoSynchronized {
    public static void main(String[] args ) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        Storage1 storage1 = new Storage1();

        /*
        Lambda表达式(jdk1.8以后)
        ()表示Runnable接口里的run方法的参数列表 为空则为空
        ->表示将参数列表的传递到后面的代码
        {}代码块
        其实等价于
         new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
         */
        for(int i = 0;i<100;i++){
            new Thread(()->{
                for (int j = 0; j <10 ; j++) {
                    storage1.add();
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown(); //减一
                }
            }).start();  //记住要start();


        }

        countDownLatch.await();
        //这里输出的时候 不一定100个线程都执行了才输出 有可能主线程先执行到这里了 所以要用
        System.out.println(storage1.sources);
        //如果不出现问题为1000 出现并发后就小于1000
        //因为sources++分两步 如果A线程执行到第一步temp=sources+1就让出cpu B线程获得cpu也sources++完
        // 再回到A 再sources=temp
        //此时两个线程都sources++ 但是sources只加了一


    }
}




class Storage1 {
    int sources = 0;

//     synchronized  void add(){
////        sources++;  //int temp = sources+1 ; sources = temp
////    }

    void add(){
        synchronized (Storage1.class){
            sources++;
        }
    }
}