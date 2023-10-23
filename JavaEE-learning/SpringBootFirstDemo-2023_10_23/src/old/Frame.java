package old;

public class Frame {
    private Bottom bottom;

    public Frame() {
        bottom = new Bottom();
    }

    public void init() {
        // 车身需要依赖底盘
        bottom.init();
        System.out.println("初始化车身");
    }
}
