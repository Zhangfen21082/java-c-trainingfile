/*import java.util.Date;

//public class TestDemo {
//    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date.getTime()); //显示时间戳
//    }
//}*/

/*
class Student {
    public String name;
    public int age;
    private static String classes = "三年二班";//类变量

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static String getClasses(Student s){
        System.out.println(s.name);
    }

}
public class TestDemo{
    public static void main(String[] args) {
        System.out.println(Student.getClasses());
    }
}*/


/*
public class TestDemo {

    public void fun(){

    }
    public static void main(String[] args) {
        //先实例化再调用
        TestDemo test = new TestDemo();
        test.fun();
    }
}*/
/*public class Student {
    public String name;
    public int age;


    public static String classes = "三年一班";

    public Student(){
        System.out.println("构造函数运行");
    }

    //实例代码块
    {
        this.name = "张三";
        this.age = 18;
        System.out.println("实例代码块运行");
    }

    //静态代码块
    static{
        classes = "三年二班";
        System.out.println("静态代码块运行");
    }

    public static void main(String[] args) {
        System.out.println(Student.classes);
    }
}*/

class OuterClass {
    public int outer_a = 1;
    public int outer_b = 2;

    class InnerClass{
        public int outer_a = 11;
        public int inner_a = 3;
        public int inner_b = 4;

        public InnerClass(){
            System.out.println("实力内部类构造方法");
        }
        public void InnerFunc(){
            System.out.println("实例内部类普通方法：" + "outer_a（外部）=" + OuterClass.this.outer_a);
        }
    }
}



