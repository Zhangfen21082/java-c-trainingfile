package TCP2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    // 创建监听套接字
    private ServerSocket listenSocket = null;

    public TCPServer(int port) throws IOException {
        // 监听套接字绑定指定端口
        listenSocket = new ServerSocket(port);
    }

    // 服务器启动
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while (true) {
            // 调用监听套接字的accept()连接客户端，并返回Socket类型的clientSocket
            // 将clientSocket传递给具体处理连接的方法processConnection()进行处理
            // 主线程一直负责监听客户端连接
            Socket clientSocket = listenSocket.accept();
            // 每来一个客户端使用一个线程处理
            Thread thread = new Thread(){
                @Override
                public void run(){
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            thread.start();
        }
    }
    // 用于处理连接
    private void processConnection(Socket clientSocket) throws IOException {
        System.out.println("【客户端IP: " + clientSocket.getInetAddress().toString()
                + "客户端口号：" + clientSocket.getPort() + "】"
                + "已上线");

        // 处理请求
        // 打开inputStream和outputStream
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            while (true) {
                // 1. 读取请求并解析
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    // 如果读完了那么连接可以断开了
                    System.out.println("【客户端IP: " + clientSocket.getInetAddress().toString()
                            + "客户端口号：" + clientSocket.getPort() + "】"
                            + "下线");
                    break;
                }
                String request = scanner.next();
                // 2. 根据请求计算响应，具体处理函数为process
                String response = process(request);

                // 3. 响应回复给客户端
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();

                // 打印信息
                System.out.println("【客户端IP: " + clientSocket.getInetAddress().toString()
                        + "客户端口号：" + clientSocket.getPort() + "】"
                        + "：\"" + request + "\"" + ", 服务端回复: " + "\"" + response + "\"");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭套接字
            // listenSocket在TCP服务端程序中只有一个，所以不太可能把文件描述符占满
            // 而clientSocket 每遇到一个客户端都要创建一个，所以一定要注意关闭
            clientSocket.close();
        }
     }

     // 业务逻辑函数
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer(9090);
        server.start();
    }
}
