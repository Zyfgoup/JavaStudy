package 活锁;

/**
 * @Author Zyfgoup
 * @Date 2020/3/31 16:17
 * @description 活锁就是线程之间相互礼让锁 最后谁都拿不到锁 解决方案可以设置一定的礼让次数 过了就主动拿起
 */
public class DemoSurvivorLock {

    public static void main(String[] args) {
        WC wc = new WC();

        new Thread(()->{
            wc.setName("二狗");
            wc.doIt("二狗","山炮");
        }).start();

        new Thread(()->{
            wc.setName("山炮");
            wc.doIt("山炮","二狗");
        }).start();
    }
}

class WC {
    int count =0; //礼让5次就上厕所
    private String name;//表示当前要上厕所的人
    private boolean isNeed = true;

    public void  setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    /**
     * 上厕所的方法
     *
     */
    public synchronized  void doIt(String preName,String otherName){
        //一直判断是否需要上厕所
        while(isNeed){

            //通信时 wait()的判断用while 防止虚假唤醒
            //如果上厕所的人和允许上厕所的人不是同一个则等待
            while(!name.equals(preName)){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 如果是 则礼让另外一个人先上
            if(otherName!=null&&!otherName.equals("")&& count<5){
                count++;//礼让次数+1
                this.name = otherName; //换成另外一个人上厕所的名字
                System.out.println(preName+"对"+otherName+"说：我不急你先上吧");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notifyAll(); //唤醒
            }else{
                System.out.println(preName+"上厕所了");
                isNeed = false;

                //资格让给另外一个人
                //上完了叫其他人可以继续上了
                this.name  = otherName;
                this.notifyAll();
            }


        }
    }
}



