package 静态代理;

/**
 * @Author Zyfgoup
 * @Date 2020/4/18 15:10
 * @Description
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy(service);
        proxy.add();
        proxy.query();
    }
}
