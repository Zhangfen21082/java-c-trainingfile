import java.util.Scanner;

class Counter{
    public volatile int tickets = 100000;
    public void decrease(){
        tickets--;
    }
}

public class TestDmmo3 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 50000; i++){
                    counter.decrease();
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 50000; i++){
                    counter.decrease();
                }
            }
        };
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("counter: " + counter.tickets);



    }
}
