package JavaSE;

/**
 * @Author Zyfgoup
 * @Date 2020/9/4 19:52
 * @Description
 * 使用内部类 可以扩展单继承 内部类也可以继承别的
 * 内部类也可以有更好的封装
 */
public class OuterClass extends FatherClass {
    static int i =1;
    private int b = 5;

    public OuterClass(){
        System.out.println("outerClass 空参构造器");
    }
    OuterClass(int a){
        System.out.println(a);
    }

    protected OuterClass(String a){
        System.out.println(a);
    }

    private OuterClass(boolean b){
        System.out.println(b);
    }


    /**静态内部类可以声明静态变量 可以使用外部类的静态变量、方法
     * 创建对象时不需要外部类了
     *
     *
     */
    static class InnerClass extends Father1Class{
        static int i = 0;
    }

    /**
     * 内部类可以使用 public protected default private 修饰符 外部类只能是public 或者是 default
     * 成员内部类中可以随便使用外部类成员变量、方法（包括静态）
     * 如果变量重名  默认使用内部类定义的
     * 如果要使用外部类定义的需要OuterClass.this.xxx  静态变量就是Outer.xxx
     **/
   class InnerClass1{

        int i= 2;

        public InnerClass1(){
            System.out.println(i);
            System.out.println(OuterClass.i);
        }
    }


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("a");
        outerClass.methodInnerClass();

        //静态内部类的初始化方法 3种方式都可以
        //InnerClass innerClass = new OuterClass.InnerClass();
        //OuterClass.InnerClass innerClass1 = new OuterClass.InnerClass();
        //InnerClass innerClass = new InnerClass();


        //普通内部类的初始化方法
        //InnerClass1 innerClass11 = outerClass.new InnerClass1();


        /**
         * 匿名内部类不能有静态变量或方法
         * 把匿名内部类看成是实现接口或者继承父类的子类  所以子类的都适用于匿名内部类
         * 比如无法访问父类为private的成员或者变量
         */
        OuterClass outerClass1 = new OuterClass(){
            int a = 10;


            @Override
            public void test(){
                System.out.println("匿名内部类的方法");
                System.out.println(i);
                //System.out.println(b); 无法访问父类的private
            }
        };

        outerClass1.test();
    }

    protected void testProtected(){
        System.out.println("父类的testPro...");
    }

    public void test(){
        System.out.println("父类的test");
    }

    public void methodInnerClass(){

       final int a = 5; //常量
       int b = 4;//局部变量

        /**
         * 方法内部类  方法里定义 所以权限修饰符不可用
         * JDK1.7以前只能访问常量 不能访问方法的局部变量
         * 1.8后局部变量也可以访问了  编译以后可以发现把引用的外部局部变量改成final修饰了
         */
        class InnerClass{

           int c=2;
           public void print(){
               System.out.println(a+" "+b+" "+c);
           }

       }

       InnerClass innerClass = new InnerClass();
       innerClass.print();
    }

}


