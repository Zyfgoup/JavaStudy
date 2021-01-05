package Lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zyfgoup
 * @Date 2020/3/30 14:41
 * @description 解决线程安全问题的第三种方案 Lock
 * 这里使用Lock接口的实现类 ReentranLock  重用锁 就是线程获取过锁后 释放了 再获取的时候不需要重新验证
 * 使用方法：成员变量中定义一个ReentranLock对象
 *          在可能出现线程安全的代码前调用 lock()方法
 *                              后 调用unlock释放锁
 *  建议：lock()方法紧接try{}  unlock()在finally块中调用 这样无论是否异常都会释放锁
 *
 *  ReentranLock的构造方法 默认是创建非公平锁 如果传入true则为公平锁
 */
public class DemoLock {
    public static void main(String[] args ) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
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
                }
                countDownLatch.countDown(); //减一
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
    Lock reentrantLock = new ReentrantLock();
    int sources = 0;

    void add() {

        reentrantLock.lock();
        try{
            sources++;  //int temp = sources+1 ; sources = temp
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }




    }
}

