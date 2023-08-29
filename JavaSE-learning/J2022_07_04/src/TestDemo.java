/*

*/
/*
class WashMachine{
    //成员变量
    public String brand;//品牌
    public String type;//型号
    public String weight;//重量
    public String length;//长
    public String width;//宽
    public String height;//高
    public String color;//颜色

    //成员方法
    public void WashCloths(){
        //洗衣服功能
    }
    public void DryCloths(){
        //脱水功能
    }
    public void SetTime(){
        //定时功能
    }
}*//*


class PetDog {
    public String name;//名字
    public String color;//颜色

    public void barks() {
        System.out.println(name + "：旺旺旺");
    }

    public void wag() {
        System.out.println(name + "：摇尾巴");
    }
}


public class TestDemo {
    public static void main(String[] args) {
        PetDog dogHuang = new PetDog();
        PetDog dogHei = new PetDog();
        dogHuang.name = "阿黄";
        dogHuang.color = "黄色";
        dogHei.name = "阿黑";
        dogHei.color = "黄色";
        dogHuang.barks();
        dogHuang.wag();
        dogHei.barks();
        dogHei.wag();
    }
}


*/



/*
public class Date {
    public int year;
    public int month;
    public int day;

    //无参构造
    public Date() {
        this(1999, 1, 1);//会调用带有三个参数的
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void showDate(){
        System.out.println(this.year + " " + this.month + " " + this.day);
    }
    public static void main(String[] args) {
        Date d1 = new Date();
        d1.showDate();
    }
}*/

import static jdk.nashorn.internal.objects.Global.print;

public class TestDemo {
    private int a;//只能在本类内访问
    int b;//default属性
    public int c;

    public TestDemo(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static void main(String[] args) {
        TestDemo t = new TestDemo(1, 2, 3);
    }
}


