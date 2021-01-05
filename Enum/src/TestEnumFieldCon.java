import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @Author Zyfgoup
 * @Date 2020/11/13 16:40
 * @Description
 */
public class TestEnumFieldCon {



    @Test
    public void test(){
        Pizza1 testPz = new Pizza1();
        testPz.setStatus(Pizza1.PizzaStatus.READY);
        assertTrue(testPz.isReady());

        System.out.println(testPz.getStatus().getTimeToDelivery());
        System.out.println(Pizza1.PizzaStatus.ORDERED.getTimeToDelivery());
    }
}

class Pizza1 {

    private PizzaStatus status;

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public enum PizzaStatus {

        ORDERED (5){

            //重写方法
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        //定义成员变量
        private int timeToDelivery;


        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        //构造方法
        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isReady() {
        return this.status.isReady();
    }

}
