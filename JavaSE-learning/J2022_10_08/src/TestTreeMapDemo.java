import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMapDemo {
    public static void main(String[] args) {
        Map<String ,Integer> map = new TreeMap<>();

        map.put("hello", 11);
        map.put("world", 22);
        map.put("we", 44);
        map.put("are", 55);
        map.put("friends", 33);
        System.out.println("hello：" + map.get("hello"));
        System.out.println("hello world：" + map.get("hello world"));
        System.out.println("hello：" + map.getOrDefault("hello world", -1)); //如果没有则返回-1
        System.out.println("AllKey：" + map.keySet());  //返回key集合
        System.out.println("AllValues：" + map.values());  //返回value集合
        System.out.println("key-friends是否存在：" + map.containsKey("friends"));
        System.out.println("value-99是否存在：" + map.containsValue(99));

        //Map.Entry示例
        System.out.println("Map.Entry示例-----------------------------------------------");
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet){
            System.out.println("key:" + entry.getKey() + "-" + "value:" + entry.getValue());
        }
    }
}
