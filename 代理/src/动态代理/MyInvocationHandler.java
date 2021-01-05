package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Zyfgoup
 * @Date 2020/4/18 15:13
 * @Description 实现InvocationHandler
 *
 * 每个代理实例都有一个关联的调用处理程序。
 * 当在代理实例上调用方法时，方法调用将被编码并分派到其调用处理程序的invoke方法。
 */
public class MyInvocationHandler implements InvocationHandler {
    private UserService userService;

    public void setUservice(UserService service){
        this.userService = service;
    }

    //调用Proxy类的静态方法获取传入的业务类的代理类
    public UserService getProxy(){
        return(UserService)Proxy.newProxyInstance(this.getClass().getClassLoader(),userService.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());

        //传入userService  客户端传入的业务实现类
        Object result = method.invoke(userService,args);
        return result;
    }

    public void log(String msg){
        System.out.println("调用了"+msg+"方法"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));

    }
}
