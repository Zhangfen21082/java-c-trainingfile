public class TestDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000_0000; i++){
                    //do nothing
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        System.out.println("【thread.start()之前】");
        System.out.println("thread状态：" + thread.getState());
        System.out.println("main状态：" + Thread.currentThread().getState());

        thread.start();

        System.out.println("【thread.start()之后】");
        System.out.println("thread状态：" + thread.getState());
        System.out.println("main状态：" + Thread.currentThread().getState());

        Thread.sleep(500);

        System.out.println("【main睡眠0.5s之后】");
        System.out.println("thread状态：" + thread.getState());
        System.out.println("main状态：" + Thread.currentThread().getState());

        thread.join();

        System.out.println("【thread.join()之后】");
        System.out.println("thread状态：" + thread.getState());
        System.out.println("main状态：" + Thread.currentThread().getState());

        //结束工作，状态为TERMINGATED
        System.out.println("thread状态：" + thread.getState());
        System.out.println("main状态：" + Thread.currentThread().getState());
    }
}
