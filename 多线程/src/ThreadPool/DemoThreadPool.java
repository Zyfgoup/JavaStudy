package ThreadPool;

import java.util.concurrent.*;

/**
 * @Author Zyfgoup
 * @Date 2020/3/30 16:26
 * @description 线程池
 * 使用Executors的newFixedThreadPool方法不好  在任务很多的的情况下会造成阻塞队列溢出
 * 因为使用LinkedBlockingQueue 但是队列最大值为Integer.MAX_VALUE
 * 速度持续大余任务处理速度，会造成队列大量阻塞。因为队列很大，很有可能在拒绝策略前，内存溢出。是其劣势
 *
 *
 */
public class DemoThreadPool {
    public static void main(String[] args) {
        /**
         * corePoolSize 核心线程池 即在没有任务需要执行的时候线程池的大小，并且只有在工作队列满了的情况下才会创建超出这个数量的线程
         * maximumPoolSize 最大线程池大小
         */
        ExecutorService executor = new ThreadPoolExecutor(10, 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10));


        //pool-1-thread-1
        executor.submit(()->{
            System.out.println(Thread.currentThread().getName());
        });

        //pool-1-thread-2
        executor.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
    }
}
