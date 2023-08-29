import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UDPTranslateServer extends UDPServer{
    // 查询字典
    private Map<String, String> dict = new HashMap<>();
    public UDPTranslateServer(int port) throws SocketException {
        super(port);
        dict.put("cat", "猫");
        dict.put("dog", "狗");
        dict.put("pig", "猪");
        dict.put("wolf", "狼");

    }

    // 重写process方法实现查询词典功能
    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "没有这个词");
    }

    public static void main(String[] args) throws IOException {
        UDPTranslateServer udpTranslateServer = new UDPTranslateServer(9090);
        udpTranslateServer.start();
    }
}
