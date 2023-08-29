package TCP3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    // 建立Socket对象
    private Socket socket = null;

    public TCPClient(String serverIP, int serverPort) throws IOException {
        // 指定服务端IP和端口号
        socket = new Socket(serverIP, serverPort);
    }

    // 客户端启动
    public void start () throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                // 1. 获取用户输入
                System.out.print("input: ");
                String request = scanner.next();
                // 2. 发送请求给服务端
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();
                // 3. 从服务端获得响应
                Scanner responseScanner = new Scanner(inputStream);
                String response = responseScanner.next();

                // 打印信息
                System.out.println("服务端回复：" + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TCPClient client = new TCPClient("127.0.0.1", 9090);
        client.start();
    }

}
