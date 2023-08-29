import java.util.concurrent.CountDownLatch;

public class TestDemo5 {
    public static void main(String[] args) throws InterruptedException {
        // 10个任务
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for(int i = 0; i < 10; i++){
            //创建10个线程分别执行这10个任务
            Thread thread = new Thread(){
                @Override
                public void run(){
                    System.out.println("任务开始" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("任务结束" + Thread.currentThread().getName());
                    // 任务完成
                    countDownLatch.countDown();
                }
            };
            thread.start();
        }

        // 阻塞等待所有线程执行任务完毕
        countDownLatch.await();
        System.out.println("结束！");

    }
}
