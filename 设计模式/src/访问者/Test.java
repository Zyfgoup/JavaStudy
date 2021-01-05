package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:37
 * @description 访问者模式的测试类
 * 最复杂的设计模式，并且使用频率不高，《设计模式》的作者评价为：大多情况下，你不需要使用访问者模式，但是一旦需要使用它时，那就真的需要使用了。
 *
 * 访问者模式是一种将数据操作和数据结构分离的设计模式。（觉得太抽象，可以看下面的例子）。
 * 各角色职责分离，符合单一职责原则

 * 通过在Order接口定义的accept方法来接收访问者的访问  在具体的Order实现类中实现accept方法
 * 其实都是调用该访问者的visit方法然后传入本身作为参数
 * 而具体的Visitor的各种visit方法根据传入参数的（Order接口的的各种实现类）类的不同而对不同的对进行不同的操作(访问)
 *
 * 当需要添加一个新的对象 就要在VisitorInterface里定义该visit方法 并且在OrderVisitor里实现该visit方法
 */
public class Test {
    public static void main(String[] args) {
        OrderVisitor visitor = new OrderVisitor();
        Order order1 = new CaliforniaOrder();
        order1.accept(visitor);


    }
}
