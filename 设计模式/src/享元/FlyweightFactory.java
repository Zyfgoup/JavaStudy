package 享元;

import java.util.HashMap;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:56
 * @descrption 工厂类 定义成单例
 */
public class FlyweightFactory {
    //内部已创建实例 简单的实现单例
    public static FlyweightFactory flyweightFactory = new FlyweightFactory();
    private HashMap<String,FlyweightIntr> IstFlyweight;

    private FlyweightFactory(){
        IstFlyweight = new HashMap<>();
    }

    public synchronized FlyweightIntr getFlyweightIntr(String divisionName){
        if(IstFlyweight.get(divisionName) == null){
            FlyweightIntr flyweightIntr = new Flyweight(divisionName);
            IstFlyweight.put(divisionName,flyweightIntr);
            return flyweightIntr;
        }else {
            return IstFlyweight.get(divisionName);
        }
    }

    public static FlyweightFactory getFlyweightFactory(){
        return flyweightFactory;
    }


    //内部Flyweight类 实现了FlyweightIntr接口
    private class Flyweight implements FlyweightIntr{
        private  String company;
        private String address;
        private String city;
        private String state;
        private String zip;

        private void setValue(String company,String address,String city,String state,String zip){
            this.city = city;
            this.company = company;
            this.state = state;
            this.address = address;
            this.zip = zip;
        }

        private Flyweight(String divisionName){
            if(divisionName.equals("North")){
                setValue("CMP","addr1","cty1","st1","10000");
            }else if(divisionName.equals("South")){
                setValue("CMP","addr2","cty2","st2","20000");
            }else{
                setValue("0","0","0","0","0");
            }
        }

        @Override
        public String getCompany() {
            return company;
        }

        @Override
        public String getAddress() {
            return address;
        }

        @Override
        public String getCity() {
            return city;
        }

        @Override
        public String getState() {
            return state;
        }

        @Override
        public String getZip() {
            return zip;
        }

        @Override
        public void print(String name, String title) {
            System.out.println(name);
            System.out.println(title);
            System.out.println(getCompany()+","+getAddress()+","+getCity()+","+getState()+","+getZip());
        }
    }

}
