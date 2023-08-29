package threading;

public class threadAdvantaged {
    //数字300亿
    public static final long COUNT = 200_0000_0000L;


    public static void main(String[] args) {
        serial_execution();

        concurrency_execution();
    }

    //串行执行
    public static void serial_execution(){
        long begin = System.currentTimeMillis();

        long a = 0;
        for (long i = 0; i < COUNT; i++){
            a++;
        }

        a = 0;
        for (long i = 0; i < COUNT; i++){
            a++;
        }

        long end = System.currentTimeMillis();
        System.out.println("串行执行用时：" + (end - begin) + "ms");
    }

    //并发执行
    public static void concurrency_execution(){
        long begin = System.currentTimeMillis();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        long a = 0;
                        for (long i = 0; i < COUNT; i++){
                            a++;
                        }
                    }
                }
        );
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        long a = 0;
                        for (long i = 0; i < COUNT; i++){
                            a++;
                        }
                    }
                }
        );

        thread1.start();
        thread2.start();

        //阻塞
        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("并发执行用时：" + (end - begin) + "ms");

    }
}
