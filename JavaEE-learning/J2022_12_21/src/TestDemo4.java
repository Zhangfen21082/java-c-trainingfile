import java.util.concurrent.Semaphore;

public class TestDemo4 {
    public static void main(String[] args) throws InterruptedException {
        // 4个可用资源
        Semaphore semaphore = new Semaphore(4);
        // 连续申请4个资源
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        // 此时资源数目已空， 申请操作将被阻塞
        semaphore.acquire();
        System.out.println("P操作");

        semaphore.release();
        System.out.println("V操作");

    }
}
