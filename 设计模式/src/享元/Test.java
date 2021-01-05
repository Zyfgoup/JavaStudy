package 享元;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:10
 * @descrption 测试类
 * 享元：假如一个类需要频繁的创建的对象，对象的某些成员变量都是固定的 例如一个公司的员工  公司名等都是固定的
 * 就可以把这些固定的内在信息单独形成一个享元类 并且为单例模式 因为成员变量都是固定的内在数据 那么就单例就可以给其他使用了
 * 1种情况是 把享元类的对象作为某个类的成员变量 但是这样仍然要创建很多的对象 但是相比一开始不需要那么多开销了
 * 还有一种情况 本Demo：将外在信息作为参数传入享元类中的某个方法来使用 这样就只需要一个享元类的对象通过调用方法就可以进行操作了
 *
 */
public class Test {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory  = FlyweightFactory.getFlyweightFactory();
        FlyweightIntr flyweightIntr = flyweightFactory.getFlyweightIntr("North");
        flyweightIntr.print("Zyf","CEO");
    }
}
