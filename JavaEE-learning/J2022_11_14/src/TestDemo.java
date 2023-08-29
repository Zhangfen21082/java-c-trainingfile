

public class TestDemo {
    public static void main(String[] args) {
        //准备一个对象，需要保证wait和notify是同一个对象
        Object object = new Object();

        //第一个线程，进行wait操作
        Thread t1 = new Thread("t1"){
            @Override
            public void run(){
                while(true){
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName() + "进入并占用锁，持续3s");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            System.out.println(Thread.currentThread().getName() + "等待并释放锁");
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("等待结束," + Thread.currentThread().getName() + "重新获取到锁");
                    }
                }
            }
        };
        t1.start();

        //第二个线程，进行notify
        Thread t2 = new Thread("t2"){
            @Override
            public void run(){
                while(true){
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName() + "进入并占用锁，持续3s");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName() + "进行notify");
                        object.notify();

                        System.out.println("notify完成，让" + Thread.currentThread().getName() + "歇3s");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    System.out.println(Thread.currentThread().getName() + "已处在synchronized外，再歇10s");
                    try {
                        Thread.sleep(12000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };

        t2.start();
    }
}
