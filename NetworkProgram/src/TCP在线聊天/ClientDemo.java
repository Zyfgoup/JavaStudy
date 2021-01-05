package TCP在线聊天;

import java.io.*;
import java.net.Socket;

/**
 * @Author Zyfgoup
 * @Date 2020/4/3 17:22
 */
public class ClientDemo  {

    public static void main(String[] args) throws IOException {
        //创建Socket对象 传入对象的IP地址和端口
        Socket socket = new Socket("127.0.0.1",10000);

        //获取输出流 发送信息 注意这里发送信息后 要写结束标记 不然接收端一直在read等待造成阻塞
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());

        //表示消息发送完毕了  不能直接close() 如果close流 那么socket也无法使用了 后面就无法接收信息
        socket.shutdownOutput();

        //接收信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String len;
        while((len = br.readLine())!= null){
            System.out.print(len);
        }

        //释放资源
        br.close();
        is.close();
        outputStream.close();
        socket.close();
    }
}
