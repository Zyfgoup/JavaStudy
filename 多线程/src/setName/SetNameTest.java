package setName;

/**
 * @Author Zyfgoup
 * @Date 2020/3/27 17:51
 * @description 设置线程的名称  setName 或者在创建线程的时候指定
 */
public class SetNameTest {


    public static void main(String[] args) {

        /*
        使用setName方法  或者在子类中设置一个带参数的构造器
         */
        MyThread myThread = new MyThread();
        myThread.setName("我的线程1");
        System.out.println(myThread.getName());
    }
}

class MyThread extends Thread{
    public MyThread(){

    }

    public MyThread(String name){
        super(name);
    }
}
