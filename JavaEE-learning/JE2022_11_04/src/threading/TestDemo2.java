package threading;

class MyRunnable implements Runnable{
    @Override
    public void run(){
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

public class TestDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new MyRunnable());
        thread0.start();
        while(true) {
            System.out.println("这是main线程");
            Thread.sleep(1000);
        }
    }
}
