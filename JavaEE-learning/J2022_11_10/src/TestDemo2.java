//public class TestDemo2 {
//    static class Counter3{
//        //第一次加锁
//        public synchronized void decrease(){
//            //第二次加锁
//            synchronized (this){
//
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread thread = new Thread(){
//            @Override
//            public void run(){
//                counter.decrease();
//            }
//        };
//
//        thread.start();
//    }
//}
