package JavaSE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/7/6 12:37
 * @Description
 */
public class Test1 {

    static List list = new ArrayList();

    static List getList(){
        return list;
    }

    public static void main(String[] args) {
        list.add("a");
        list.add("b");
        for(Object o:getList()){
            System.out.print(o);
        }
    }
}
