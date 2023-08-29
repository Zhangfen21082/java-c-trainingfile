package singletonPattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class MyThreadPool{
    //使用阻塞队列组织任务
    private BlockingQueue<Runnable> mission_queue = new LinkedBlockingDeque<>();

    //submit用于将任务提交至mission_queue
    public void submit(Runnable runnable) throws InterruptedException {
        mission_queue.put(runnable);
    }

    //线程池创造时，创造出n个线程
    public MyThreadPool(int n){
        for(int i = 0; i < n; i++){
            Thread thread = new Thread(){
                @Override
                public void run(){
                    while(true) {
                        try {
                            //线程创建出来就去任务队列获取任务
                            Runnable runnable = mission_queue.take();
                            runnable.run();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            };
            thread.start();
        }
    }
}

public class TestDemo7 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool threadPool = new MyThreadPool(10);
        for(int i = 0; i < 1000; i++){
            int taskId = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程为" + Thread.currentThread().getName() + "正在执行任务" + taskId);
                }
            });
        }
    }
}
