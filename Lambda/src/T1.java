/**
 * @Author Zyfgoup
 * @Date 2020/7/31 18:06
 * @Description
 */

public class T1 extends R1 {

    public T1(String name){
        this.name = name;
    }

    public T1 t1(){
        System.out.println("t1方法");
        T1 t1 = new T1("t1111");
        return t1;
    }

}
