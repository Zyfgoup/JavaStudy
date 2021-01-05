package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 15:53
 * @description  管理类 返回一个Factory 里面已经装好了原型
 */
public class VehicleManager {

    public static VehicleFactory getVehicleFactory(String features){
        Car car = null;
        Suv suv = null;

        //奢侈类型
        if(features.equals("Luxury")){
           car = new LuxuryCar();
           suv = new LuxurySuv();

        }else if(features.equals("NonLuxury")){
            car = new NonLuxuryCar();
            suv = new NonLuxurySuv();
        }

       return new VehicleFactory(car,suv);
    }
}
