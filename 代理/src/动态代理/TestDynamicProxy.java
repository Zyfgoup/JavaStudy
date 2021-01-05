package 动态代理;

/**
 * @Author Zyfgoup
 * @Date 2020/4/18 15:20
 * @Description
 */
public class TestDynamicProxy {

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        ObjectInvocationHandler handler = new ObjectInvocationHandler();
        handler.setTarget(service);
        //$Proxy0 cannot be cast to 动态代理.UserServiceImpl
        //不能基于类的代理
        //UserServiceImpl proxy = (UserServiceImpl) handler.getProxy();

        //要用接口来接收
        UserService proxy = (UserService) handler.getProxy();


        proxy.add();
        proxy.query();
    }
}
