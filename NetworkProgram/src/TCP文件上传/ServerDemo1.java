package TCP文件上传;

import javafx.collections.WeakMapChangeListener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Zyfgoup
 * @Date 2020/4/3 18:05
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("image\\copy.jpg"));

        int b ;
        while((b = bis.read())!=-1){
            bos.write(b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("文件传输完成");
        bw.newLine();
        bw.close();

        bw.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
