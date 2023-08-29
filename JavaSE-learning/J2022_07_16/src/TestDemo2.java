

/*class Base{
    public int a = 1;
    public int b = 2;
    public int c = 3;
}

class Sub extends Base{
    public int a = 11;  //与父类中的a同名且类型相同
    public String b = "Hello";  //与父类中成员b同名，但类型不同

}

public class TestDemo2 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.a);//访问子类中的a
        System.out.println(sub.b);//访问子类中的b
        System.out.println(sub.c);//访问父类中的c
    }
}*/



/*class Base{
    public void method1(){
        System.out.println("父类中的方法1");
    }
    public void method2(){
        System.out.println("父类中的方法2");
    }
}

class Sub extends Base{
    //该方法与父类同名方法构成重载
    public void method1(int a){
        System.out.println("子类中的方法1");
    }
    public void method2(){
        System.out.println("子类中的方法2");
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.method1();//没有传参，访问父类方法
        sub.method1(10);//传参，访问子类方法
        sub.method2();//子类有，则直接访问子类的
    }
}*/



/*class Base{
    int a;
    int b;
    public void method1(){
        System.out.println("父类中的方法1");
    }
    public void method2(){
        System.out.println("父类中的方法2");
    }
}

class Sub extends Base{
    int a;//与父类中的变量a同名且类型相同
    String b;//与父类中的变量b同名但类型不同

    //该方法与父类中的同名方法构成重载
    public void method1(int a){
        System.out.println("子类中的方法1");
    }
    //该方法与父类中的同名方法构成重写
    public void method2(){
        System.out.println("子类中的方法2");
    }

    public void test(){
        //同名成员变量直接访问时，都是子类的
        a = 100;
        b = "Hello";

        //访问父类成员变量是需要借助super关键字
        super.a = 300;
        super.b = 400;

        //对于父类和子类中构成重载的方法，通过参数就可以区别他们
        method1();//父类的
        method1(10);//子类的

        //如果要访问被重写的父类方法，则需要借助super关键字
        method2();//由于被重写，所以访问的永远是子类的
        super.method2();//父类的
    }
}


public class TestJava2 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.test();
    }
}*/




/*class Base{
    int a;
    int b;
    public Base(int a, int b){
        this.a = a;
        this.b = b;
    }
}

class Sub1 extends Base{
    int c;
    public Sub1(int a, int b, int c){
        super(a, b);
        this.c = c;
    }

}
class Sub2 extends Base{
    int c;
    public Sub2(int a, int b, int c){
        super(a, b);
        this.c = c;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Sub1 sub1 = new Sub1(1, 2, 3);
        Sub1 sub2 = new Sub1(4, 5, 3);
        System.out.println(sub1.a);
        System.out.println(sub1.b);
        System.out.println(sub1.c);
        System.out.println(sub2.a);
        System.out.println(sub2.b);
        System.out.println(sub2.c);
    }
}*/



class Base{
    int a;
    int b;
    /*
    public Base(){ 默认或无参
    }

     */
}

class Sub1 extends Base{
    int c;
    /*
    public Sub1(){
        super()  隐含调用
    }
     */
}

