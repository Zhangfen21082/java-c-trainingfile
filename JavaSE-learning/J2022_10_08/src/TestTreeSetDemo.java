import java.util.*;

public class TestTreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("peach");
        set.add("banana");

        System.out.println("打印：" + set);
        System.out.println("返回set大小：" + set.size());
        System.out.println("判断\"melon\"是否存在：" + set.contains("melon"));
        set.remove("peach");
        System.out.println("删除\"peach\"：" + set);

        //迭代器
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + "-");
        }
        System.out.println();
    }
}
