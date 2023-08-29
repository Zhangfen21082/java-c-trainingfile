package threading;

public class TestDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(
                () -> {
                    while(true) {
                        System.out.println("lambda表达式Thread");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        thread0.start();

        while(true) {
            System.out.println("这是main线程");
            Thread.sleep(1000);
        }
    }
}
