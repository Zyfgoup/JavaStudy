package 访问者;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 19:24
 */
public interface Order {

     void accept(OrderVisitor vistor);
}
