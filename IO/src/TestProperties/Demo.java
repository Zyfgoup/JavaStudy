package TestProperties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2020/4/7 22:12
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("Zyf","邹永发");

        FileWriter fw = new FileWriter("properties.txt");
        //将Properties集合存储到文件中
        properties.store(fw,"test");

        Properties p2 = new Properties();
        FileReader fr = new FileReader("properties.txt");
        //从文件中将集合读取到Properties集合
        p2.load(fr);

        //获取Key的set集合
        Set<String> stringSet = p2.stringPropertyNames();

        for (String key:stringSet
             ) {
            System.out.println(key+":"+p2.getProperty(key));
        }




    }
}
