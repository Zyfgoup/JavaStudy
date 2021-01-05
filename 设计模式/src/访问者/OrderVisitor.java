package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:32
 */
public class OrderVisitor implements VisitorInterface {

    //所有订单的总额
    private double orderTotal;

    public double getOrderTotal() {
        return orderTotal;
    }

    @Override
    public void visit(NonCaliforniaOrder nco) {
        orderTotal += nco.getOrderAmount();
    }

    @Override
    public void visit(CaliforniaOrder co) {
        orderTotal += (co.getOrderAmount()+co.getAdditionalTax());
    }

    @Override
    public void visit(OverseasOrder oo) {
        orderTotal += (oo.getOrderAmount()+oo.getAdditionalSH());
    }
}
