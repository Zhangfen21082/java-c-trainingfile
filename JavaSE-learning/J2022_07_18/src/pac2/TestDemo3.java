package pac2;

import pac1.TestDemo;

public class TestDemo3 extends TestDemo {

    public void func2(){
        System.out.println(super.a);
    }
    public static void main(String[] args) {
        TestDemo test_demo = new TestDemo();
        //System.out.println(super.a);
        test_demo.func();
    }
}
