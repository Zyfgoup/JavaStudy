package BSDemo_Tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Zyfgoup
 * @Date 2020/4/3 18:18
 * @descrition 这里只有服务器 客户端使用浏览器代替
 * 浏览器解析服务器返回的Html页面，页面中如果有图片 那么浏览器就会单独开启一个线程 读取服务器的图片
 * 所以要让服务器一直处于监听状态，客户端请求一次 服务器就回写一次
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while(true){
            Socket accept = serverSocket.accept();

            new Thread(()->{
                try {
                    InputStream is = accept.getInputStream();

                    BufferedReader br = new BufferedReader(new InputStreamReader(is));


                    // GET /NetworkProgram/web/index.html HTTP/1.1
                    String line = br.readLine();
                    System.out.println(line);

                    String[] arr = line.split(" ");


                    String htmlpath =  arr[1].substring(1);

                  //NetworkProgram/web/index.html
                    System.out.println(htmlpath);

                    //创建本地字节输入流 读取该文件
                    FileInputStream fis = new FileInputStream(htmlpath);

                    OutputStream os = accept.getOutputStream();

                    /*
                    HTTP响应也由三个部分组成，分别是：状态行、响应头、空行、响应正文。
                     */

                    //状态行
                    os.write("HTTP/1.1 200 OK\r\n".getBytes());

                    //消息报头
                    os.write("Content-Type:text/html\r\n".getBytes());

                    //空行
                    os.write("\r\n".getBytes());

                    //下面就是响应正文 html
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    while((len = fis.read(bytes))!=-1){
                        os.write(bytes,0,len);
                    }
                    fis.close();
                    accept.close(); //关闭这个也就会关闭那些流
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();


        }


        /*
        GET /NetworkProgram/web/index.html HTTP/1.1
         Host: 127.0.0.1:8080
        Connection: keep-alive
        Upgrade-Insecure-Requests: 1
         */

        //可发现请求的资源路径在第一行 且有空格隔开 那我用空格分割 取1 然后再把第一个
    }
}
