package JavaSE;

import java.util.concurrent.TimeUnit;

/**
 * @Author Zyfgoup
 * @Date 2020/7/31 19:15
 * @Description  谁调用join方法就谁先执行完再执行其他线程 如果是指定时间 则执行该时间片段再变为并行
 * yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
 */



public class Testjoin  extends  Thread{

    public static void main(String[] args) throws InterruptedException {

        Testjoin testjoin = new Testjoin();


        Thread t1 = new Thread(() -> {
            System.out.println("自定义线程");
        });

        yield();


        System.out.println("主线程");


    }



}
