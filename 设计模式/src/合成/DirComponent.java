package 合成;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:38
 * @description 表示文件夹 重写三个方法 添加 获取 和获取文件夹大小
 */
public class DirComponent  extends FileSystemComponent{
    List<FileSystemComponent> list = new ArrayList<>();

    public DirComponent(String name) {
        super(name);
    }

    @Override
    public long getComponentSize() {
        long sizeOfDir = 0;

        //遍历该文件夹里的每个文件夹或者文件的大小 全部加起来 如果里面的文件夹又会调用文件夹的获取大小的方法
        for (FileSystemComponent f:list
             ) {
            sizeOfDir += f.getComponentSize();
        }
        return sizeOfDir;
    }

    @Override
    public FileSystemComponent getComponent(int index) throws CompositeException {
        return list.get(index);
    }

    @Override
    public void addComponent(FileSystemComponent f) throws CompositeException {
        list.add(f);
    }
}
