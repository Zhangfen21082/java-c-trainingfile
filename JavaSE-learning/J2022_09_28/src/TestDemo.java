import java.util.LinkedList;
import java.util.Queue;

public class TestDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(12);
        q.offer(34);
        q.offer(56);
        q.offer(78);
        q.offer(90);

        System.out.println("获取队头元素：" + q.peek());
        q.poll();
        System.out.println("出队2个元素再获取队尾元素：" + q.peek());
        System.out.println("判断队列是否为空：" + q.isEmpty());
    }
}
