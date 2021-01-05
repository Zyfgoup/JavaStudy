package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:02
 */
public abstract class Car implements Cloneable {

    public abstract String getCarName();
    public abstract String getCarFeatures();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
