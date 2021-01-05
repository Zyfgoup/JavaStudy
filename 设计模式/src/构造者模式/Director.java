package 构造者模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:19
 */
public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }


    //调用builder进行创建实例
    public void build(){
        builder.create();
    }
}
