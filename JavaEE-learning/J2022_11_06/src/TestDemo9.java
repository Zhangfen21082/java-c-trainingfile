
class Counter{
    public int tickets = 100000;
    public void decrease(){
        tickets--;
    }
}

public class TestDemo9 {
    private static Counter counter = new Counter();
    public static void main(String[] args) throws InterruptedException {
        //下面两个线程，每个线程都会counter进行5W次自减
        //正确结果理应为0

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                    for(int i = 0; i < 50000; i++){
                        counter.decrease();
                    }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 50000; i++){
                    counter.decrease();
                }
            }
        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("tickets: " + counter.tickets);

    }
}
