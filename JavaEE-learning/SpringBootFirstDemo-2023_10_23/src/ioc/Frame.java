package ioc;

public class Frame {
    private Bottom bottom;

    public Frame(Bottom bottom) {
        this.bottom = bottom;
    }
    public void init() {
        // 依赖底盘
        bottom.init();
        System.out.println("初始化底盘");
    }
}
