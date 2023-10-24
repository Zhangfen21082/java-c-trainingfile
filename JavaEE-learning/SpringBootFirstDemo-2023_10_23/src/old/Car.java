package old;

public class Car {
    private Frame frame;

    public Car(int size) {
        frame = new Frame(size);
    }
    public void init() {
        // 车需要依赖车身
        frame.init();
        System.out.println("初始化车");

    }
}
