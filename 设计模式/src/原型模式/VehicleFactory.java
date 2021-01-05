package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 15:51
 * @description 汽车工厂类
 */
    public class VehicleFactory {
        Car car;
        Suv suv;

        public VehicleFactory(Car car,Suv suv){
            this.car = car;
            this.suv = suv;
        }


        //返回原型的浅复制对象  只能复制基本数据类型 如果对象里含有其他引用 只是拷贝引用
    //调用Clone方法要实现Cloneable接口 返回的是Object类
    public Car getCar() throws CloneNotSupportedException {
        return (Car)car.clone();
    }



    public Suv getSuv() throws CloneNotSupportedException {
        return (Suv)suv.clone();
    }


}
