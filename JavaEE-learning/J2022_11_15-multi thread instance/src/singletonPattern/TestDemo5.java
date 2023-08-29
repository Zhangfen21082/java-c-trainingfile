package singletonPattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

// 描述待执行任务
class MyTask implements Comparable<MyTask>{
    // 要执行的任务
    private Runnable runnable;
    // 什么时间来执行任务（时间戳）
    private long time;

    public MyTask(Runnable runnable, long delay){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    //注意比较
    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time - o.time);
    }
}

// 描述定时器
class MyTimer{
    //任务队列
    private BlockingQueue<MyTask> tasks_queue = new PriorityBlockingQueue<>();
    //使线程等待固定时间
    private Object locker = new Object();

    public MyTimer(){
        //扫描线程，扫描队首任务
        Thread scan_thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (locker) {
                        try {
                            MyTask task = tasks_queue.take();
                            long currentIime = System.currentTimeMillis();
                            //如果当前队首任务已经到店，则执行
                            if (task.getTime() <= currentIime) {
                                task.getRunnable().run();
                            } else {
                                //否则放回原队列等待
                                tasks_queue.put(task);
                                locker.wait(task.getTime() - currentIime);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        scan_thread.start();
    }

    public void schedule(Runnable runnable, long after) throws InterruptedException {
        MyTask myTask = new MyTask(runnable, after);
        tasks_queue.put(myTask);
        synchronized (locker){
            locker.notify();
        }
    }
}

public class TestDemo5 {
    public static void main(String[] args) throws InterruptedException {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到3s");
            }
        }, 3000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到5s");
            }
        }, 5000);

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到7s");
            }
        }, 7000);
    }
}
