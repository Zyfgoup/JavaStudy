package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Zyfgoup
 * @Date 2020/4/18 15:24
 * @Description 抽象的动态代理类 传入任何业务都可以 方便公共业务的增加
 */
public class ObjectInvocationHandler implements InvocationHandler {
    //需要代理的业务实现类
    private Object target;




    public void setTarget(Object target){
        this.target = target;
    }

    //调用Proxy类的静态方法获取传入的业务类的代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());

        //通过反射调用客户端传入的业务实现类
        Object result = method.invoke(target,args);
        return result;
    }


    //
    public void log(String msg){
        System.out.println("调用了"+msg+"方法"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));

    }
}
