public class TestDemo {
    static class Result{
        public int sum = 0;
        public final Object lock = new Object();
    }

    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();

        Thread thread = new Thread(){
            @Override
            public void run(){
                int sum = 0;
                for(int i = 1; i <= 1000; i++){
                    sum += i;
                }
                synchronized (result.lock){
                    result.sum  = sum;
                    result.lock.notify();
                }
            }
        };
        thread.start();

        synchronized (result.lock){
            while(result.sum == 0){
                result.lock.wait();
            }
        }

        System.out.println("sum:" + result.sum);

    }
}
