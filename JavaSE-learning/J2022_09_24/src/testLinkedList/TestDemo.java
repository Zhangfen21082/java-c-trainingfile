package testLinkedList;

import com.sun.xml.internal.ws.binding.FeatureListUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*public class TestDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println("list初始情况：" + list);

        list.add(0, 0);
        System.out.println("在起始位置插入元素0：" + list);

        list.removeFirst();//和list.remove()等价
        list.removeLast();
        System.out.println("删除第一个元素和最后一个元素：" + list);

        list.remove(3);
        System.out.println("删除index为3处的元素：" + list);

        System.out.println("检测元素5是否存在：" + list.contains(5));

        System.out.println("从前往后找到元素2的位置" + list.indexOf(2));

        System.out.println("获取index为1处的元素：" + list.get(1));

        list.set(1, 99);
        System.out.println("将index为1处的元素设置为99：" + list);

        List<Integer> sub = list.subList(1, 4);
        System.out.println("截取区间[1, 4)中元素并返回为一个新的LinkedList：" + sub);

        list.clear();
        System.out.println("清空list：" + list);
    }
}*/


public class TestDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        list.add(66);
        list.add(77);

        //正向迭代器
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        //反向迭代器
        ListIterator<Integer> rit = list.listIterator(list.size());
        while(rit.hasPrevious()){
            System.out.print(rit.previous() + " ");
        }
        System.out.println();
    }
}