package 网易笔试;

import JavaSE.OuterClass;

/**
 * @Author Zyfgoup
 * @Date 2020/9/4 23:20
 * @Description
 */
public class TestOuterClassProtected  extends OuterClass {

    protected TestOuterClassProtected(String a){
        super(a);
        System.out.println(a);
    }


    //子类与父类不在同一个包中时  子类中可以访问继承下来的protected方法
    //但是如果通过父类对象则无法访问  原因是 只有子类或者同包下才能访问 protected
    //这里创建一个父类对象的话 既不是子类也不是同包下
    public static void main(String[] args) {
       TestOuterClassProtected testOuterClassProtected = new TestOuterClassProtected("a");
         testOuterClassProtected.testProtected();

         OuterClass outerClass = new OuterClass();
         //outerClass.testPr...   编译错误
    }

    @Override
    protected void testProtected(){
        System.out.println("aaaaaaaa");
    }



}
