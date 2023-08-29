import java.util.PriorityQueue;


class People implements Comparable<People>{
    public int age;

    public People(int age){
        this.age = age;
    }
    @Override
    public int compareTo(People p){
        return this.age - p.age;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        PriorityQueue<People> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new People(13));
        priorityQueue.offer(new People(27));
        priorityQueue.offer(new People(99));
        priorityQueue.offer(new People(19));
        priorityQueue.offer(new People(7));
        System.out.println("最小年龄是：" + priorityQueue.peek().age + "岁");
    }
}

















/*public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {4, 1, 9, 2, 8, 9, 9, 7, 3, 6 ,5};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int e : arr){
            priorityQueue.offer(e);
        }
        System.out.println("打印优先级队列" + priorityQueue);
        System.out.println("打印优先级队列中有效元素个数" + priorityQueue.size());
        System.out.println("获取优先级最高的元素" + priorityQueue.peek());
        priorityQueue.poll();
        System.out.println("删除两个优先级最高的元素然后再次获取" + priorityQueue.peek());
        System.out.println("判断优先级队列是否为空" + priorityQueue.isEmpty());
        priorityQueue.clear();
        System.out.println("清空优先级队列并判空" + priorityQueue.isEmpty());
    }
}*/
