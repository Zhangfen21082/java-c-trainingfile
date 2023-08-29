public class TestDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
          @Override
          public void run(){
              for(int i = 0; i < 10; i++){
                  try {
                      System.out.println(this.getName() + "存活中");
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
              }
              System.out.println(this.getName() + "即将死亡");

          }
        };
        System.out.println("【线程创建后情况：】");
        System.out.println("获取线程ID：" + thread.getId());
        System.out.println("获取线程名称：" + thread.getName());
        System.out.println("获取线程优先级：" + thread.getPriority());
        System.out.println("获取线程状态：" + thread.getState());
        System.out.println("判断是否为后台线程：" + thread.isDaemon());
        System.out.println("判断线程是否存活：" + thread.isAlive());
        System.out.println("判断是否被中断：" + thread.isInterrupted());

        thread.start();

    }
}
