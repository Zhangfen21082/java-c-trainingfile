package threading;

class MyThread extends Thread{
    @Override
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
}

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        while(true) {
            System.out.println("这是main线程");
            Thread.sleep(1000);
        }
    }
}
