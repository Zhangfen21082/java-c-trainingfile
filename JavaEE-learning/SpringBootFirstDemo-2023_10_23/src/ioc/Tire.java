package ioc;

public class Tire {
    private int size = 20;
    private String color= "red";

    public Tire(int size, String color) {
        this.size = size;
        this.color = color;
    }
    public void init() {
        System.out.println("初始化轮胎 "  + "【size：" + size + "；color：" + color+ "】");
    }
}
