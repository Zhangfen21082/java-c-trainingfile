import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    // 构造DatagramSocket
    private DatagramSocket socket = null;

    public UDPServer(int port) throws SocketException {
        // 服务端需要绑定一个端口号
        socket = new DatagramSocket(port);
    }

    // 服务端启动
    public void start() throws IOException {
        System.out.println("服务器启动！");
        // 服务端随时等待接收客户端请求
        while (true) {
            /*
                 1. 接受请求并解析
                    构造一个DatagramPacket对象requestPacket用于接受客户端发来的数据报，保存在byte[]
                    为了方便查看信息，需要使用 requestPacket的getData()方法将其转换为String
             */
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            /*
                2. 拿到客户端的请求request后，将其交给一个方法process进行处理，process方法会返回响应response
             */
            String response = process(request);
            /*
                3. 将响应回复给客户端
                   构造一个DatagramPacket对象responsePacket用于给客户端回复响应response ，response是String
                   所以需要使用用getBytes()方法将其转化为byte[]
                   客户端发来的requestPacket数据报中携带有客户端的Ip地址和端口号，使用getSocketAddress()获得
             */
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);

            // 打印信息
            System.out.println("【客户端IP: " + requestPacket.getAddress().toString()
                    + "客户端口号：" + requestPacket.getPort() + "】"
                    + "：\"" + request + "\"" + ", 服务端回复: " + "\"" + response + "\"");
        }
    }

    // 回显服务器，客户端发什么服务端就回复什么
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        // 服务端监听9090端口
        UDPServer server = new UDPServer(9090);
        server.start();
    }
}
