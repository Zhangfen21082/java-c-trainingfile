package singletonPattern;

import java.util.Random;

class MyBlockingQueue{
    private int[] items = new int[1000];
    private volatile int head = 0;
    private volatile int tail = 0;
    private volatile int size = 0;

    //入队列
    public void put(int elem) throws InterruptedException {
        synchronized (this) {
            while (size == items.length) {
                // 队列满，阻塞等待
                this.wait();
            }
            items[tail] = elem;
            tail++;
            if (tail >= items.length) {
                tail = 0;
            }
            size++;
            // 通知消费者消费
            this.notifyAll();
        }
    }

    //出队列
    public Integer take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                // 队列空，阻塞等待
                this.wait();
            }
            int res = items[head];
            head++;
            if (head >= items.length) {
                head = 0;
            }
            size--;
            // 通知生产者生产
            this.notifyAll();
            return res;
        }
    }
}

public class TestDemo3 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        Thread consumer = new Thread(){
            @Override
            public void run(){
                while(true) {
                    try {
                        int value = myBlockingQueue.take();
                        System.out.println("消费者获取产品：" + value);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        consumer.start();

        Thread producotr = new Thread(){
            Random random = new Random();
            @Override
            public void run(){
                while(true) {
                    try {
                        int value = random.nextInt(1000);
                        myBlockingQueue.put(value);
                        System.out.println("生产者生产产品：" + value);
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        producotr.start();

        consumer.join();
        producotr.join();

    }
}
