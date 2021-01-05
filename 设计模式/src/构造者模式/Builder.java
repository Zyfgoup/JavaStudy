package 构造者模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:14
 * @description 如果有多种实例该对象的逻辑，那就每个逻辑构成一个Builder的实现类 在Create中new一个实例然后通过set
 * 方法来设置各种属性等 然后通过调用方法返回实例
 */
public interface Builder {

    //得到对象
    Object getObject();

    //具体实例化
    void create();
}
