package JavaSE;

/**
 * @Author Zyfgoup
 * @Date 2020/9/4 19:57
 * @Description
 */
public class TestIntegerCache {
    public static void main(String[] args) {

        //new出来的就是一个新的对象  Integer i = 100 这才是用到了常量池   -128到127
        Integer i = new Integer(100);
        Integer i1 = new Integer(100);

        System.out.println(i == i1);
    }
}
