package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:29
 */
public class NonCaliforniaOrder implements Order {
    private double orderAmount;

    public NonCaliforniaOrder(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    @Override
    public void accept(OrderVisitor vistor) {

        vistor.visit(this);



    }
}
