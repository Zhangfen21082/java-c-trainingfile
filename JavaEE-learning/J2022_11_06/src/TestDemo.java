public class TestDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread("我的线程通过继承"){
            @Override
            public void run(){
                try {
                    while (true) {
                        System.out.println("this is 我的线程1");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("this is 我的线程2");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
                , "我的线程通过Runnable"  //第二个参数
        );
        thread1.start();
        thread2.start();
    }
}
