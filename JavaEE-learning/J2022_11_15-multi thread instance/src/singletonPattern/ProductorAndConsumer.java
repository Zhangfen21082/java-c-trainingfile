package singletonPattern;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProductorAndConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<Integer>();
        Thread productor = new Thread(){
            Random random = new Random();
            @Override
            public void run(){
                while(true) {
                    try {
                        if(blockingDeque.size() <= 5){
                            int product = random.nextInt(1000);
                            System.out.println("生产者生产产品：" + product);
                            //入队列，每1s产生一个产品
                            blockingDeque.put(product);
                        }else{
                            System.out.println("队列已满请消耗完再放入");
                        }

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread consumer = new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        //出队列，每2s消耗一个产品
                        int value = blockingDeque.take();
                        System.out.println("消费者消费产品：" + value);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };

        productor.start();
        consumer.start();

        productor.join();
        consumer.join();
    }
}
