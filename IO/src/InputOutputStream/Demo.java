package InputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author Zyfgoup
 * @Date 2020/4/7 19:04
 * @description 用字节输入输出流实现文件的复制
 */
public class Demo {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("c.txt");

        //后面的参数表示是否要续写 而不是覆盖源文件
        FileOutputStream fos = new FileOutputStream("copy.txt",true);

        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
        }

        fos.close();
        fis.close();
    }
}
