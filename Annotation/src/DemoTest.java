import java.lang.annotation.Annotation;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:11
 * @description 通过反射获得注解 并且获取注解的值
 */
public class DemoTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("TestAnnotation");
        Class clazz1 = TestAnnotation.class;
        Annotation[] annotations = clazz1.getAnnotations();
        System.out.println(annotations[0]);


        //获取注解的值 通过注解.class获取注解 要转成注解的类型
        MyAnnotation myAnnotation = (MyAnnotation) clazz1.getAnnotation(MyAnnotation.class);
        String name = myAnnotation.name();
        System.out.println(name);
    }
}
