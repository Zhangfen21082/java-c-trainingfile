package ioc;

public class Bottom {
    private Tire tire;

    public Bottom(Tire tire) {
        // 传入一个Tire对象给Bottom
        this.tire = tire;
    }
    public void init () {
        // 依赖轮胎
        tire.init();
        System.out.println("初始化底盘");

    }
}
