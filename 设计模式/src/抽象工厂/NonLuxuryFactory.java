package 抽象工厂;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:33
 */
public class NonLuxuryFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return  new NonLuxuryCar();
    }

    @Override
    public Suv createSuv() {
        return new NonLuxurySuv();
    }
}
