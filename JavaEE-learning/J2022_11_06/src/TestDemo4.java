public class TestDemo4 {
    private static boolean Quit = false;//退出标志

    public static void main(String[] args) {
        Thread thread = new Thread(){
           @Override
            public void run(){
               while(!Quit){
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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Quit = true;

        System.out.println("3s后main线程设置标志为true，结束thread运行");
    }
}
