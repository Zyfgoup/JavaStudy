package 享元;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:54
 * @descrption 外部数据作为方法的参数传入 这样就更加不需要创建很多对象了
 */
public interface FlyweightIntr {

    String getCompany();
    String getAddress();
    String getCity();
    String getState();
    String getZip();
    void print(String name,String title);
}
