package 静态代理;

/**
 * @Author Zyfgoup
 * @Date 2020/4/18 15:01
 * @Description
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("add a user");
    }

    @Override
    public void query() {
        System.out.println("query all user");
    }
}
