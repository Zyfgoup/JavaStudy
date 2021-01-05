package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:30
 */
public class OverseasOrder implements Order {
    private  double orderAmount;
    private  double additionalSH;

    public OverseasOrder(double orderAmount, double additionalSH) {
        this.orderAmount = orderAmount;
        this.additionalSH = additionalSH;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public double getAdditionalSH() {
        return additionalSH;
    }

    @Override
    public void accept(OrderVisitor vistor) {
        vistor.visit(this);
    }
}
