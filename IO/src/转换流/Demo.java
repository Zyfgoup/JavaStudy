package 转换流;

import java.io.*;

/**
 * @Author Zyfgoup
 * @Date 2020/4/7 22:21
 * @description 可以将字节与字符之间进行转换 并且可以根据编码格式不同
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d.txt")));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copyd.txt")));


        String s;
        while((s = br.readLine()) != null){
            bw.write(s);
            bw.newLine();
        }
        //bw.flush();

        //关闭流也会刷新缓冲区 但是会把流关闭了
        bw.close();
        br.close();

    }
}
