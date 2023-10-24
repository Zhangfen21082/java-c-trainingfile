package old;

public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size); // 修改
    }

    public void init() {
        // 底盘需要依赖轮胎
        tire.init();
        System.out.println("初始化底盘");
    }
}
