package threading;

public class TestDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                //匿名内部类
                new Runnable() {
                    @Override
                    public void run() {
                        while(true) {
                            System.out.println("这是MyRunnable线程");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );
        thread.start();

        while(true) {
            System.out.println("这是main线程");
            Thread.sleep(1000);
        }
    }
}
