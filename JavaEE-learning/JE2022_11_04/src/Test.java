public class Test {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            System.out.println("main线程运行中");
            Thread.sleep(1000);
        }
    }
}
