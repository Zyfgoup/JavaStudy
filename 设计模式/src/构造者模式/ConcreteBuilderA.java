package 构造者模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:15
 */
public class ConcreteBuilderA implements Builder {

    Animal animal = null;

    @Override
    public Object getObject() {
        return animal;
    }

    @Override
    public void create() {
        animal = new Animal();
        animal.setName("猴子");
        animal.setWeight(30.2);
    }
}
