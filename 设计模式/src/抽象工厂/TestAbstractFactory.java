package 抽象工厂;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:34
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new NonLuxuryFactory();
        Suv suv = abstractFactory.createSuv();
        System.out.println(suv.getSuvFeatures());
    }
}
