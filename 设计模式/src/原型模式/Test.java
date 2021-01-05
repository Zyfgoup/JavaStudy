package 原型模式;

/**
 * @Author Zyfgoup
 * @Date 2020/4/1 16:11
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        VehicleFactory vehicleFactory = VehicleManager.getVehicleFactory("NonLuxury");

        Car car = vehicleFactory.getCar();

        //非奢侈汽车
        System.out.println(car.getCarFeatures());

    }
}
