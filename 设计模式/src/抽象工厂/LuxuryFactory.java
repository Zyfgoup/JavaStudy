package 抽象工厂;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:32
 */
public class LuxuryFactory implements AbstractFactory {
    @Override
    public Car createCar() {
       return new LuxuryCar();
    }

    @Override
    public Suv createSuv() {
        return new LuxurySuv();
    }
}
