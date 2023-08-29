//class Counter2{
//    public int tickets = 100000;
///*    public void decrease(){
//        synchronized (Counter.class){
//            tickets--;
//        }
//    }*/
//    public synchronized void decrease(){
//        tickets--;
//    }
//}
//
//public class TestDemo {
//    private static Counter counter = new Counter();
//    private static Counter counter2 = new Counter();
//    public static void main(String[] args) throws InterruptedException {
//        //下面两个线程，每个线程都会counter进行5W次自减
//        //正确结果理应为0
//
//        Thread thread1 = new Thread("thread1"){
//            @Override
//            public void run(){
//                for(int i = 0; i < 50000; i++) {
//                    counter.decrease();
//                }
//            }
//        };
//
//        Thread thread2 = new Thread("thread2"){
//            @Override
//            public void run(){
//                for(int i = 0; i < 50000; i++) {
//                    counter.decrease();
//                }
//            }
//        };
//
//        thread1.start();
//        thread2.start();
//
//        thread1.join();
//        thread2.join();
//
//        System.out.println("counter: " + counter.tickets);
//
//    }
//}
