package DemoTest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Zyfgoup
 * @Date 2020/11/9 14:13
 * @Description
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        test();

        //执行n  执行一个任务 减一  而 await方法就是等到减到0才去执行后面的
        //但是这里没有进行减1  所以会一直阻塞在这里
        new CountDownLatch(1).await();
        System.out.println("22222222222222");

    }

    public static void test() throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("11111111111");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
