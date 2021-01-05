package TCP在线聊天;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Zyfgoup
 * @Date 2020/4/3 17:26
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);


        //获取Socket对象
        Socket socket = serverSocket.accept();

        //获取输入流
        InputStream inputStream = socket.getInputStream();

        //收到消息
        int len = 0;
        while ((len = inputStream.read())!=-1){
            System.out.print((char)len);
        }

        //发送信息  要发送中文使用字节流会乱码
        //使用字符缓冲流  OutputStreamWriter是转换流   将字节流转换成字符流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("你是谁？");
        bw.newLine(); //在windows中等于bw.write("\r\n") 回车换行 但是在别的系统上就不是这个意思了 所以使用newLine跨平台
        bw.write("你是谁2？");
        bw.flush();


        //释放资源
        bw.close();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
