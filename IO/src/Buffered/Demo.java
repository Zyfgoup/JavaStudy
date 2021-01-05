package Buffered;

import java.io.*;

/**
 * @Author Zyfgoup
 * @Date 2020/4/7 19:26
 * @description 使用缓冲字符流对文件进行复制
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("b.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("copyb.txt"));

        String s;
        while((s = br.readLine()) != null){
            bw.write(s);

            //相当于bw.write("\r\n") 但是会在最后一行末尾多个换行符
           bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();

    }
}
