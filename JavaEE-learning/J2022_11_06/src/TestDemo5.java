public class TestDemo5 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //注意跳出，中断后由于线程在sleep所以会触发异常
                        break;
                    }
                }
            }
        };

        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt(); //中断

        System.out.println("3s后main线程中断thread运行");
    }
}
