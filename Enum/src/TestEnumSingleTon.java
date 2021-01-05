/**
 * @Author Zyfgoup
 * @Date 2020/11/13 16:48
 * @Description
 */
public class TestEnumSingleTon {
    public static void main(String[] args) {
        Resource resource1 = singleTonUtil.instance.getInstance();
        Resource resource2 = singleTonUtil.instance.getInstance();
        System.out.println(resource1==resource2);
    }

}

class Resource{

}

 enum singleTonUtil{
    instance;
    private Resource resource = new Resource();
    public Resource getInstance(){
        return resource;
    }
}
