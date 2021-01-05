package 合成;


/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:28
 * @description 表示一个文件或者文件夹
 */
public abstract class FileSystemComponent {
    String name;

    public FileSystemComponent(String name){
        this.name = name;
    }

    /**
     * 文件夹能添加文件夹或者文件 在抽象类中都统一抛出异常
     * 这样如果FIleSystemComponent的对象在不是文件夹的实现类对象时 调用这些方法就会抛出异常
     * 而在子类文件夹类中就要实现方法
     * @param f
     */
    public void addComponent(FileSystemComponent f) throws CompositeException{

        throw new CompositeException("Inbalid Operation: NOt Supported");
    }

    public FileSystemComponent getComponent(int index) throws CompositeException{

        throw new CompositeException("Inbalid Operation: NOt Supported");
    }

    public abstract long getComponentSize();
}
