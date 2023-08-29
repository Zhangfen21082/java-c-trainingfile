package threading;

public class TestDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            //匿名内部类
            public void run(){
                while(true) {
                    System.out.println("这是MyThread线程");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        thread.start();

        while(true) {
            System.out.println("这是main线程");
            Thread.sleep(1000);
        }
    }
}
