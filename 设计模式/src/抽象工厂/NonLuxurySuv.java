package 抽象工厂;



/**
 * @Author Zyfgoup
 * @Date 2020/4/1 15:50
 */
public class NonLuxurySuv implements Suv{

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
        return "非奢侈Suv";
    }
}
