package 构造者模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:20
 */
public class TestBuilder {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilderA();
        Director director = new Director(builder);

        //创建
        director.build();

        Animal animal = (Animal)builder.getObject();
        System.out.println(animal.name);
    }
}
