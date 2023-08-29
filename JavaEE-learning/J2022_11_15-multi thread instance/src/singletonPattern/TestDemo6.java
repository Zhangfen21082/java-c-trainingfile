package singletonPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDemo6 {
    public static void main(String[] args) {
        //没有显式new，是通过Executors类的静态方法完成
        ExecutorService thread_pool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 1000; i++){
            int taskId = i;
            thread_pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程为" + Thread.currentThread().getName() + "正在执行任务" + taskId);
                }
            });
        }
    }
}
