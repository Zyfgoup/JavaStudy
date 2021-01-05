/**
 * @Author Zyfgoup
 * @Date 2020/11/13 16:27
 * @Description
 */
public class TestEnumMethod {
    public static void main(String[] args) {
        //通过Pizza调用
        Pizza pizza = new Pizza(Pizza.PizzaStatus.READY);
        System.out.println(pizza.isReady());

    }
}


class Pizza{
    private PizzaStatus status;
    //可以直接定义枚举类  相当于一个成员变量 里面有三个常量
    public enum PizzaStatus{
        ORDERED,
        READY,
        DELIVERED,
    }


    public Pizza(PizzaStatus status){
        this.status = status;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }


    public boolean isReady(){
        return status == PizzaStatus.READY;
    }
}
