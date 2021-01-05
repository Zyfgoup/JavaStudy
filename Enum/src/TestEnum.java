/**
 * @Author Zyfgoup
 * @Date 2020/11/13 16:04
 * @Description
 */
public class TestEnum {

    public static void main(String[] args) {
        //传入对应的值 生成对应的对象
        System.out.println(PizzaStatus.valueOf("DELIVERED"));


        //获取所有的枚举对象
        PizzaStatus[] values = PizzaStatus.values();
        for(PizzaStatus pizzaStatus :values){
            System.out.println(pizzaStatus);
        }



        //每一个值都是一个PizzaStatus对象
        System.out.println(PizzaStatus.DELIVERED.getClass()); //class PizzaStatus

        System.out.println(PizzaStatus.DELIVERED.name().getClass()); //class String

        System.out.println(PizzaStatus.DELIVERED.ordinal()); //2  下标从0开始
    }

}

enum PizzaStatus{
    ORDERED,
    READY,
    DELIVERED,
}
