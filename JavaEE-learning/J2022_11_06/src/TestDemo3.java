
class myThread extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("hello thread");;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        myThread myThread = new myThread();
        myThread.run();

        while(true){
            System.out.println("hello main");;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
