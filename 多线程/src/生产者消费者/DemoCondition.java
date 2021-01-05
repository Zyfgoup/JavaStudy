package 生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Zyfgoup
 * @Date 2020/3/31 17:31
 * @description 使用Condition实现精准唤醒
 */
public class DemoCondition {
    public static void main(String[] args) {
        Coder coder = new Coder();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                coder.step1();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                coder.step2();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                coder.step3();
            }
        }).start();
    }
}

class Coder{
    int status =1 ; //表示该执行哪个步骤

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void step1(){
        lock.lock();


        //如果不是1 则睡觉
        if(status!=1){
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("1.编写源代码");
        status = 2;
        //执行完后 则将status改为2  表示下面要执行第2步
        //指定唤醒第2个监视器
        condition2.signal();

        lock.unlock();
    }


    public void step2(){
        lock.lock();

        if(status!=2){
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("2.编译成字节码文件");

        //改为3  唤醒3
        status = 3;
        condition3.signal();

        lock.unlock();
    }

    public void step3(){
        lock.lock();

        if(status!=3){
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("3.执行字节码文件");
        status=1;
        condition1.signal();

        lock.unlock();
    }
}
