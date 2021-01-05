import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:03
 * @descrption 注解
 *
 *
 * 常用注解 @override重写  @Deprecated表示过时  @SuppressWarnings()将警告消除
 * 几个元注解  用来表示注解的一些含义
 * @Target 表示注解用在哪些地方 例如 @Target(ElementType.METHOD) 表示用在方法上
 * @Retention 表示作用在那些时候 @Retention(RetentionPolicy.RUNTIME) 则表示在运行时也能获取该注解
 * 还有source 源代码 class 编译成class文件后
 *
 *
 * 自定义注解时  用@interface 注解名   在注解中可以有变量 定义方式为： 类型+名字+() 注意要有括号
 * 如果定义的变量有默认值 可以后跟default+默认值
 *
 * 注解就是一个继承自`java.lang.annotation.Annotation`的接口
 */


@MyAnnotation
public class TestAnnotation {


}


/**
 *   @Author Zyfgoup
 *   @Date 2020/4/9 18:03
 *  @descrption 自定义注解
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String name() default "1";
}
