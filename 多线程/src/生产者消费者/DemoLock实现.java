package 生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zyfgoup
 * @Date 2020/3/31 17:13
 * @description 使用Lock来实现生产者消费者  此时用Condition来await() signal()
 * Condition 相比Object的 可以实现精准唤醒
 */
public class DemoLock实现 {
    public static void main(String[] args) {
        Baozi1 baozi1 = new Baozi1();

        //传入同一个包子 在同步代码块中作为锁
        Thread baozipu1 = new Baozipu1(baozi1);
        Thread customer1 = new Customer1(baozi1);

        baozipu1.start();
        customer1.start();
    }
}

class Baozi1{

    boolean flag; //表示包子有没有被做好
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


}

class Baozipu1 extends  Thread{
    Baozi1  baozi1;

    public Baozipu1(Baozi1 baozi1){
        this.baozi1 = baozi1;
    }

    @Override
    public void run() {
        while(true) {

            baozi1.lock.lock();
            //如果包子做好了 那么包子铺就休息 wait
            if (baozi1.flag == true) {
                try {
                   baozi1.condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                //没做好 那么就做包子
                System.out.println("包子铺正在做包子，需要3秒");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baozi1.setFlag(true);
                System.out.println("包子做好了 叫醒消费者吃包子");
                baozi1.condition.signal(); //唤醒消费者吃包子了

                //解锁
                baozi1.lock.unlock();
            }
        }
        }

}

class Customer1 extends Thread {
    Baozi1 baozi1;

    public Baozi1 getBaozi() {
        return baozi1;
    }

    public void setBaozi(Baozi1 baozi1) {
        this.baozi1 = baozi1;
    }

    public Customer1(Baozi1 baozi1) {
        this.baozi1 = baozi1;
    }

    @Override
    public void run() {
        while (true) {
            baozi1.lock.lock();
            if (baozi1.flag == true) {
                System.out.println("消费者吃包子");

                baozi1.setFlag(false);
                System.out.println("包子吃完了，叫醒包子铺继续做包子");
                baozi1.condition.signal();//唤醒包子铺要做包子了

            } else {
                //包子没做好 那就等待
                try {
                   baozi1.condition.await();
                    baozi1.lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        }

}