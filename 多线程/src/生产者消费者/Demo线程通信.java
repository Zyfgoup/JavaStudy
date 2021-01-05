package 生产者消费者;

import javafx.beans.binding.ObjectExpression;

/**
 * @Author Zyfgoup
 * @Date 2020/3/30 15:54
 * @description wait()的线程放弃对象锁 等待notify()/notifyAll()唤醒
 * 这三个方法都必须在同步块或者代码当中使用
 * 唤醒之后进入线程等待，重新获取cpu
 * notify的wait的线程 使用的对象锁必须为同一个  调用必须用在设置对象锁的对象上
 * 所以demo的wait notify通过baozi.来调用
 */
public class Demo线程通信 {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();

        //传入同一个包子 在同步代码块中作为锁
        Thread baozipu = new Baozipu(baozi);
        Thread customer = new Customer(baozi);

        baozipu.start();
        customer.start();
    }
}

class Baozi{

    boolean flag; //表示包子有没有被做好

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


}

class Baozipu extends  Thread{
    Baozi  baozi;

    public Baozipu(Baozi baozi){
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (baozi) {

                //如果包子做好了 那么包子铺就休息 wait
                if (baozi.flag == true) {
                    try {
                       baozi.wait();
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
                    baozi.setFlag(true);
                    System.out.println("包子做好了 叫醒消费者吃包子");
                    baozi.notify(); //唤醒消费者吃包子了
                }
            }
        }
    }
}

class Customer extends Thread{
    Baozi baozi;

    public Baozi getBaozi() {
        return baozi;
    }

    public void setBaozi(Baozi baozi) {
        this.baozi = baozi;
    }

    public Customer(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (baozi) {
                if (baozi.flag == true) {
                    System.out.println("消费者吃包子");

                    baozi.setFlag(false);
                    System.out.println("包子吃完了，叫醒包子铺继续做包子");
                    baozi.notify();//唤醒包子铺要做包子了

                } else {
                    //包子没做好 那就等待
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
