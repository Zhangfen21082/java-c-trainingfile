
/*public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(25);
        myArrayList.add(456);
        myArrayList.add(54);
        myArrayList.add(44);
        myArrayList.add(89);
        myArrayList.display();
        myArrayList.add(4,67);
        myArrayList.display();
        System.out.println(myArrayList.get(4));
        System.out.println(myArrayList.indexOf(67));
    }
}*/

/*import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("JavaSE");
        list.add("JavaWeb");
        list.add("JavaEE");
        list.add("JVM");
        list.add("软件测试");
        System.out.println(list);
        System.out.println("获取list中有效元素个数：" + list.size());

        System.out.println("获取索引为2上的元素：" + list.get(2));

        list.set(2, "Javaee");
        System.out.println("设置索引为2上的元素为Javaee：" + list);

        list.add(2, "java数据结构");
        System.out.println("在list的索引为2处插入Java数据结构：" + list);

        list.remove("JVM");
        System.out.println("删除list中的JVM：" + list);

        list.remove(1);
        System.out.println("删除list中索引为1处的元素：" + list);

        System.out.println("坚持list中是否存在数据库这个元素？" + list.contains("数据库"));

        System.out.println("从后往前查找Javaee第一次出现的位置：" + list.indexOf("Javaee"));

        List<String> ret = list.subList(1, 3);
        System.out.println("使list中[1,3)之间的元素构成一个新的List返回：" + ret);

        list.clear();
        System.out.println("清空list并打印其大小：" + list.size());
    }
}*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(68);
        list.add(91);
        list.add(53);
        list.add(44);

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();


        List<List<Integer>> ret = new ArrayList<List<Integer>>(10);
        System.out.println(ret);
    }
}