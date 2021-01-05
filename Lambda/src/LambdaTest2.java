/**
 * @Author Zyfgoup
 * @Date 2020/7/31 18:04
 * @Description  测试Lambda的省略
 * * 如果小括号内只有一个参数 则小括号可以省略
 *  * 如果大括号里只有一个语句 且无论是否有返回值 都可以省略大括号 return关键字和语句分号
 *  * 需要注意的是 如果要省略这三者 就必须一起省略
 *  只有一条语句则可以省略大括号分号和return
 *  哪怕只是一句return语句 也可以把return省略 只写return的值
 */
public class LambdaTest2 {

    public R1 test(Function<T1,R1> fn){
        return fn.apply( new T1("t22222"));
    }


    public static void main(String[] args) {
        LambdaTest2 lambdaTest2 = new LambdaTest2();

        //f即传入的参数 即上面的name为t222的的对象
        //其实这就是实现接口 apply方法里调用传入的对象的t1方法 而T1类的t1()方法 返回了R1的对象
        //R1 r1 = lambdaTest2.test(f->new R1());

        R1 r1 = lambdaTest2.test(f->f.t1());
        System.out.println(r1);
    }

}
