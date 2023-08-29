import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用Callable来定义一个任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 1; i <= 1000; i++){
                    sum += i;
                }
                return sum;
            }
        };

        // Thread构造方法不能直接传入Callable，所以需要借助一个中间类
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        // 创建线程执行任务
        Thread thread = new Thread(futureTask);
        thread.start();

        // 获取线程计算结果
        // get方法会阻塞，直到call方法计算完毕
        System.out.println(futureTask.get());
    }
}
