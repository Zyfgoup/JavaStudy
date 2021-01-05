package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 15:49
 */
public class LuxurySuv extends Suv {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSuvName() {
        return name;
    }

    @Override
    public String getSuvFeatures() {
        return "奢侈Suv";
    }
}
