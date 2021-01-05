package 抽象工厂;


/**
 * @Author Zyfgoup
 * @Date 2020/4/1 15:47
 */
public class LuxuryCar implements Car {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCarName() {
        return name;
    }

    @Override
    public String getCarFeatures() {
        return "奢侈汽车";
    }
}
