import java.util.concurrent.atomic.AtomicInteger;

public class TestDemo3 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);

        Thread thread1= new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 50000; i++){
                    // 相当于count++
                    count.getAndIncrement();
                }
            }
        };
        Thread thread2= new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 50000; i++){
                    // 相当于count++
                    count.getAndIncrement();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("count:" + count.get());
    }
}
