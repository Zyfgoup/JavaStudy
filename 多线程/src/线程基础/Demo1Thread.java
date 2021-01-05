package 线程基础;

/**
 * @Author Zyfgoup
 * @Date 2020/3/27 16:58
 * @description 创建线程
 */


public class Demo1Thread {

    /**
     Java启动的main方法就是一个线程
     线程之间是互不影响的 因为每个线程都会开辟一个自己的栈空间
     */
    public static void main(String[] args) {

        //新建一个线程 那么此时这个程序有两个线程
        MyThread myThread = new MyThread();

        //调用start()方法后就会进入runnable状态 然后能拿到cpu时就自动调用run方法
        myThread.start();

        for (int i = 0; i <20; i++) {
            System.out.println("main線程："+ i);

        }

        //两个线程都打印1到20 打印的顺序随机 简单的的说就是看cpu喜欢哪个
        /*
            main線程：0
main線程：1
main線程：2
main線程：3
main線程：4
myThread: 0
myThread: 1
myThread: 2
myThread: 3
myThread: 4
myThread: 5
myThread: 6
myThread: 7
myThread: 8
myThread: 9
myThread: 10
myThread: 11
myThread: 12
myThread: 13
myThread: 14
myThread: 15
myThread: 16
myThread: 17
myThread: 18
myThread: 19
main線程：5
main線程：6
main線程：7
main線程：8
main線程：9
main線程：10
main線程：11
main線程：12
main線程：13
main線程：14
main線程：15
main線程：16
main線程：17
main線程：18
main線程：19
         */

    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("myThread: "+i);
        }
    }
}
