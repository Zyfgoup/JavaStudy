package 静态代理;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Zyfgoup
 * @Date 2020/4/18 15:02
 * @Description UserService的代理类 同样实现UserService接口 注入
 */
public class UserServiceProxy implements UserService {
    UserService service;

    //注入业务实现类
    public UserServiceProxy(UserService service) {
        this.service = service;
    }

    //具体业务由业务实现类来实现 但是业务中增加新的操作可以通过代理类来实现
    @Override
    public void add() {
        log("add");
        service.add();
    }

    @Override
    public void query() {
        log("query");
        service.query();
    }

    public void log(String msg){
        System.out.println("调用了"+msg+"方法"+new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));

    }
}
