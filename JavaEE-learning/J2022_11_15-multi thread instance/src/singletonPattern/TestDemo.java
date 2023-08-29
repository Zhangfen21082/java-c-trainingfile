package singletonPattern;


class Singleton{
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
    //构造方法私有化
    private Singleton(){}
}

public class TestDemo {
    public static void main(String[] args) {
        //单例
        Singleton instance = Singleton.getInstance();
        //下面写法会被禁止
        //Singleton instance = new Singleton();
    }
}
