package ioc;

public class Car {
    private Frame frame;
    public Car(Frame frame) {
        this.frame = frame;
    }
    public void init() {
        // 依赖车身
        frame.init();
        System.out.println("初始化车身");
    }
}
