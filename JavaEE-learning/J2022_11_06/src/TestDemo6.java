public class TestDemo6 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                for(int i = 0; i < 5; i++){
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        thread.start();

        System.out.println("main线程join之前");
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main线程join之后");

    }
}
