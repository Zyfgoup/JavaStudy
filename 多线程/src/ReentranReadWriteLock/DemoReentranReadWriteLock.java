package ReentranReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Zyfgoup
 * @Date 2020/3/30 15:23
 * @description ReentranReadWriteLock 可以给程序加读锁 写锁 但是只允许线程同时读 只有读操作时效率比较高
 */
public class DemoReentranReadWriteLock {

    public static void main(String[] args) {
        Storage1 storage1 = new Storage1();

        Thread r1 = new Thread(()->{
            try {
                storage1.get("zyf");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread r2 = new Thread(()->{
            try {
                storage1.get("zzz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread w1 = new Thread(()->{
            try {
                storage1.put("ZYF","大邹");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread w2 = new Thread(()->{
            try {
                storage1.put("ff","发发");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //并发读 如果是可以并发 那么就是穿插执行的
//        Thread-1开始获取数据...
//        Thread-0开始获取数据...
//        Thread-0获取的数据是：邹
//        Thread-1获取的数据是：邹邹邹
//        r1.start();
//        r2.start();

        //并发读写  一个线程执行完 才能执行另外一个
//        r1.start();
//        w1.start();

        //并发写 一个线程写完才能写另外一个
        w1.start();
        w2.start();

    }








}

class Storage1{
   ReentrantReadWriteLock lock  = new ReentrantReadWriteLock();

    Map<String,String> map = new HashMap<>();

    {
        map.put("zyf","邹");
        map.put("zzz","邹邹邹");
    }

    public void get(String key) throws InterruptedException {
        lock.readLock().lock();//加读锁

        String result = null;
        System.out.println(Thread.currentThread().getName()+"开始获取数据...");
        Thread.sleep(10);
        //为了方便把异常抛出了
        result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"获取的数据是："+result);


        // 要在finally
        lock.readLock().unlock();
    }

    public void put (String key,String value) throws InterruptedException {
        lock.writeLock().lock();//加读锁


        System.out.println(Thread.currentThread().getName()+"开始写数据...");
        Thread.sleep(10);
        //为了方便把异常抛出了
       map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"数据写完");


        // 要在finally
        lock.writeLock().unlock();
    }
}
