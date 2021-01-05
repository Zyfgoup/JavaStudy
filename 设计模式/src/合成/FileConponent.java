package 合成;

/**
 * @Author Zyfgoup
 * @Date 2020/4/9 18:36
 * @description 表示文件类  重写返回文件大小的方法 直接返回文件的大小
 */
public class FileConponent extends FileSystemComponent {
    private long size;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public FileConponent(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public long getComponentSize() {
        return size;
    }
}
