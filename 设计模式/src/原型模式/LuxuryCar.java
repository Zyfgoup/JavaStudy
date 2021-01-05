package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 15:47
 */
public class LuxuryCar extends Car {
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
