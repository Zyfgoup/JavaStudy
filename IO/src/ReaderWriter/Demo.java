package ReaderWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Zyfgoup
 * @Date 2020/4/7 19:14
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        FileWriter fw = new FileWriter("copya.txt");

        char[] c = new char[1024];
        int len;
        while((len = fr.read(c))!= -1){
            // 会自动读取换行 换行在Win中\r\n 算两个字符
            System.out.println(len);

            System.out.println(new String(c,0,len));
            fw.write(c,0,len);
        }

        fw.close();
        fr.close();
    }
}
