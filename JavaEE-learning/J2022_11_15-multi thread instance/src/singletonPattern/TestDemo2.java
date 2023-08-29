package singletonPattern;

class SingletonLazy{
    private static volatile SingletonLazy instance = null;

    public static SingletonLazy getInstance(){
        if(instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }

        }
        return instance;
    }
    //构造方法私有化
    private SingletonLazy(){}
}

public class TestDemo2 {
    public static void main(String[] args) {
        SingletonLazy instance = SingletonLazy.getInstance();
    }
}
