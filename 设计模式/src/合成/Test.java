package 合成;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:45
 * @description 测试类
 * 合成模式：设计一个公共的接口 类似（getComponentSize）既能给单独组件或者复合组件使用
 */
public class Test {
    public static void main(String[] args) throws CompositeException {
        FileSystemComponent mainFolder = new DirComponent("Year2020");
        FileSystemComponent subFolder1 = new DirComponent("Jan");
        FileSystemComponent subFolder2 = new DirComponent("Feb");

        FileSystemComponent folder1File1 = new FileConponent("Jan1DataFile.txt",3000);
        FileSystemComponent folder1File2 = new FileConponent("Jan2DataFile.txt",2000);
        FileSystemComponent folder2File1 = new FileConponent("Feb1DataFile.txt",3000);
        FileSystemComponent folder2File2 = new FileConponent("Feb2DataFile.txt",3456);

        mainFolder.addComponent(subFolder1);
        mainFolder.addComponent(subFolder2);

        subFolder1.addComponent(folder1File1);
        subFolder1.addComponent(folder1File2);

        subFolder2.addComponent(folder2File1);
        subFolder2.addComponent(folder2File2);

        System.out.println("MainFolder.size = "+mainFolder.getComponentSize());
        System.out.println("Feb.size = "+subFolder2.getComponentSize());
    }
}
