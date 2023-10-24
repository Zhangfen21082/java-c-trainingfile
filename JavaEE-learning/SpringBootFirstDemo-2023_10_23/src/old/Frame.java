package old;

public class Frame {
    private Bottom bottom;

    public Frame(int size) {
        bottom = new Bottom(size);
    }

    public void init() {
        // 车身需要依赖底盘
        bottom.init();
        System.out.println("初始化车身");
    }
}
