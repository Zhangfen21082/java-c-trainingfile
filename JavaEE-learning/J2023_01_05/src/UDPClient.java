import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    DatagramSocket socket = null;
    // 客户端需要指定好服务端的IP和端口号，然后构建一个Socket地址
    private SocketAddress ADDRESS = null;

    public UDPClient(String serverIP, int serverPort) throws SocketException {
        ADDRESS = new InetSocketAddress(serverIP, serverPort);
        socket = new DatagramSocket();
    }

    // 客户端启动
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 读取客户端用户输入
            System.out.print("input: ");
            String request = scanner.next();

            /*
                2. 发送请求给服务端
                   构造一个DatagramPacket对象requestPacket用于给服务端发送数据报，注意需要将String转换为byte[]
                   同时传入服务端的ADDRESS(ip地址和port)
             */
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                   ADDRESS);
            socket.send(requestPacket);

            // 3. 从服务端获取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());

            // 打印信息
            System.out.println("服务端回复：" + response);

        }
    }

    public static void main(String[] args) throws IOException {
        UDPClient client = new UDPClient("127.0.0.1", 9090);
        client.start();
    }
}
