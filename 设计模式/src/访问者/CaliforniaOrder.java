package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:25
 */
public class CaliforniaOrder implements Order {
    private double orderAmount;
    private double additionalTax;

    public CaliforniaOrder(){

    }

    public CaliforniaOrder(double orderAmount, double additionalTax) {
        this.orderAmount = orderAmount;
        this.additionalTax = additionalTax;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalTax() {
        return additionalTax;
    }

    @Override
    public void accept(OrderVisitor vistor) {
        vistor.visit(this);
    }
}
