import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * @Author Zyfgoup
 * @Date 2020/3/31 16:50
 * @description
 * Lambda三个要素 ()->{}
 * ()是参数列表
 * ->表示给下面的方法体使用
 * {}实现的代码
 *
 * Lambda表示式只适用于接口只有一个实现方法的情况
 * 这种接口都会有一个注释@FunctionalInterface 函数式接口
 *
 * Lambda表示式的省略规则：
 * 如果参数列表为空 那么"()"一定要写 但是参数列表也为空
 * 小括号内的参数类型可以省略
 * 如果小括号内只有一个参数 则小括号可以省略
 * 如果大括号里只有一个语句 且无论是否有返回值 都可以省略大括号 return关键字和语句分号
 * 需要注意的是 如果要省略这三者 就必须一起省略
 */
public class DemoLambda {
    public static void main(String[] args) {
        //实现多线程    结果：Thread-0111
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"111");
        }).start();


        //练习1  无参无返回 结果：做饭
        invokeCook(()->{
            System.out.println("做饭");
        });
        //等价于下面的匿名内部类的形式 但是简化了很多 只关注结果

//        invokeCook(new Cook() {
//            @Override
//            public void makeFood() {
//                System.out.println("做饭");
//            }
//        });



        //练习2 有参数和返回值
        Person[] people = {
                new Person("邹",18),
                new Person("邹永",19),
                new Person("邹永发",20)
        };

        //匿名内部类方式
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        for(Person p:people){
            System.out.println(p);
        }

        System.out.println("lambda表达式形式实现");
        //Lambda表达式
//        Arrays.sort(people,(Person o1,Person o2)->{
//            return o2.getAge()-o1.getAge();
//        });

        //更简洁的Lambda 省略参数类型 只有一个语句 可以省略大括号 return关键字 分号
        Arrays.sort(people,(o1,o2)->o2.getAge()-o1.getAge());



        for(Person p:people){
            System.out.println(p);
        }

    }


    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}

interface Cook{
    void makeFood();
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
