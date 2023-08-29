public class TestDemo7 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("线程1在尝试获取locker1");
                synchronized (locker1){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程1已获取locker1现在尝试获取locker2");
                    synchronized (locker2){
                        System.out.println("线程1获取locker1和locker2成功");
                    }

                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                System.out.println("线程2在尝试获取locker1");
                synchronized (locker1){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("线程2已获取locker1现在尝试获取locker2");
                    synchronized (locker2){
                        System.out.println("线程2获取locker1和locker2成功");
                    }

                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
