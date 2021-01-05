package TCP文件上传;

import java.io.*;
import java.net.Socket;

/**
 * @Author Zyfgoup
 * @Date 2020/4/3 18:02
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",10000);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("image\\1.jpg"));

        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        int b = 0;
        while((b = bis.read())!= -1){
            bos.write(b);
        }
        //给服务器一个标记 表示文件传输完毕
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String len;
        while((len = br.readLine())!=null){
            System.out.println(len);
        }


        br.close();
        bis.close();
        socket.close();

    }
}
