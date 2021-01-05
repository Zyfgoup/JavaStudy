package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:04
 */
public abstract class Suv implements Cloneable {
    public abstract String getSuvName();
    public abstract String getSuvFeatures();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
